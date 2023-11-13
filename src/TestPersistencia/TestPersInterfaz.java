package TestPersistencia;

import static org.junit.Assert.fail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import modeloDatos.Cliente;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import persistencia.AgenciaDTO;
import persistencia.PersistenciaXML;

public class TestPersInterfaz {
	
	PersistenciaXML persistencia;
	@Before
	public void setUp() {
		persistencia = new PersistenciaXML();

	}

	@After
	public void tearDown() {

	}

	
	@Test
    public void testAbrirInput() throws IOException  {
		try {
			persistencia.abrirInput("Agencia.xml");
		}
		catch (Exception e1){
			fail("1 escenario: no deberia lanzar una excepcion");
		}
		try {
			persistencia.abrirInput(null);
			fail("2 escenario: deberia lanzar una null pointer excepction");
		}
		catch (Exception e1){
		}
    }
	
	@Test
    public void testAbrirOutput() {
		try {
			persistencia.abrirOutput("Agencia.xml");
		} catch (IOException e1) {
			fail("no deberia lanzar una excepcion escenario 1");
		}
		try {
			persistencia.abrirOutput(null);
			fail("deberia lanzar la excepcion nullpointer escenario2");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void TestCerrarInput() {
		try {
			persistencia.abrirInput("Agencia.xml");			
			persistencia.cerrarInput();
		} catch (IOException e) {
			fail("no deber�a lanzar una excepcion");	
		}
	}
	
	@Test
	public void TestCerrarOutput() {
		try {
			persistencia.abrirOutput("Agencia.xml");			
			persistencia.cerrarOutput();
		} catch (IOException e) {
			fail("no deberia lanzar una excepcion al primer intento de cerrar");
		}
	}
	
	@Test
	public void testLeer() throws ClassNotFoundException {
		try {
			AgenciaDTO ag;
			ag = (AgenciaDTO) persistencia.leer();
		} catch (IOException e) {
			fail("no deberia lanzar una excepcion");
		}
	}
	
	@Test
	public void testEscribir1 (){
		AgenciaDTO ag =  new AgenciaDTO();
		try {
			persistencia.abrirOutput("archivoVacio.xml");
			persistencia.escribir(ag);
		} catch (IOException e) {
			fail("no deberia lanzar una excepcion");
		}
	}
	
	@Test
	public void testEscribir2 (){
		AgenciaDTO agencia =  new AgenciaDTO();
		EmpleadoPretenso testPretenso = new EmpleadoPretenso ("Maite","que123","Maiten","3576223345665","Pratt",25);
		HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
		testComisiones.put(testPretenso, 0.9);
		HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
		HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
		ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
		agencia.setComisionesUsuarios(testComisiones);
		agencia.setContrataciones(testContrataciones);
		agencia.setEmpleadores(testEmpleadores);
		agencia.setEmpleados(testEmpleadosPretensos);
		agencia.setEstadoContratacion(false);
		agencia.setLimiteInferior(1000);
		agencia.setLimiteSuperior(2000);
		try {
			persistencia.abrirOutput("AgenciaConDatos.xml");
			persistencia.escribir(agencia);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			fail("no deberia lanzar una excepcion");
		}
	}
}
