package test;

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
import util.Mensajes;

//Esta clase verifica que los botones se habiliten y deshabiliten cuando se ingresa o se borra el texto en los diferentes JTextField.

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
	
//PANEL REGISTRO
	
	//para el EMPLEADOR
	@Test
	public void testRegistroEmpleadorCompleto(){
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
		
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
		JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
		JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);

		
		
		JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
		
		
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
		
		
		Assert.assertTrue("El boton de registrar deberia estar habilitado", registrar.isEnabled());
	}
	
	@Test
	public void testRegistroEmpleadorSoloNombreReal(){
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
		
		JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
		
		JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
		
		
		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Clara", robot);
		
		Assert.assertFalse("El boton de registrar deberia estar deshabilitado", registrar.isEnabled());
	}
	
	@Test
	public void testRegistroEmpleadorPassYConfirmacionPass(){
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JRadioButton empleador = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADOR);
		
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
		JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
		
		JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
		
		TestUtils.clickComponent(empleador, robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("123456", robot);
		TestUtils.clickComponent(confPassword, robot);
		TestUtils.tipeaTexto("123456", robot);
		
		Assert.assertFalse("El boton de registrar deberia estar deshabilitado", registrar.isEnabled());
	}

	//para el EMPLEADO
		@Test
		public void testRegistroEmpleadoCompleto(){
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton empleado = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EMPLEADO);
			
			JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_USSER_NAME);
			JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_PASSWORD);
			JTextField confPassword = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_CONFIRM_PASSWORD);
			JTextField nombreReal = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_REAL_NAME);
			JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_TELEFONO);
			JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_APELLIDO);
			JTextField edad = (JTextField) TestUtils.getComponentForName(ventana, Constantes.REG_EDAD);
			
			JButton registrar = (JButton) TestUtils.getComponentForName(ventana, Constantes.REG_BUTTON_REGISTRAR);
			
			// agregar que se selccione el radiobuutton de empleado -> ver si funciona 
			TestUtils.clickComponent(empleado, robot);
			
			TestUtils.clickComponent(nombreUsuario, robot);
			TestUtils.tipeaTexto("Marr91", robot);
			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto("GL4852", robot);
			TestUtils.clickComponent(confPassword, robot);
			TestUtils.tipeaTexto("GL4852", robot);
			TestUtils.clickComponent(nombreReal, robot);
			TestUtils.tipeaTexto("Martina", robot);
			TestUtils.clickComponent(telefono, robot);
			TestUtils.tipeaTexto("229987557", robot);
			TestUtils.clickComponent(apellido, robot);
			TestUtils.tipeaTexto("Perez", robot);
			TestUtils.clickComponent(edad, robot);
			TestUtils.tipeaTexto("34", robot);
			
			
			Assert.assertTrue("El boton de registrar deberia estar habilitado", registrar.isEnabled());
		}




///PANEL CLIENTE
		
		@Test
		public void testConfirmarNuevoTicketDeshabilitado1() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton cerrarSesion = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.CERRARSESION);
			JRadioButton nuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
			JRadioButton confNuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
			JRadioButton seleccionarCandidato = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.SELECCIONAR_CANDIDATO);
			JRadioButton textAreaResult = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXT_AREA_RESULTADOS);
			JRadioButton listaCandidatos = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.LISTA_CANDIDATOS);
			JRadioButton remuneracion = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

			TestUtils.clickComponent(nuevoTicket,robot);
			TestUtils.clickComponent(remuneracion, robot);
			TestUtils.tipeaTexto("-20000", robot);
			
			Assert.assertFalse("El boton de ACEPTAR deberia estar deshabilitado", confNuevoTicket.isEnabled());
			
		}
		
		
		public void testConfirmarNuevoTicketDeshabilitado2() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton nuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
			JRadioButton confNuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
			JRadioButton remuneracion = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

			TestUtils.clickComponent(nuevoTicket,robot);
			TestUtils.clickComponent(remuneracion, robot);
			TestUtils.tipeaTexto("", robot);
			
			Assert.assertFalse("El boton de ACEPTAR deberia estar deshabilitado", confNuevoTicket.isEnabled());
			
		}
		
		@Test
		public void testConfirmarNuevoTicketHabilitado() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton nuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
			JRadioButton confNuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
			JRadioButton remuneracion = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

			TestUtils.clickComponent(nuevoTicket,robot);
			TestUtils.clickComponent(remuneracion, robot);
			TestUtils.tipeaTexto("20000", robot);
			TestUtils.clickComponent(confNuevoTicket,robot);
			
			Assert.assertTrue("El boton de ACEPTAR deberia estar habilitado", confNuevoTicket.isEnabled());
			
		}
		
		
		@Test
		public void testNuevoTicketDeshabilitado() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton nuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
			
			TestUtils.clickComponent(nuevoTicket,robot);
			
			Assert.assertFalse("El boton de NuevoTicket deberia estar deshabilitado", nuevoTicket.isEnabled());
			
		}
		
		@Test
		public void testNuevoTicketHabilitado() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton nuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
			JRadioButton confNuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
			JRadioButton remuneracion = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

			TestUtils.clickComponent(nuevoTicket,robot);
			TestUtils.clickComponent(remuneracion, robot);
			TestUtils.tipeaTexto("20000", robot);
			TestUtils.clickComponent(confNuevoTicket,robot);
			
			Assert.assertTrue("El boton de NuevoTicket deberia estar Habilitado", nuevoTicket.isEnabled());
			
		}
		
		@Test
		public void testEliminarTicketDeshabilitado() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton textAreaTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXT_AREA_TICKET);
			JRadioButton eliminarTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.ELIMINAR_TICKET);
			
			
			Assert.assertEquals("El textField seberia ser Sin Ticket Creado", textAreaTicket, Mensajes.SIN_TICKET.getValor());
			Assert.assertFalse("El boton de ELIMINAR TICKET  deberia estar deshabilitado", eliminarTicket.isEnabled());
			
		}
		
		
		@Test
		public void testEliminarTicketHabilitado() {
			robot.delay(TestUtils.getDelay());
			
			Ventana ventana = (Ventana) controlador.getVista();
			
			JRadioButton textAreaTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXT_AREA_TICKET);
			JRadioButton eliminarTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.ELIMINAR_TICKET);
			JRadioButton nuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
			JRadioButton confNuevoTicket = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
			JRadioButton remuneracion = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

			TestUtils.clickComponent(nuevoTicket,robot);
			TestUtils.clickComponent(remuneracion, robot);
			TestUtils.tipeaTexto("20000", robot);
			TestUtils.clickComponent(confNuevoTicket,robot);
			
			Assert.assertTrue("El boton de ELIMINAR TICKET  deberia estar habilitado", eliminarTicket.isEnabled());
			
		}

}
		
