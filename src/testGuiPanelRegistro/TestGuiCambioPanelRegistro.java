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
import util.Constantes;
import vista.PanelRegistro;
import vista.Ventana;
import test.FalsoOptionPane;
import test.TestUtils;

public class TestGuiCambioPanelRegistro {
	Robot robot;
	Controlador controlador;
	FalsoOptionPane optionPane = new FalsoOptionPane();
	
	public TestGuiCambioPanelRegistro() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	@Before
	public void setUp() throws Exception{
		controlador = new Controlador();
		controlador.setMyOptionPane(optionPane);
		
		Ventana ventana = (Ventana) controlador.getVista();
        ventana.setContentPane(new PanelRegistro(controlador));
	}
	
	
	@After
	public void tearDown() throws Exception{
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
		
	}
	
	@Test
	public void testApretaRegistrar() {
		
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();
		
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
		
		robot.delay(TestUtils.getDelay());
		
		Assert.assertTrue("Deberia cambiar de panel", ((JButton)TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NUEVOTICKET)).isEnabled());
	}
	
	@Test
	public void testApretaCancelar() {
		robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton cancelar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_CANCELAR);

		TestUtils.clickComponent(cancelar, robot);
		
		robot.delay(TestUtils.getDelay());
		
		Assert.assertTrue("Deberia cambiar de panel", ((JButton)TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.REGISTRAR)).isEnabled());
	}
	
}
