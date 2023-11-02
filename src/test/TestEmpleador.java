package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.Empleador;

public class TestEmpleador {

	@Test
	public void testEmpleadorStringStringStringStringStringString() {
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "salud", "fisica");
		Assert.assertNotNull(null, empleadorTest);
	}

	@Test
	public void testCalculaComision() {
		fail("Not yet implemented");
	}

}
