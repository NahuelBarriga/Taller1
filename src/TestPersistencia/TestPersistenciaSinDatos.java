package TestPersistencia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import persistencia.IPersistencia;

public class TestPersistenciaSinDatos {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File arch = new File("Agencia.txt"); // testeo si el archivo existe para borrarlo y arrancar con el metodo de creacion exitosa
		if (arch.exists()) {
			arch.delete();
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreaArchivoVacioExitoso() throws IOException {
		Agencia agencia = Agencia.getInstance();
		agencia.guardarAgencia("Agencia.txt");
		File arch = new File("Agencia.txt");	
		Assert.assertTrue("Deberia existir", arch.exists());
	}
	
	
	@Test
	public void testLecturaArchivoVacio() throws ClassNotFoundException,IOException{
		 ArrayList<Agencia> listaClientes = new ArrayList<Agencia>();
		 ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		 Agencia agencia = Agencia.getInstance();
		 agencia.cargarAgencia("Agencia.txt");
		 Assert.assertEquals("Los sistemas deberian estar vacios",listaClientes,Agencia.getInstance().getIterartorEmpleadores());
		 Assert.assertEquals("Los sistemas deberian estar vacios",listaClientes,Agencia.getInstance().getIteratorEmpleadosPretensos());
	}

	
	

}
