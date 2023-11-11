package testGuiPanelRegistro;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;


import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import util.Constantes;
import vista.PanelRegistro;
import vista.PanelLogin;
import vista.Ventana;


import test.FalsoOptionPane;
import test.TestUtils;


public class TestGuiCambioPanelRegistro {

	Robot robot; 
	Controlador controlador;
	
	public TestGuiCambioPanelRegistro() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	
	@Before
	public void setUp() throws Exception {
		controlador = new Controlador();
        Ventana ventana = (Ventana) controlador.getVista();
        ventana.setContentPane(new PanelRegistro(controlador));
        
	}

	@After
	public void tearDown() throws Exception {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
		
	}

	@Test
	public void testApretaCancelar() {
		robot.delay(TestUtils.getDelay());
		Ventana ventanaReg = (Ventana) controlador.getVista();
		Ventana ventanaLog = (Ventana) controlador.getVista();
		
		JButton botCancelar = (JButton) TestUtils.getComponentForName(ventanaReg, Constantes.REG_BUTTON_CANCELAR);
		JTextField usserName = (JTextField) TestUtils.getComponentForName(ventanaLog, Constantes.NOMBRE_USUARIO);
		
		TestUtils.clickComponent(botCancelar, robot);
		
		Assert.assertNotNull("No deberia ser NULL",usserName);
		
	}

}
