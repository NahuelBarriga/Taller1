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
		JRadioButton secunarios = (JRadioButton) TestUtils.getComponentForName(ventana, Constantes.SECUNDARIOS);
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