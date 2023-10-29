package test;

import org.junit.Test;

import modeloDatos.Usuario;

public class TestUsuario {

	@Test
	public void testCreaUsuario() {
		Usuario usuario = new Usuario("Alex", "qwerty123", "Alejandro", "223917552");
		String nombreTest = usuario.getUsserName();
		String passwordTest = usuario.getPassword();
		String realNameTest = usuario.getRealName();
		String telefonoTest = usuario.getTelefono();
		
	}

	@Test
	public void testUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTelefono() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTelefono() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRealName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRealName() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
