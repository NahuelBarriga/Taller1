package testGuiPanelLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;
import test.FalsoOptionPane;
import test.TestUtils;

public class TestGuiCambioPanelLogIn {
	Robot robot;
	Controlador controlador;
	FalsoOptionPane optionPane = new FalsoOptionPane();
	
	public TestGuiCambioPanelLogIn() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	@Before
	public void setUp() throws Exception{
		
		controlador = new Controlador();
		controlador.setMyOptionPane(optionPane);
		
		Agencia.getInstance().setEmpleados(new HashMap<String, EmpleadoPretenso>());
		Agencia.getInstance().setEmpleadores(new HashMap<String, Empleador>());
		//Registar 3 usuarios validos 
		this.registrarEmpleado("Meel", "LLdoe234","Melisa", "Lopez", "9984737372", 34);
		this.registrarEmpleado("Cari34", "LSk7F","Carola", "2737382992", "Diaz", 25);
		//this.registrarEmpleado("Czzzz", "sss","xxx", "333333", "Diaz", 21);
		this.registrarEmpleador("Lee123", "123456", "Lisandro", "112233234", Constantes.FISICA, Constantes.SALUD);
		
	}
	
	public void registrarEmpleador(String usuario, String pass, String nombre, String tel, String tipoPersona, String rubro) throws Exception {
		
		Agencia.getInstance().registroEmpleador(usuario, pass, nombre, tel, tipoPersona, rubro);
	}

	public void registrarEmpleado(String usuario, String pass, String nombre, String apellido, String tel, int edad) throws Exception {
		
		Agencia.getInstance().registroEmpleado(usuario, pass, nombre, apellido, tel, edad);
	}
	
	@After
	public void tearDown() throws Exception{
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
		
	}
	
	@Test
	public void testLoginCambioPanel() {
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.NOMBRE_USUARIO);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.PASSWORD);
		JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Meel", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("LLdoe234", robot);
		
		TestUtils.clickComponent(login, robot);
		robot.delay(TestUtils.getDelay());
		
		Assert.assertTrue("Deberia cambiar de panel", ((JButton)TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.CERRARSESION)).isEnabled());
	}
	
	
	@Test
	public void testCambioPanelBotonReg() {
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REGISTRAR);

		TestUtils.clickComponent(registrar, robot);
		
		robot.delay(TestUtils.getDelay());
		
		Assert.assertTrue("Deberia cambiar de panel", ((JButton)TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.REG_BUTTON_CANCELAR)).isEnabled());
	}
	
	
	
	@Test 
	public void testCambioPanelAdmin(){
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.NOMBRE_USUARIO);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.PASSWORD);
		JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
		

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("admin", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("admin", robot);

		
		TestUtils.clickComponent(login, robot);
		robot.delay(TestUtils.getDelay());
		
		Assert.assertTrue("Deberia cambiar de panel", ((JTextField)TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.TEXTO_INFERIOR)).isEnabled());
		
	}
}

