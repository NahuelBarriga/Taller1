package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import util.Constantes;
import vista.Ventana;
import vista.PanelAdmin;

public class TestGuiEnabledDisabledAdmin {

	Robot robot; 
	Controlador controlador;
	
	public TestGuiEnabledDisabledAdmin() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	@Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        Ventana ventana = (Ventana) controlador.getVista();
        ventana.setContentPane(new PanelAdmin(controlador));
    }
	
	@After
    public void tearDown() throws Exception
    {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
    }
	
	
	@Test
	public void testModificarValoresDiabled1() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textoInferior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_INFERIOR);

		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoInferior,robot);
		TestUtils.tipeaTexto("20000", robot);
		
		Assert.assertFalse("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}
	
	public void testModificarValoresDiabled2() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textoSuperior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_SUPERIOR);
		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoSuperior,robot);
		TestUtils.tipeaTexto("20000", robot);
		
		Assert.assertFalse("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}
	
	public void testModificarValoresDiabled3() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();

		JTextField textoInferior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_INFERIOR);
		JTextField textoSuperior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_SUPERIOR);		
		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoInferior,robot);
		TestUtils.tipeaTexto("-200", robot);
		TestUtils.clickComponent(textoSuperior,robot);
		TestUtils.tipeaTexto("20000", robot);
		Assert.assertFalse("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}

	
	public void testModificarValoresDiabled4() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textoInferior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_INFERIOR);
		JTextField textoSuperior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_SUPERIOR);
		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoInferior,robot);
		TestUtils.tipeaTexto("200", robot);
		TestUtils.clickComponent(textoSuperior,robot);
		TestUtils.tipeaTexto("-2000", robot);
		Assert.assertFalse("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}
	
	public void testModificarValoresDiabled5() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textoInferior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_INFERIOR);
		JTextField textoSuperior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_SUPERIOR);
		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoInferior,robot);
		TestUtils.tipeaTexto("-200", robot);
		TestUtils.clickComponent(textoSuperior,robot);
		TestUtils.tipeaTexto("-100", robot);
		Assert.assertFalse("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}
	
	public void testModificarValoresDiabled6() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textoInferior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_INFERIOR);
		JTextField textoSuperior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_SUPERIOR);		
		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoInferior,robot);
		TestUtils.tipeaTexto("40000", robot);
		TestUtils.clickComponent(textoSuperior,robot);
		TestUtils.tipeaTexto("20000", robot);
		Assert.assertFalse("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}
	
	public void testModificarValoresEnabled() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textoInferior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_INFERIOR);
		JTextField textoSuperior = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTO_SUPERIOR);
		JButton modValores = (JButton) TestUtils.getComponentForName(ventana, Constantes.MODIFICAR_VALORES);

		TestUtils.clickComponent(textoInferior,robot);
		TestUtils.tipeaTexto("20000", robot);
		TestUtils.clickComponent(textoSuperior,robot);
		TestUtils.tipeaTexto("40000", robot);
		Assert.assertTrue("El boton de Modificar deberia estar deshabilitado", modValores.isEnabled());

	}
	
}
