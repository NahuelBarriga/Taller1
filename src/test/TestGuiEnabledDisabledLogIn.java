package test;

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
import vista.PanelLogin;
//Esta clase verifica que los botones se habiliten y deshabiliten cuando se ingresa o se borra el texto en los diferentes JTextField.
import vista.Ventana;

public class TestGuiEnabledDisabledLogIn {

	Robot robot; 
	Controlador controlador;
	
	public TestGuiEnabledDisabledLogIn() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	@Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        Ventana ventana = (Ventana) controlador.getVista();
        ventana.setContentPane(new PanelLogin(controlador));
    }
	
	@After
    public void tearDown() throws Exception
    {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
    }
	
	//PANEL LOGIN
	@Test
	public void testLoginCompleto(){
		robot.delay(TestUtils.getDelay());
		//referencia a los componentes
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.NOMBRE_USUARIO);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.PASSWORD);
		JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
		
		//completo
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Pepe123", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("123456", robot);
		
		//verificar
		Assert.assertTrue("El boton de login deberia estar habilitado", login.isEnabled());
	}
	
	@Test
	public void testLoginSoloNombreUsuario() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.NOMBRE_USUARIO);
		JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
		
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Maria09", robot);
		
		Assert.assertFalse("El boton de login deberia estar deshabilitado", login.isEnabled());
		
	}
	
	@Test
	public void testLoginSoloPassword() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.PASSWORD);
		JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
		
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("qwery55", robot);
		
		Assert.assertFalse("El boton de login deberia estar deshabilitado", login.isEnabled());
	}
	
	
	
}
