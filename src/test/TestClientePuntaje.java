package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;

public class TestClientePuntaje {

	@Test
	public void testClientePuntajeDoubleCliente() {
		double puntaje = 4.5;
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		ClientePuntaje clientePuntajeTest = new ClientePuntaje(puntaje, empleadoTest);
		
		Assert.assertNotNull("Falla en el constructor, constructor nulo", clientePuntajeTest);
		Assert.assertEquals("Falla en el constructor, puntaje incorrecto", puntaje, clientePuntajeTest.getPuntaje(), 0);
		Assert.assertEquals("Falla en el constructor, cliente incorrecto", empleadoTest, clientePuntajeTest.getCliente());
	}

	@Test
	public void testSetCliente() {
		double puntaje = 4.5;
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		EmpleadoPretenso empleadoTest2 = new EmpleadoPretenso("Marcos123", "Marcos123", "Marcos", "2235698456", "Guevara", 47);
		ClientePuntaje clientePuntajeTest = new ClientePuntaje(puntaje, empleadoTest);
		clientePuntajeTest.setCliente(empleadoTest2); 
		Assert.assertEquals("Falla SetCliente, cliente incorrecto", empleadoTest2, clientePuntajeTest.getCliente());
	}

}
