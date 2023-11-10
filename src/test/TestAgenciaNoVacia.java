package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;

public class TestAgenciaNoVacia {

Agencia agencia;
	
	@Before
	public void setUp() throws Exception {
			this.agencia = Agencia.getInstance();
			Ticket ticketTestEmpleado = new Ticket(util.Constantes.HOME_OFFICE,250000,util.Constantes.JORNADA_COMPLETA,util.Constantes.ADMINISTRADOR,util.Constantes.EXP_MUCHA,util.Constantes.TERCIARIOS);
			Ticket ticketTestEmpleador = new Ticket(util.Constantes.INDISTINTO,300000,util.Constantes.JORNADA_COMPLETA, util.Constantes.ADMINISTRADOR, util.Constantes.EXP_MEDIA,util.Constantes.TERCIARIOS);
			//deberian hacer match
			EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
			empleadoTest.setPuntaje(4);
			empleadoTest.setTicket(ticketTestEmpleado);
			
			Empleador empleadorTest = new Empleador("Marcos123", "Marcos123", "Marcos", "223566985", util.Constantes.SALUD, util.Constantes.FISICA);
			empleadorTest.setPuntaje(5);
			empleadorTest.setTicket(ticketTestEmpleador);
			
			HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
			empleados.put("Juan123", empleadoTest);
			HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
			empleadores.put("Marcos123", empleadorTest);
			
			//settear los limites para que se contrate
			agencia.setEmpleados(empleados);
			agencia.setEmpleadores(empleadores);
			agencia.setLimitesRemuneracion(200000, 350000);
			
			
			
	}

	@After
	public void tearDown() { //No se si es necesario, pero lo voy a dejar de momento
		this.agencia.getCoincidencias().clear();
		this.agencia.getComisionesUsuarios().clear();
		this.agencia.getContrataciones().clear();
		this.agencia.getEmpleadores().clear();
		this.agencia.getEmpleados().clear();
	}
	
	
	
	@Test
	public void testSetLimitesRemuneracion() {
		try {
			Assert.assertEquals("El limite inferior no fue seteado correctamente", 200000, this.agencia.getLimiteInferior());
			Assert.assertEquals("El limite superior no fue seteado correctamnte",350000,this.agencia.getLimiteSuperior());
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	

	@Test
	public void testGatillarRonda() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculaPremiosCastigosAsignaciones() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testGeneraPostulantes() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrearTicketEmpleado() {
		EmpleadoPretenso empleadoTest = this.agencia.getEmpleados().get("Juan123");
		Ticket ticketTest = empleadoTest.getTicket();
		try {
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 250000, util.Constantes.JORNADA_EXTENDIDA, util.Constantes.MANAGMENT, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS, empleadoTest);
			Assert.assertNotNull(empleadoTest.getTicket());
			Assert.assertNotEquals("El ticket creado es diferente", ticketTest, empleadoTest.getTicket());
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadoExcepcion() {
		this.agencia.setEstadoContratacion(true);
		EmpleadoPretenso empleadoTest = this.agencia.getEmpleados().get("Juan123");
		Ticket ticketTest = empleadoTest.getTicket();
		try {
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 250000, util.Constantes.JORNADA_EXTENDIDA, util.Constantes.MANAGMENT, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS, empleadoTest);
			fail("Deberia tirar excepcion");
		} catch (ImposibleModificarTicketsException e) {
			Assert.assertEquals("Ticket no se modifico", ticketTest, empleadoTest.getTicket());
		}
	}

	@Test
	public void testCrearTicketEmpleador() {
		Empleador empleadorTest = this.agencia.getEmpleadores().get("Marcos123");
		Ticket ticketTest = empleadorTest.getTicket();
		try {
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 12000, util.Constantes.JORNADA_COMPLETA,
					util.Constantes.JUNIOR, util.Constantes.EXP_NADA,util.Constantes.PRIMARIOS , empleadorTest);
			Assert.assertNotNull(empleadorTest.getTicket());
			Assert.assertNotEquals("El ticket creado es diferente", ticketTest, empleadorTest.getTicket());
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadorExcepcion() {
		this.agencia.setEstadoContratacion(true);
		Empleador empleadorTest = this.agencia.getEmpleadores().get("Marcos123");
		Ticket ticketTest = empleadorTest.getTicket();
		try {
			this.agencia.crearTicketEmpleador(util.Constantes.HOME_OFFICE, 250000, util.Constantes.JORNADA_EXTENDIDA, util.Constantes.MANAGMENT, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS, empleadorTest);
			fail("Deberia tirar excepcion");
		} catch (ImposibleModificarTicketsException e) {
			Assert.assertEquals("Ticket no se modifico", ticketTest, empleadorTest.getTicket());
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
	public void testRegistroEmpleadorExcepcion() {
		try {
			Empleador empleador = (Empleador)this.agencia.registroEmpleador("Marcos123", "Marcos123", "Marcos", "223566985", util.Constantes.SALUD, util.Constantes.FISICA);
			fail("deberia haber lanzado una excepcion");
		}
		catch (NewRegisterException e) {
			
		}
		catch(Exception e) {
			//System.out.println(agencia.getEmpleadores());
			//fail("No se lanzo la excepcion correcta");
			fail(e.getMessage());
			
		}
	}
	/*
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
		*/
	@Test
	public void testRegistroEmpleadoFalloRepetido() {
		try {
			EmpleadoPretenso empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
					, "Juan", "Rodriguez","2235698547" , 25);
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
			Assert.assertTrue("El tipo de usuario no es el correcto", this.agencia.getTipoUsuario()==0);
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
			Assert.assertTrue("El tipo de usuario no es el correcto", this.agencia.getTipoUsuario()==0);
			fail("Deberia haber lanzado una excepcion");
		}
		catch (NombreUsuarioException e) {
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	//el resto de las excepciones en empleadores y admin lo "corto", no tiene sentido, ya funciona
	
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetContratacionEmpleadoPretenso() {
		fail("Not yet implemented");
	}

	@Test
	public void testAplicaPromo() {
		fail("Not yet implemented");
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


}

