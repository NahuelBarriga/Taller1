package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
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
			empleado = (EmpleadoPretenso)this.agencia.registroEmpleado("Juan123", "Juan123", "Juan", "Rodriguez","2235698547" , 25);
			Assert.assertNotNull("El empleado no se registro correctamente", empleado);
		}
		catch (Exception e) {
			fail("No deberia haber lanzado una excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadoFallo() {
		
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
	
	//Faltaria agregar otro test para verificar que se lance la excepcion de nombre de usuario repetido
	//pero al ser otro escenario con listas cargadas, tengo que crear otra clase? (la misma duda de antes)
	
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
	
	@Test //deberia probarlo aca? Porque no inicie sesion en el setUp, pero si lo hago me faltaria tambien probar el login
	public void testCerrarSesion() {
		this.agencia.cerrarSesion();
		Assert.assertTrue("Deberia haber cerrado sesion",this.agencia.getTipoUsuario() == -1);
	}
}
