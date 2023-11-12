package testGuiPanelRegistro;

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
import vista.PanelRegistro;
import vista.Ventana;
import test.TestUtils;
import test.FalsoOptionPane;


public class TestGuiEnabledDisabledRegistro {

	Robot robot; 
	Controlador controlador;
	
	public TestGuiEnabledDisabledRegistro() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	@Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        Ventana ventana = (Ventana) controlador.getVista();
        ventana.setContentPane(new PanelRegistro(controlador));
    }
	
	@After
    public void tearDown() throws Exception
    {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
    }


		@Test
		public void testRegistroEmpleadorCompleto(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();

			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Pepe123", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("123456", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("123456", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Pedro", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("117878945", robot);
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertTrue("El boton de registrar deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSoloUsser(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
				
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("234Eme", robot);
						
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSoloPassword(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
				
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("Lfpw03f", robot);
						
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSoloConfPassword(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
				
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("Lfpw03f", robot);
						
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSoloNombreReal(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
							
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Clara", robot);
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSoloTelefono(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
			TestUtils.clickComponent(empleador, robot);
			
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("1122334456", robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}

		@Test
		public void testRegistroEmpleadorSinUsser(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();

			
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("123456", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("123456", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Pedro", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("117878945", robot);
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSinPassword(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Marie#4", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("Fwof83D", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Mariela", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("223344556", robot);
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSinConfPassword(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Lee", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("fF42sZZ", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Jean", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("990022343", robot);
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSinRealName(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Clee", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("L34Frg", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("L34Frg", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("774463524", robot);
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		@Test
		public void testRegistroEmpleadorSinTelefono(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			
			JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Frans23!", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("F7542", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("F7542", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Francisco", robot);
			
			
			TestUtils.clickComponent(empleador, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		
		///////////////////para el EMPLEADO////////////////////////////////////////////
		@Test
		public void testRegistroEmpleadoSinApellido(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			JTextField edad = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_EDAD);			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);			
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Mark14", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("Ledj32FF", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("Ledj32FF", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Marcos", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("334435674", robot);
			TestUtils.clickComponent(edad, robot);
			TestUtils.tipeaTexto("24", robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
			@Test
			public void testRegistroEmpleadoCompleto(){
				robot.delay(TestUtils.getDelay());
				
				Ventana ventana = (Ventana) controlador.getVista();
				
				JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
				JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
				JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
				JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
				JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
				JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_APELLIDO);
				JTextField edad = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_EDAD);
				
				JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
				
				JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
				
								
				TestUtils.clickComponent(nombreUsuario, robot);
				TestUtils.tipeaTexto("Viv", robot);
				TestUtils.clickComponent(password, robot);
				TestUtils.tipeaTexto("Viv234", robot);
				TestUtils.clickComponent(confPassword, robot);
				TestUtils.tipeaTexto("Viv234", robot);
				TestUtils.clickComponent(nombreReal, robot);
				TestUtils.tipeaTexto("Viviana", robot);
				TestUtils.clickComponent(telefono, robot);
				TestUtils.tipeaTexto("2234477558", robot);
				TestUtils.clickComponent(apellido, robot);
				TestUtils.tipeaTexto("Verz", robot);
				TestUtils.clickComponent(edad, robot);
				TestUtils.tipeaTexto("34", robot);
				
				TestUtils.clickComponent(empleado, robot);
				
				Assert.assertTrue("El boton de registrar deberia estar habilitado", regRegistrar.isEnabled());
			}

		 //la edad la deberia probar como negativa?????
		
		@Test
		public void testRegistroEmpleadoSoloApellido(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_APELLIDO);
			
			JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(apellido, robot);
			TestUtils.tipeaTexto("Bianz", robot);
			
			TestUtils.clickComponent(empleado, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		
		public void testRegistroEmpleadoSinEdad(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_APELLIDO);
			
			JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Li2us3", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("jbcfow98", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("jbcfow98", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Luis", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("3322477543", robot);
			TestUtils.clickComponent(apellido, robot);
			TestUtils.tipeaTexto("Marquez", robot);
			
			TestUtils.clickComponent(empleado, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}
		
		
		@Test
		public void testRegistroEmpleadoSoloEdad(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JTextField edad = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_EDAD);
			
			JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
			
			JButton regRegistrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
						
			TestUtils.clickComponent(edad, robot);
			TestUtils.tipeaTexto("21", robot);
			
			TestUtils.clickComponent(empleado, robot);
			
			Assert.assertFalse("El boton de registrar no deberia estar habilitado", regRegistrar.isEnabled());
		}

}
