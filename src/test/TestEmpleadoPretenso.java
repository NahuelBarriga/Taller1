package test;


import org.junit.Assert;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;

public class TestEmpleadoPretenso {

	@Test
	public void testEmpleadoPretenso() {
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25); 
		
		Assert.assertNotNull("TaBien", empleadoTest);
	}

	@Test
	public void testSetEdad() {
		
	}

}
