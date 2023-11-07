package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;

public class TestAgenciaVacia {

	Agencia agencia;
	
	@Before
	public void setUp() throws Exception {
			this.agencia = Agencia.getInstance();
			
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
	public void testRegistroEmpleadoExitoso() {
		EmpleadoPretenso empleado;
		
		try {
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
					, "Juan", "Rodriguez","2235698547" , 25);
			Assert.assertNotNull("El empleado no se registro correctamente", empleado);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadoFalloNull() {
		
		try {
			EmpleadoPretenso empleado;
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado(null, null, null, null, null, -24);
			fail("Deberia haber lanzado una excepcion");
		}
		catch(ImposibleCrearEmpleadoException e) {
			
		}
		catch(Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testRegistroEmpleadoFalloRepetido() {
		try {
			EmpleadoPretenso empleado;
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
					, "Juan", "Rodriguez","2235698547" , 25);
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
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
	public void testRegistraEmpleadorExitoso() {
		Empleador empleador;
		
		try {
			empleador = (Empleador)this.agencia.registroEmpleador("Juan123", "Juan123", "Juan"
					,"2235698547", util.Constantes.FISICA, util.Constantes.SALUD);
			Assert.assertNotNull("El empleador no se registro correctamente", empleador);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testRegistraEmpleadoFallo() {
		try {
			Empleador empleador;
			empleador = (Empleador)this.agencia.registroEmpleador(null,null,null,null,null,"POLIRUBRO");
			fail("Deberia haber lanzado una excepcion");
		}
		catch (ImposibleCrearEmpleadorException e) {
			
		}
		catch(Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testCerrarSesion() {
		
		try {
			EmpleadoPretenso empleado;
		
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123",
					"Juan123","Juan","Rodrigez","2235698547",25);
		
			this.agencia.cerrarSesion();
			Assert.assertTrue("Deberia haber cerrado sesion",this.agencia.getTipoUsuario() == -1);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado excepcion");
		}
	}
	
	@Test
	public void testLoginEmpleadoExito() {
		try {
			EmpleadoPretenso empleado, usuario;
			
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
					, "Juan", "Rodriguez","2235698547" , 25);
			usuario = (EmpleadoPretenso)this.agencia.login("Juan123", "Juan123");
			Assert.assertEquals("El usuario devuelto no es el mismo", empleado, usuario);
			Assert.assertTrue("El tipo de usuario no es el correcto", this.agencia.getTipoUsuario()==0);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testLoginEmpleadoFallaContra() {
		try {
			EmpleadoPretenso empleado, usuario;
			
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
					, "Juan", "Rodriguez","2235698547" , 25);
			usuario = (EmpleadoPretenso)this.agencia.login("Juan123", "qwerty123");
			fail("Deberia haber lanzado una excepcion");
		}
		catch (ContraException e) {
			
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testLoginEmpleadoFallaUser() {
		try {
			EmpleadoPretenso empleado, usuario;
			
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123"
					, "Juan", "Rodriguez","2235698547" , 25);
			usuario = (EmpleadoPretenso)this.agencia.login("Alejandro", "Juan123");
			fail("Deberia haber lanzado una excepcion");
		}
		catch (NombreUsuarioException e) {
			
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testLoginEmpleadorExitoso() {
		try {
			Empleador empleador, usuario;
			
			empleador = (Empleador)this.agencia.registroEmpleador("Juan123", "Juan123", "Juan"
					,"2235698547", util.Constantes.FISICA, util.Constantes.SALUD);
			usuario = (Empleador)this.agencia.login("Juan123", "Juan123");
			Assert.assertEquals("El usuario devuelto no es el mismo", empleador, usuario);
			Assert.assertTrue("El tipo de usuario no es el mismo", this.agencia.getTipoUsuario()==1);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testSetLimitesRemuneracion() {
		try {
			this.agencia.setLimitesRemuneracion(150, 180);
			Assert.assertEquals("El limite inferior no fue seteado correctamente", 150, this.agencia.getLimiteInferior());
			Assert.assertEquals("El limite superior no fue seteado correctamnte",180,this.agencia.getLimiteSuperior());
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testSetLimitesRemuneracionFallaInferior() {
		try {
			this.agencia.setLimitesRemuneracion(-5, -2);
			fail("Deberia haber lanzado una excepcion");
		}
		catch (LimiteInferiorRemuneracionInvalidaException e) {
			
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testSetLimitesRemuneracionFallaSuperior() {
		try {
			this.agencia.setLimitesRemuneracion(20, 6);
			fail("Deberia haber lanzado una excepcion");
		}
		catch (LimiteSuperiorRemuneracionInvalidaException e) {
			
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadoExitoso() {
		try {
			EmpleadoPretenso empleado;
			Ticket ticket;
			
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123", "Juan",
					"Rodriguez","2235698547" , 25);
			this.agencia.setEstadoContratacion(false);
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 12000, util.Constantes.JORNADA_COMPLETA,
					util.Constantes.JUNIOR, util.Constantes.EXP_NADA,util.Constantes.PRIMARIOS , empleado);
			Assert.assertNotNull("El ticket no fue creado o asignado", this.agencia.getEmpleados().get(empleado.getUsserName()).getTicket());
			ticket = this.agencia.getEmpleados().get(empleado.getUsserName()).getTicket();
			Assert.assertEquals("El ticket no se cambio",util.Constantes.HOME_OFFICE , ticket.getLocacion());
			Assert.assertEquals("El ticket no se cambio", 12000, ticket.getRemuneracion());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.JORNADA_COMPLETA, ticket.getJornada());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.JUNIOR, ticket.getPuesto());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.EXP_NADA, ticket.getExperiencia());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.PRIMARIOS, ticket.getEstudios());
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion"+e);
		}
	}
	
	@Test
	public void testCrearTicketEmpleadoFallo() {
		try {
			EmpleadoPretenso empleado;
			
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123", "Juan",
					"Rodriguez","2235698547" , 25);
			this.agencia.setEstadoContratacion(true);
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 12000, util.Constantes.JORNADA_COMPLETA,
					util.Constantes.JUNIOR, util.Constantes.EXP_NADA,util.Constantes.PRIMARIOS , empleado);
			fail("Deberia haber lanzado una excepcion");
		}
		catch (ImposibleModificarTicketsException e) {
			
		}
		catch (Exception e) {
			fail("No se lanzo la excepcion correcta");
		}
	}
	
	@Test
	public void testCrearTicketEmpleador() {
		try {
			Empleador empleador;
			Ticket ticket;
			
			empleador = (Empleador)this.agencia.registroEmpleador("Juan123", "Juan123", "Juan", "2235698547",
					util.Constantes.FISICA, util.Constantes.SALUD);
			this.agencia.setEstadoContratacion(false);
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 12000, util.Constantes.JORNADA_COMPLETA,
					util.Constantes.JUNIOR, util.Constantes.EXP_NADA,util.Constantes.PRIMARIOS , empleador);
			ticket = this.agencia.getEmpleadores().get(empleador.getUsserName()).getTicket();
			Assert.assertNotNull("El ticket no fue creado o asignado", ticket);			
			Assert.assertEquals("El ticket no se cambio",util.Constantes.HOME_OFFICE , ticket.getLocacion());
			Assert.assertEquals("El ticket no se cambio", 12000, ticket.getRemuneracion());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.JORNADA_COMPLETA, ticket.getJornada());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.JUNIOR, ticket.getPuesto());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.EXP_NADA, ticket.getExperiencia());
			Assert.assertEquals("El ticket no se cambio", util.Constantes.PRIMARIOS, ticket.getEstudios());
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion"+e);
		}
	}
	
	@Test
	public void testGetContratacionEmpleador() {
		
	}
}
