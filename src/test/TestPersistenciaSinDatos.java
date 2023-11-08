package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modeloNegocio.Agencia;
import modeloDatos.Cliente;
import modeloDatos.Ticket;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.File;
import java.util.ArrayList;

public class TestPersistenciaSinDatos {

	IPersistencia agencia;
	
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
	public void testCreaArchivoVacioExitoso() {
		Agencia agencia2 = new Agencia();
		agencia2.setPersistencia(agencia); //cual seria el parametro??
		//estoy entre esto o Agencia.cerrarSesion()
		File arch = new File("Agencia.txt");
		Assert.assertTrue("Deberia existir", arch.exists());
	}
	
	
	@Test
	public void testLecturaArchivoVacio() {
		 ArrayList<Agencia> listaClientes = new ArrayList<Agencia>();
		 ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		 //todo muy raro, con que invoco la persistencia?
		 //estoy entre esto o Agencia.cargarAgencia();
		 Agencia agencia2 = new Agencia();
		 agencia2.getPersistencia();
		 Assert.assertEquals("Los sistemas deberian estar vacios",listaClientes,Agencia.getInstance().getIterartorEmpleadores());
		 Assert.assertEquals("Los sistemas deberian estar vacios",listaClientes,Agencia.getInstance().getIteratorEmpleadosPretensos());
		 Assert.assertEquals("Los sistemas deberian estar vacios",tickets,Cliente.getTicket());
	}

	
	

}
