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
import util.Mensajes;

//Escenario de Agencia vacia
public class TestAgenciaVacia {

	Agencia agencia;
	
	@Before
	public void setUp() throws Exception {
			this.agencia = Agencia.getInstance();
			
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
	public void testCrearTicketEmpleado() {
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		Ticket ticketTest = empleadoTest.getTicket();
		try {
			this.agencia.crearTicketEmpleado(util.Constantes.HOME_OFFICE, 250000, util.Constantes.JORNADA_EXTENDIDA,
					util.Constantes.MANAGMENT, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS, empleadoTest);
			Assert.assertNotEquals("El ticket creado es diferente", ticketTest, empleadoTest.getTicket());
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadoExcepcion() {
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		this.agencia.setEstadoContratacion(true);
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
		Empleador empleadorTest = new Empleador("Marcos123", "Marcos123", "Marcos", "223566985",util.Constantes.SALUD,util.Constantes.FISICA);
		Ticket ticketTest = empleadorTest.getTicket();
		try {
			this.agencia.crearTicketEmpleador(util.Constantes.HOME_OFFICE, 250000, util.Constantes.JORNADA_EXTENDIDA
					, util.Constantes.MANAGMENT, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS, empleadorTest);
			Assert.assertNotEquals("El ticket creado es diferente", ticketTest, empleadorTest.getTicket());
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadorExcepcion() {
		Empleador empleadorTest = new Empleador("Marcos123", "Marcos123", "Marcos", "223566985",util.Constantes.SALUD,util.Constantes.FISICA);
		this.agencia.setEstadoContratacion(true);
		Ticket ticketTest = empleadorTest.getTicket();
		try {
			this.agencia.crearTicketEmpleador(util.Constantes.HOME_OFFICE, 250000, util.Constantes.JORNADA_EXTENDIDA, util.Constantes.MANAGMENT, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS, empleadorTest);
			fail("Deberia tirar excepcion");
		} catch (ImposibleModificarTicketsException e) {
			Assert.assertEquals("Ticket no se modifico", ticketTest, empleadorTest.getTicket());
		}
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
	public void testSetLimitesRemuneracionInferior() {
		try {
			agencia.setLimitesRemuneracion(200000, 350000);
			Assert.assertEquals("El limite inferior no fue seteado correctamente", 200000, this.agencia.getLimiteInferior());
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
	}
	
	@Test
	public void testSetLimitesRemuneracionSuperior() {
		try {
			agencia.setLimitesRemuneracion(200000, 350000);			
			Assert.assertEquals("El limite superior no fue seteado correctamnte",350000,this.agencia.getLimiteSuperior());
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
	public void getEstadoContratando() {
		this.agencia.setEstadoContratacion(true);
		Assert.assertEquals("Fallo en getEstado", Mensajes.AGENCIA_EN_CONTRATACION.getValor(), this.agencia.getEstado());
	}
	
	
	@Test
	public void getEstadoBusqueda() {
		this.agencia.setEstadoContratacion(false);
		Assert.assertEquals("Fallo en getEstado", Mensajes.AGENCIA_EN_BUSQUEDA.getValor(), this.agencia.getEstado());
	}
	
}
