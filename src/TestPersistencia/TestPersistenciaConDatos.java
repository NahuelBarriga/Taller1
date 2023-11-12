package TestPersistencia;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ImposibleCrearEmpleadoException;
import excepciones.NewRegisterException;
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;

public class TestPersistenciaConDatos {

	@Before
	public void setUp() throws Exception {
		Agencia agencia = Agencia.getInstance();
		Cliente empleado = agencia.registroEmpleado("PedroGomez123","19782022","Pedro","Gomez","2235464998",27);
		agencia.crearTicketEmpleado("Presencial", 20000, "Carga Media", "Junior", "Nada", "Terciarios",empleado);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEscrituraConDatos() throws NewRegisterException, ImposibleCrearEmpleadoException, ClassNotFoundException, IOException{
		
			EmpleadoPretenso ep = new EmpleadoPretenso("JuanCABJ","1234567","Juan","Solari","223453225",31);
			Agencia.getInstance().registroEmpleado("JuanCABJ","1234567","Juan","Solari","223453225",31);
			Agencia agencia = Agencia.getInstance();
			agencia.cargarAgencia("Agencia.txt"); //que vaaa?
			Assert.assertNotNull("No deberia ser null", Agencia.getInstance().getEmpleados()); // verifico si algo se guardó
			Assert.assertNotEquals("Deberian ser diferentes",ep , Agencia.getInstance().getEmpleados());
		
		
		
	}

}
