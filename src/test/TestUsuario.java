package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modeloDatos.Usuario;

class TestUsuario {

	Usuario user;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		this.user = new Usuario();
		//recordar de usar siempre las mismas clases, usemos siempre la que NO tiene bin
		this.user.getPassword();
	}

}
