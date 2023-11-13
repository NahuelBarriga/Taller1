package testGuiPanelRegistro;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JRadioButton;
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
import util.Mensajes;
import vista.PanelRegistro;
import vista.Ventana;
import test.TestUtils;

import test.FalsoOptionPane;

public class TestGuiConjuntoConDatosRegistro {
	Robot robot;
	Controlador controlador;
	FalsoOptionPane optionPane = new FalsoOptionPane();
	
	public TestGuiConjuntoConDatosRegistro() {
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
		 
		this.registrarEmpleado("JuliGomez", "654321","Juliana", "Gomez", "9984737372", 21);
		this.registrarEmpleado("Cari34", "LSk7F","Carola", "2737382992", "Diaz", 25);
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
	public void testUsuarioRepetido() {		
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();		
		
		JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REGISTRAR);
		TestUtils.clickComponent(registrar, robot);
		robot.delay(TestUtils.getDelay());

		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
		JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
		JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
		JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_APELLIDO);
		JTextField edad = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_EDAD);
		
		JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADO);
		
		JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
		
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("JuliGomez",  robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("654321", robot);
		TestUtils.clickComponent(confPassword, robot);
		TestUtils.tipeaTexto("654321", robot);
		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Juliana", robot);
		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("9984737372", robot);
		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Gomez", robot);
		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("21", robot);
		
		TestUtils.clickComponent(empleado, robot);
		TestUtils.clickComponent(regRegistrar, robot);
		robot.delay(1000);
		
		System.out.println("Msj del optPanel: "+optionPane.getMensaje());
		
		Assert.assertEquals("Deberia decir:"+Mensajes.USUARIO_REPETIDO.getValor(), Mensajes.USUARIO_REPETIDO.getValor(),optionPane.getMensaje());
		
	}

	@Test
	public void testContrasNoCoinciden() {
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REGISTRAR);
		TestUtils.clickComponent(registrar, robot);
		robot.delay(TestUtils.getDelay());
		
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
		JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
		JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
		JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_APELLIDO);
		JTextField edad = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_EDAD);
		
		JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADO);
		
		JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
		
						
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Viv", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Viv234", robot);
		TestUtils.clickComponent(confPassword, robot);
		TestUtils.tipeaTexto("Viv2347", robot);
		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Viviana", robot);
		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2234477558", robot);
		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Verz", robot);
		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("34", robot);
		
		TestUtils.clickComponent(empleado, robot);
		TestUtils.clickComponent(regRegistrar, robot);
		System.out.println("Msj del optPanel: "+ optionPane.getMensaje());
	
		Assert.assertEquals("Deberia decir:"+Mensajes.PASS_NO_COINCIDE.getValor(), Mensajes.PASS_NO_COINCIDE.getValor(),optionPane.getMensaje());
	}
	
	
}

