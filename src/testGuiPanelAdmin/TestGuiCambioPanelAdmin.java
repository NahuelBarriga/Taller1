package testGuiPanelAdmin;

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
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import util.Constantes;
import vista.PanelAdmin;
import vista.PanelCliente;
import vista.PanelRegistro;
import vista.Ventana;
import test.FalsoOptionPane;
import test.TestUtils;

public class TestGuiCambioPanelAdmin {
	Robot robot;
	Controlador controlador;
	
	FalsoOptionPane optionPane = new FalsoOptionPane();
	
	public TestGuiCambioPanelAdmin() {
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
	public void testApretarCerrarSesion() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton cerrarSesion = (JButton) TestUtils.getComponentForName(ventana, Constantes.CERRARSESION);

		TestUtils.clickComponent(cerrarSesion,robot);
		
		robot.delay(TestUtils.getDelay());
		
		Assert.assertTrue("Deberia cambiar de panel", ((JButton)TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.REGISTRAR)).isEnabled());
		
	}
}
