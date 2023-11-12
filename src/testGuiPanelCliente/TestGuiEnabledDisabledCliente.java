package testGuiPanelCliente;

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
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;
import vista.PanelCliente;
import vista.Ventana;

import test.FalsoOptionPane;
import test.TestUtils;


//Esta clase verifica que los botones se habiliten y deshabiliten cuando se ingresa o se borra el texto en los diferentes JTextField.

public class TestGuiEnabledDisabledCliente {

	Robot robot; 
	Controlador controlador;
	
	public TestGuiEnabledDisabledCliente() {
		try {
			robot = new Robot();
		}catch (AWTException e) {}
	}
	
	@Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        Cliente ep = new EmpleadoPretenso("Pepe123","123456","Facundo","2235414003","Flores",34);
        Ventana ventana = (Ventana) controlador.getVista();
        ventana.setContentPane(new PanelCliente(ep, controlador, 0 ,ep));
    }
	
	@After
    public void tearDown() throws Exception
    {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
    }
	
	@Test
	public void testConfirmarNuevoTicketDeshabilitado1() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();

		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
		JButton confNuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

		
		TestUtils.clickComponent(nuevoTicket,robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("-20000", robot);
		
		Assert.assertFalse("El boton de ACEPTAR deberia estar deshabilitado", confNuevoTicket.isEnabled());
		
	}
	
	@Test
	public void testConfirmarNuevoTicketDeshabilitado2() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
		JButton confNuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

		TestUtils.clickComponent(nuevoTicket,robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("", robot);
		
		Assert.assertFalse("El boton de ACEPTAR deberia estar deshabilitado", confNuevoTicket.isEnabled());
		
	}
	
	@Test
	public void testConfirmarNuevoTicketHabilitado() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
		JButton confNuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

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
		
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
		
		TestUtils.clickComponent(nuevoTicket,robot);
		
		Assert.assertFalse("El boton de NuevoTicket deberia estar deshabilitado", nuevoTicket.isEnabled());
		
	}
	
	@Test
	public void testNuevoTicketHabilitado() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
		JButton confNuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

		TestUtils.clickComponent(nuevoTicket,robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("20000", robot);
		TestUtils.clickComponent(confNuevoTicket,robot);
		
		Assert.assertTrue("El boton de NuevoTicket deberia estar Habilitado", nuevoTicket.isEnabled());
		
	}
	
	@Test
	public void testRadioButtonsDisabled() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
	
		
		JRadioButton JorMedia = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.JORNADA_MEDIA);
		JRadioButton JorCompleta = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.JORNADA_COMPLETA);
		JRadioButton JorExtendida = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.JORNADA_EXTENDIDA);

		JRadioButton ExpNada = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EXP_NADA);
		JRadioButton ExpMedia = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EXP_MEDIA);
		JRadioButton ExpMucha = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EXP_MUCHA);

		JRadioButton terciarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TERCIARIOS);
		JRadioButton secundarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.SECUNDARIOS);
		JRadioButton primarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.PRIMARIOS);

		JRadioButton junior = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.JUNIOR);
		JRadioButton senior = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.SENIOR);
		JRadioButton managment = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.MANAGMENT);

		JRadioButton presencial = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.PRESENCIAL);
		JRadioButton homeoffice = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.HOME_OFFICE);
		JRadioButton indistinto = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.INDISTINTO);
		
		Assert.assertFalse("El boton de JorMedia deberia estar deshabilitado", JorMedia.isEnabled());
		Assert.assertFalse("El boton de JorCompleta deberia estar deshabilitado", JorCompleta.isEnabled());
		Assert.assertFalse("El boton de JorExtendida deberia estar deshabilitado", JorExtendida.isEnabled());
		
		Assert.assertFalse("El boton de Experiencia Nada deberia estar deshabilitado", ExpNada.isEnabled());
		Assert.assertFalse("El boton de Experiencia Media deberia estar deshabilitado", ExpMedia.isEnabled());
		Assert.assertFalse("El boton de Experiencia Mucha deberia estar deshabilitado", ExpMucha.isEnabled());
		
		Assert.assertFalse("El boton de Estudios cursados Terciarios deberia estar deshabilitado", terciarios.isEnabled());
		Assert.assertFalse("El boton de Estudios cursados Primarios deberia estar deshabilitado", primarios.isEnabled());
		Assert.assertFalse("El boton de Estudios cursados Secundarios deberia estar deshabilitado", secundarios.isEnabled());
		
		Assert.assertFalse("El boton de Tipo de puesto Junior deberia estar deshabilitado", junior.isEnabled());
		Assert.assertFalse("El boton de Tipo de puesto senior deberia estar deshabilitado", senior.isEnabled());
		Assert.assertFalse("El boton de Tipo de puesto mangment deberia estar deshabilitado", managment.isEnabled());
		
	
		Assert.assertFalse("El boton de locacion homeoffice deberia estar deshabilitado", homeoffice.isEnabled());
		Assert.assertFalse("El boton de locacion presencial deberia estar deshabilitado", presencial.isEnabled());
		Assert.assertFalse("El boton de locacion indistinto deberia estar deshabilitado", indistinto.isEnabled());
		
	}
	
	
	
	@Test
	public void testRadioButtonsEnabled() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);

		
		JRadioButton JorMedia = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.JORNADA_MEDIA);
		JRadioButton JorCompleta = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.JORNADA_COMPLETA);
		JRadioButton JorExtendida = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.JORNADA_EXTENDIDA);

		JRadioButton ExpNada = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EXP_NADA);
		JRadioButton ExpMedia = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EXP_MEDIA);
		JRadioButton ExpMucha = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.EXP_MUCHA);

		JRadioButton terciarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.TERCIARIOS);
		JRadioButton secundarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.SECUNDARIOS);
		JRadioButton primarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.PRIMARIOS);

		JRadioButton junior = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.JUNIOR);
		JRadioButton senior = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.SENIOR);
		JRadioButton managment = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.MANAGMENT);

		JRadioButton presencial = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.PRESENCIAL);
		JRadioButton homeoffice = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.HOME_OFFICE);
		JRadioButton indistinto = (JRadioButton) TestUtils.getComponentForName(ventana,Constantes.INDISTINTO);

		TestUtils.clickComponent(nuevoTicket,robot);

		
		Assert.assertTrue("El boton de JorMedia deberia estar habilitado", JorMedia.isEnabled());
		Assert.assertTrue("El boton de JorCompleta deberia estar habilitado", JorCompleta.isEnabled());
		Assert.assertTrue("El boton de JorExtendida deberia estar habilitado", JorExtendida.isEnabled());
		
		Assert.assertTrue("El boton de Experiencia Nada deberia estar habilitado", ExpNada.isEnabled());
		Assert.assertTrue("El boton de Experiencia Media deberia estar habilitado", ExpMedia.isEnabled());
		Assert.assertTrue("El boton de Experiencia Mucha deberia estar habilitado", ExpMucha.isEnabled());
		
		Assert.assertTrue("El boton de Estudios cursados Terciarios deberia estar habilitado", terciarios.isEnabled());
		Assert.assertTrue("El boton de Estudios cursados Primarios deberia estar habilitado", primarios.isEnabled());
		Assert.assertTrue("El boton de Estudios cursados Secundarios deberia estar deshabilitado", secundarios.isEnabled());
		
		Assert.assertTrue("El boton de Tipo de puesto Junior deberia estar habilitado", junior.isEnabled());
		Assert.assertTrue("El boton de Tipo de puesto senior deberia estar habilitado", senior.isEnabled());
		Assert.assertTrue("El boton de Tipo de puesto mangment deberia estar habilitado", managment.isEnabled());
		
	
		Assert.assertTrue("El boton de locacion homeoffice deberia estar deshabilitado", homeoffice.isEnabled());
		Assert.assertTrue("El boton de locacion presencial deberia estar deshabilitado", presencial.isEnabled());
		Assert.assertTrue("El boton de locacion indistinto deberia estar deshabilitado", indistinto.isEnabled());
		
	}
	
	@Test
	public void testEliminarTicketDeshabilitado() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();
		
		JTextField textAreaTicket = (JTextField) TestUtils.getComponentForName(ventana, Constantes.TEXT_AREA_TICKET);
		JButton eliminarTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.ELIMINAR_TICKET);
		
		
		//Assert.assertEquals("El textField seberia ser Sin Ticket Creado", textAreaTicket, Mensajes.SIN_TICKET.getValor());
		Assert.assertFalse("El boton de ELIMINAR TICKET  deberia estar deshabilitado", eliminarTicket.isEnabled());
		
	}
	
	
	@Test
	public void testEliminarTicketHabilitado() {
		robot.delay(TestUtils.getDelay());
		
		Ventana ventana = (Ventana) controlador.getVista();

		JButton eliminarTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.ELIMINAR_TICKET);
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.NUEVOTICKET);
		JButton confNuevoTicket = (JButton) TestUtils.getComponentForName(ventana, Constantes.CONFIRMARNUEVOTICKET);
		JButton remuneracion = (JButton) TestUtils.getComponentForName(ventana, Constantes.TEXTFIELD_REMUNERACION);

		TestUtils.clickComponent(nuevoTicket,robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("20000", robot);
		TestUtils.clickComponent(confNuevoTicket,robot);
		
		Assert.assertTrue("El boton de ELIMINAR TICKET  deberia estar habilitado", eliminarTicket.isEnabled());
		
	}

}