package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Usuario;


public class TestUsuario {

	@Before
	public void setUp() throws Exception {		
	}

	@Test
	public void test() {
		Usuario user = new Usuario();
		Assert.assertNull(user);
	}

}
