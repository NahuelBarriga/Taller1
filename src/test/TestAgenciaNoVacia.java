package test;


import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.ClientePuntaje;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;

public class TestAgenciaNoVacia {

private Agencia agencia;
private Empleador empleador;
private EmpleadoPretenso empleado;
	
	@Before
	public void setUp() throws Exception {
			this.agencia = Agencia.getInstance();
			
			this.empleado = (EmpleadoPretenso)agencia.registroEmpleado("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
			this.empleador = (Empleador)agencia.registroEmpleador("Marcos123", "Marcos123", "Marcos", "223566985", util.Constantes.FISICA,util.Constantes.SALUD);
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE,250000,util.Constantes.JORNADA_COMPLETA,util.Constantes.MANAGMENT,util.Constantes.EXP_MUCHA,util.Constantes.TERCIARIOS, this.agencia.getEmpleados().get("Juan123"));
			this.agencia.crearTicketEmpleador(util.Constantes.HOME_OFFICE,250000,util.Constantes.JORNADA_COMPLETA,util.Constantes.MANAGMENT,util.Constantes.EXP_MUCHA,util.Constantes.TERCIARIOS, this.agencia.getEmpleadores().get("Marcos123"));
			
			this.agencia.getEmpleados().get("Juan123").setPuntaje(4);
			this.agencia.getEmpleadores().get("Marcos123").setPuntaje(5);
			this.agencia.setLimitesRemuneracion(200000, 350000);
			
	}

	@After
	public void tearDown() {
		this.agencia.setEstadoContratacion(false);
		this.agencia.getCoincidencias().clear();
		this.agencia.getComisionesUsuarios().clear();
		this.agencia.getContrataciones().clear();
		this.agencia.getEmpleadores().clear();
		this.agencia.getEmpleados().clear();
		
	}
	
	@Test
	public void testGatillarRondaEstadoVerdaderoEstado() {
		try {
			Empleador empleador2 = (Empleador)this.agencia.registroEmpleador("Guillesky", "Chad", "Guillermo", "223840122", util.Constantes.FISICA,
					util.Constantes.COMERCIO_INTERNACIONAL);
			this.agencia.crearTicketEmpleador(util.Constantes.PRESENCIAL,100000,util.Constantes.JORNADA_EXTENDIDA,util.Constantes.JUNIOR,
					util.Constantes.EXP_NADA,util.Constantes.SECUNDARIOS, empleador2);		
			
			this.empleado.setCandidato(this.empleador);
			this.empleador.setCandidato(this.empleado);			
			this.agencia.setEstadoContratacion(true);
			this.agencia.gatillarRonda();
			
			Assert.assertFalse("No se cambio el estado de contratacion", this.agencia.isEstadoContratacion());			
		}
		catch (Exception e) {
			fail("No deberia fallar la creacion de empleador");			
		}
	}
	
	@Test
	public void testGatillarRondaEstadoVerdaderoContrataciones() {
		try {
			Empleador empleador2 = (Empleador)this.agencia.registroEmpleador("Guillesky", "Chad", "Guillermo", "223840122", util.Constantes.FISICA,
					util.Constantes.COMERCIO_INTERNACIONAL);
			this.agencia.crearTicketEmpleador(util.Constantes.PRESENCIAL,100000,util.Constantes.JORNADA_EXTENDIDA,util.Constantes.JUNIOR,
					util.Constantes.EXP_NADA,util.Constantes.SECUNDARIOS, empleador2);	
			ArrayList<Contratacion> contrataciones = (ArrayList<Contratacion>)this.agencia.getContrataciones().clone();
			
			this.empleado.setCandidato(this.empleador);
			this.empleador.setCandidato(this.empleado);			
			this.agencia.setEstadoContratacion(true);
			this.agencia.gatillarRonda();
			Assert.assertNotEquals("No se crearon las contrataciones",contrataciones, this.agencia.getContrataciones());
		}
		catch (Exception e) {
			fail("No deberia fallar la creacion de empleador");
		}
	}
	
	@Test
	public void testGatillarRondaEstadoVerdaderoPenalizacion() {
		try {
			Empleador empleador2 = (Empleador)this.agencia.registroEmpleador("Guillesky", "Chad", "Guillermo", "223840122", util.Constantes.FISICA,
					util.Constantes.COMERCIO_INTERNACIONAL);
			this.agencia.crearTicketEmpleador(util.Constantes.PRESENCIAL,100000,util.Constantes.JORNADA_EXTENDIDA,util.Constantes.JUNIOR,
					util.Constantes.EXP_NADA,util.Constantes.SECUNDARIOS, empleador2);
			int puntajeEmpleador2 = empleador2.getPuntaje();
			
			this.empleado.setCandidato(this.empleador);
			this.empleador.setCandidato(this.empleado);			
			this.agencia.setEstadoContratacion(true);
			this.agencia.gatillarRonda();
			
			Assert.assertEquals("No se penalizo al empleador que no contrato",puntajeEmpleador2-20,
					this.agencia.getEmpleadores().get("Guillesky").getPuntaje());

		}
		catch (Exception e) {
			fail("No deberia haber fallado la creacion de empleador");
		}
	}
	
	@Test
	public void testGatillarRondaEstadoVErdaderoListaPostulantes() {
		try {
			Empleador empleador2 = (Empleador)this.agencia.registroEmpleador("Guillesky", "Chad", "Guillermo", "223840122", util.Constantes.FISICA,
					util.Constantes.COMERCIO_INTERNACIONAL);
			this.agencia.crearTicketEmpleador(util.Constantes.PRESENCIAL,100000,util.Constantes.JORNADA_EXTENDIDA,util.Constantes.JUNIOR,
					util.Constantes.EXP_NADA,util.Constantes.SECUNDARIOS, empleador2);
			
			this.empleado.setCandidato(this.empleador);
			this.empleador.setCandidato(this.empleado);			
			this.agencia.setEstadoContratacion(true);
			this.agencia.gatillarRonda();
			
			Assert.assertNull("El metodo no creo las listas de postulantes",this.empleado.getListaDePostulantes());
			Assert.assertNull("El metodo no creo las listas de postulantes",this.empleador.getListaDePostulantes());
			Assert.assertNull("El metodo no creo las listas de postulantes",empleador2.getListaDePostulantes());
		}
		catch (Exception e) {
			fail("No deberia haber fallado la creacion de empleador");
		}
	}
	
	@Test
	public void testGatillarRondaEstadoFalsoEmpleado() {
		this.agencia.setEstadoContratacion(false);
		this.agencia.gatillarRonda();
		Assert.assertNotNull("El metodo no creo las listas de postulantes",this.agencia.getEmpleados().get("Juan123").getListaDePostulantes());
	}
	
	@Test
	public void testGatillarRondaEstadoFalsoEmpleador() {
		this.agencia.setEstadoContratacion(false);
		this.agencia.gatillarRonda();
		Assert.assertNotNull("El metodo no creo las listas de postulantes",this.agencia.getEmpleadores().get("Marcos123").getListaDePostulantes());
	}

	@Test
	public void testCalculaPremiosCastigosAsignacionesEmpleados() {
		ArrayList<ClientePuntaje> listaPostulantes= new ArrayList<ClientePuntaje>();
		EmpleadoPretenso empleadoTest1 = this.agencia.getEmpleados().get("Juan123");
		Empleador empleadorTest =  this.agencia.getEmpleadores().get("Marcos123"); 
		

		ArrayList<ClientePuntaje> listEmpleadores = new ArrayList<ClientePuntaje>();
		listEmpleadores.add(new ClientePuntaje(10,empleadorTest));
		
		empleadoTest1.setPuntaje(30);
		int puntajeEmpleadoTest1 = empleadoTest1.getPuntaje(); 
		try {
			EmpleadoPretenso empleadoTest2 = (EmpleadoPretenso) this.agencia.registroEmpleado("Pepe123", "Pepe123", "Pedro", "", "22356987", 45);
			empleadoTest2.setPuntaje(15);
			int puntajeEmpleadoTest2 = empleadoTest2.getPuntaje();
	
			EmpleadoPretenso empleadoTest3 = (EmpleadoPretenso) this.agencia.registroEmpleado("Lucas123", "Lucas123", "Lucas", "Gonzalez", "22386285", 17);
			empleadoTest3.setPuntaje(0);
			int puntajeEmpleadoTest3 = empleadoTest3.getPuntaje();
			
			this.agencia.crearTicketEmpleador(util.Constantes.PRESENCIAL,15000000,util.Constantes.JORNADA_EXTENDIDA,util.Constantes.JUNIOR,
					util.Constantes.EXP_NADA,util.Constantes.SECUNDARIOS, empleadoTest2);		
			this.agencia.crearTicketEmpleador(util.Constantes.PRESENCIAL,100000000,util.Constantes.JORNADA_EXTENDIDA,util.Constantes.JUNIOR,
					util.Constantes.EXP_NADA,util.Constantes.SECUNDARIOS, empleadoTest3);		
			
		
			
			listaPostulantes.add(new ClientePuntaje(30,empleadoTest1));
			listaPostulantes.add(new ClientePuntaje(15,empleadoTest2)); 
			listaPostulantes.add(new ClientePuntaje(0,empleadoTest3));
			
			empleadoTest1.setListaDePostulantes(listEmpleadores);
			empleadoTest2.setListaDePostulantes(listEmpleadores);
			empleadoTest3.setListaDePostulantes(listEmpleadores);
			
			empleadorTest.setListaDePostulantes(listaPostulantes);
			System.out.println(empleadorTest.getListaDePostulantes());
			this.agencia.calculaPremiosCastigosAsignaciones();
			System.out.println(empleadorTest.getListaDePostulantes());
			
			Assert.assertEquals("La premiacion por salir primero no funciona", puntajeEmpleadoTest1 + 5, empleadoTest1.getPuntaje());
			Assert.assertEquals("No deberia variar por estar en el medio", puntajeEmpleadoTest2, empleadoTest2.getPuntaje());
			Assert.assertEquals("El castigo por salir ultimo no funciona", puntajeEmpleadoTest3 - 5, empleadoTest3.getPuntaje());
			
			
			empleadorTest.setCandidato(empleadoTest1);
			empleadoTest1.setCandidato(empleadorTest);
			this.agencia.setEstadoContratacion(true);
			this.agencia.gatillarRonda();
			
			Assert.assertEquals("La premiacion por contratacion no funciona", puntajeEmpleadoTest1 + 15, empleadoTest1.getPuntaje());
			
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void testCalculaPremiosCastigosAsignacionesEmpleadores() {
		ArrayList<ClientePuntaje> listaPostulantes= new ArrayList<ClientePuntaje>();
		ArrayList<ClientePuntaje> listaEmpleado= new ArrayList<ClientePuntaje>();
		EmpleadoPretenso empleadoTest = this.agencia.getEmpleados().get("Juan123");
		
		listaEmpleado.add(new ClientePuntaje(30,empleadoTest));
		
		
		Empleador empleadorTest1 = this.agencia.getEmpleadores().get("Marcos123");
		empleadorTest1.setPuntaje(40);
		int puntajeEmpleadorTest1 = empleadorTest1.getPuntaje();
		try {
			Empleador empleadorTest2 = (Empleador)this.agencia.registroEmpleador("Pepe123", "pepe23", "Pedro","Vasquez" , util.Constantes.FISICA, util.Constantes.SALUD);
			empleadorTest2.setPuntaje(15);
			int puntajeEmpleadorTest2 = empleadorTest2.getPuntaje();
			Empleador empleadorTest3 = (Empleador)this.agencia.registroEmpleador("Guillesky", "Chad", "Guillermo", "223840122", util.Constantes.FISICA, util.Constantes.COMERCIO_INTERNACIONAL);
			empleadorTest3.setPuntaje(0);
			int puntajeEmpleadorTest3 = empleadorTest3.getPuntaje();
			
			listaPostulantes.add(new ClientePuntaje(40,empleadorTest1));
			listaPostulantes.add(new ClientePuntaje(15,empleadorTest2)); 
			listaPostulantes.add(new ClientePuntaje(0,empleadorTest3));
			
			empleadoTest.setListaDePostulantes(listaPostulantes);
			System.out.println(empleadoTest.getListaDePostulantes());
			this.agencia.calculaPremiosCastigosAsignaciones();
			System.out.println(empleadoTest.getListaDePostulantes());
			
			Assert.assertEquals("El empleador primero no fue premiado", puntajeEmpleadorTest1 + 10, empleadorTest1.getPuntaje());
			Assert.assertEquals("No deberia variar por estar en el medio", puntajeEmpleadorTest2, empleadorTest2.getPuntaje());
			Assert.assertEquals("No deberia variar por estar ultimo", puntajeEmpleadorTest3, empleadorTest3.getPuntaje());
			
			empleadorTest1.setCandidato(empleadoTest);
			empleadoTest.setCandidato(empleadorTest1);
			this.agencia.gatillarRonda();
			
			Assert.assertEquals("El empleador primero no fue premiado", puntajeEmpleadorTest1 + 50, empleadorTest1.getPuntaje()); //este varia de mas y los otros no hacen nada
			Assert.assertEquals("No deberia variar por estar en el medio", puntajeEmpleadorTest2 -20, empleadorTest2.getPuntaje());
			Assert.assertEquals("No deberia variar por estar ultimo", puntajeEmpleadorTest3 -20, empleadorTest3.getPuntaje());
			
			
		} catch (NewRegisterException | ImposibleCrearEmpleadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	@Test
	public void testMatch() {
		EmpleadoPretenso empleadoTest =  this.agencia.getEmpleados().get("Juan123");
		Empleador empleadorTest = this.agencia.getEmpleadores().get("Marcos123");
		int puntajeNuevoEmpleado = empleadoTest.getPuntaje() + 10;
		int puntajeNuevoEmpleador = empleadorTest.getPuntaje() + 50; 		
		this.agencia.match(empleadorTest,empleadoTest);
		
		Assert.assertEquals("Falla en el puntaje de empleado", puntajeNuevoEmpleado, empleadoTest.getPuntaje());
		Assert.assertEquals("Falla en el puntaje de empleador", puntajeNuevoEmpleador, empleadorTest.getPuntaje());
		Assert.assertNull("Ticket no eliminado en empleado",empleadoTest.getTicket());
		Assert.assertNull("Ticket no eliminado en empleador",empleadorTest.getTicket());
		Assert.assertNotNull(this.agencia.getComisionUsuario(empleadoTest));
		Assert.assertNotNull(this.agencia.getComisionUsuario(empleadorTest));
	}	
	
	@Test
	public void testMatchPtjeEmpleador() {
		
	}
	
	@Test
	public void testGeneraPostulantes() {
		try {
			this.agencia.login("admin", "admin");
			this.agencia.generaPostulantes();
			//System.out.println(this.agencia.getEmpleadores().get("Marcos123").getRealName() + this.agencia.getEmpleadores().get("Marcos123").getListaDePostulantes());
			//System.out.println(this.agencia.getEmpleados().get("Juan123").getRealName() + this.agencia.getEmpleados().get("Juan123").getListaDePostulantes());
			Assert.assertNotNull(this.agencia.getEmpleadores().get("Marcos123").getListaDePostulantes());
			Assert.assertNotNull(this.agencia.getEmpleados().get("Juan123").getListaDePostulantes());
			
			
		} catch (ContraException | NombreUsuarioException e) {
			fail("Fallo en login");
		}
	}

	@Test
	public void testRegistroEmpleador() {
		try {
			Empleador empleador = (Empleador)this.agencia.registroEmpleador("Pedro123", "Pedro123", "Pedro"
					,"2235698547", util.Constantes.FISICA, util.Constantes.SALUD);
			Assert.assertNotNull("El empleador no se registro correctamente", empleador);
			
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testRegistroEmpleadorRepetidoExcepcion() {
		try {
			Empleador empleadorTest = (Empleador) this.agencia.registroEmpleador(this.empleador.getUsserName(), 
					this.empleador.getPassword(),this.empleador.getRealName(),this.empleador.getTelefono(),
					this.empleador.getRubro(),	this.empleador.getTipoPersona());
			fail("Deberia haber lanzado una excepcion");
		}
		catch (NewRegisterException e) {
			
		}
		catch(Exception e) {
			fail(e.getMessage());		
		}
	}
	
	@Test
	public void testRegistroEmpleado() {
		EmpleadoPretenso empleado;
		
		try {
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Pepe123", "Pepe123"
					, "Pepe", "Juarez","2235678563" , 18);
			Assert.assertNotNull("El empleado no se registro correctamente", empleado);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}

	@Test
	public void testRegistroEmpleadoFalloRepetido() {
		try {
			EmpleadoPretenso empleado = (EmpleadoPretenso)this.agencia.registroEmpleado(this.empleado.getUsserName(),
					this.empleado.getPassword(),this.empleado.getRealName(),this.empleado.getApellido(),
					this.empleado.getTelefono() , this.empleado.getEdad());
			fail("Deberia haber lanzado excepcion");
		}
		catch (NewRegisterException e) {
			
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testLoginEmpleado() {
		try {
			agencia.login("Juan123", "Juan123");
			Assert.assertTrue("El tipo de usuario no es el correcto", this.agencia.getTipoUsuario()==0);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test 
	public void testLoginExcepcionUsser() {
		try {
			agencia.login("Juan123", "qwerty123");
			fail("Deberia haber lanzado una excepcion");
		}
		catch (ContraException e) {
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test 
	public void testLoginExcepcionPass() {
		try {
			agencia.login("Pedro569", "Juan123");
			fail("Deberia haber lanzado una excepcion");
		}
		catch (NombreUsuarioException e) {
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	//El resto de las excepciones en empleadores y admin lo "corto", no tiene sentido, ya funciona
	
	@Test
	public void testLoginEmpleador() {
		try {
			agencia.login("Marcos123", "Marcos123");
			Assert.assertTrue("El tipo de usuario no es el correcto", this.agencia.getTipoUsuario()==1);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testLoginAdmin() {
		try {
			agencia.login("admin", "admin");
			Assert.assertTrue("El tipo de usuario no es el correcto", this.agencia.getTipoUsuario()==2);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	
	@Test
	public void testGetContratacionEmpleador() {
		Contratacion nueva;
		EmpleadoPretenso empleado;
		
		nueva = new Contratacion(this.empleador,this.empleado);
		this.agencia.getContrataciones().add(nueva);
		empleado = (EmpleadoPretenso)this.agencia.getContratacionEmpleador(this.empleador);
		Assert.assertNotNull("Devolvio null", empleador);
		Assert.assertEquals("No devolvio el mismo empleado", this.empleador, empleador);
	}

	
	@Test
	public void testEliminarTicket() {
		try {
			EmpleadoPretenso usuarioTest = (EmpleadoPretenso) this.agencia.login("Juan123", "Juan123");
			try {
				this.agencia.eliminarTicket();
				Assert.assertNull("El ticket fue eliminado", usuarioTest.getTicket());
			} catch (ImposibleModificarTicketsException e) {
				fail("Estado de contratacion no valido");
			} 
		} catch (ContraException | NombreUsuarioException e) {
			fail("no deberia fallar aca");
		} 
		
	}
	
	@Test
	public void testEliminarTicketException() {
		try {
			this.agencia.setEstadoContratacion(true);
			EmpleadoPretenso usuarioTest = (EmpleadoPretenso) this.agencia.login("Juan123", "Juan123");
			try {
				this.agencia.eliminarTicket();
				fail("Deberia haber lanzado excepcion");
			} catch (ImposibleModificarTicketsException e) {
				
			} 
		} catch (ContraException | NombreUsuarioException e) {
			fail("Se lanzo la excepcion equivocada");
		} 
		
	}
	
	@Test
	public void testCerrarSesion() {
		try {
			this.agencia.login(this.empleado.getUsserName(), this.empleado.getPassword());
			this.agencia.cerrarSesion();
			Assert.assertTrue("No se cerro sesion correctamente",this.agencia.getTipoUsuario()==-1);
		} catch (ContraException | NombreUsuarioException e) {
			fail("No deberia haber lanzado excepcion");
		}
	}
}

