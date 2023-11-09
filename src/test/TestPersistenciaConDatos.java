package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import modeloNegocio.Agencia;
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;

import excepciones.ImposibleCrearEmpleadoException;
import excepciones.NewRegisterException;

public class TestPersistenciaConDatos {

	@Before
	public void setUp() throws Exception {
		Agencia agencia = Agencia.getInstance();
		agencia.registroEmpleado("PedroGomez123","19782022","Pedro","Gomez","2235464998",27);
		agencia.);	//que vaaa?
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEscrituraConDatos() {
		try {
			EmpleadoPretenso ep = new EmpleadoPretenso("JuanCABJ","1234567","Juan","Solari","223453225",31);
			Agencia.getInstance().registroEmpleado("JuanCABJ","1234567","Juan","Solari","223453225",31);
			Agencia.setPersistencia(Agencia); //que vaaa?
			Assert.assertNotNull("No deberia ser null", Agencia.getInstance().getEmpleados()); // verifico si algo se guardó
			Assert.assertNotEquals("Deberian ser diferentes",ep , Agencia.getInstance().getEmpleados());
		} catch (NewRegisterException e) {
			
		} catch (ImposibleCrearEmpleadoException e) {
		}
		
		
	}

}
