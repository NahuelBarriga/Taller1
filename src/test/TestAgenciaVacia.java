package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import excepciones.NewRegisterException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;

//Escenario de Agencia vacia
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
	public void testGeneraPostulantes() {
		try {
			this.agencia.registroEmpleado("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.agencia.registroEmpleador("Marcos123", "Marcos123", "Marcos", "223566985", util.Constantes.FISICA,util.Constantes.SALUD);
		} catch (NewRegisterException | ImposibleCrearEmpleadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.agencia.generaPostulantes(); 
		
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
	public void testSetLimitesRemuneracion() {
		try {
			agencia.setLimitesRemuneracion(200000, 350000);
			Assert.assertEquals("El limite inferior no fue seteado correctamente", 200000, this.agencia.getLimiteInferior());
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

	

	
}
