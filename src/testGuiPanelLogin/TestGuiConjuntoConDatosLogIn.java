package testGuiPanelLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
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
import vista.Ventana;
import test.FalsoOptionPane;
import test.TestUtils;


public class TestGuiConjuntoConDatosLogIn {
	Robot robot;
	Controlador controlador;
	FalsoOptionPane optionPane = new FalsoOptionPane();
	
	public TestGuiConjuntoConDatosLogIn() {
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
		//Registar 3 usuarios validos 
		this.registrarEmpleado("Meel", "LLdoe234","Melisa", "Lopez", "9984737372", 34);
		this.registrarEmpleado("Cari34", "LSk7F","Carola", "2737382992", "Diaz", 25);
		//this.registrarEmpleado("Czzzz", "sss","xxx", "333333", "Diaz", 21);
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
    public void testCantRegistrados(){
		
        Assert.assertEquals("Debe haber 2 empleados registrados", 2, Agencia.getInstance().getEmpleados().size());
        Assert.assertEquals("Debe haber 1 empleador registrado", 1, Agencia.getInstance().getEmpleadores().size());
    }
	
	@Test
    public void testLoginContraseniaErronea(){ 
        robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();

        //referencias de los componentes
        JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana, Constantes.NOMBRE_USUARIO);
		JTextField password = (JTextField) TestUtils.getComponentForName(ventana, Constantes.PASSWORD);
		JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
		
        //completo
        TestUtils.clickComponent(nombreUsuario, robot);
        TestUtils.tipeaTexto("Cari34", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("Qwerty", robot);
        
        TestUtils.clickComponent(login, robot);
      
        Assert.assertEquals("Deberia decir:"+Mensajes.PASS_ERRONEO.getValor() , Mensajes.PASS_ERRONEO.getValor() , optionPane.getMensaje());
    }
	
	  
	
	@Test
    public void testLoginUsuarioDesconocido(){
        robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();

        JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana,Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName(ventana,Constantes.PASSWORD);
        JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
  
        TestUtils.clickComponent(nombreUsuario, robot);
        TestUtils.tipeaTexto("Juan", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("dhao2d", robot);
        TestUtils.clickComponent(login, robot);
       
        Assert.assertEquals("Deberia decir:"+Mensajes.USUARIO_DESCONOCIDO.getValor() , Mensajes.USUARIO_DESCONOCIDO.getValor() , optionPane.getMensaje());
    }
	
	@Test
    public void testCerrarSesionEmpleadoEstadoInicial(){ //Cuando se cierra sesion que el panel de login este en el estado inicial
        robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();

        JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana,Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName(ventana,Constantes.PASSWORD);
        JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
        
        
        TestUtils.clickComponent(nombreUsuario, robot);
        TestUtils.tipeaTexto("Cari34", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("LSk7F", robot);
        TestUtils.clickComponent(login, robot);
        
        robot.delay(TestUtils.getDelay());
        
        JButton cerrarSesion = (JButton) TestUtils.getComponentForName(ventana, Constantes.CERRARSESION);
        TestUtils.clickComponent(cerrarSesion, robot);
        
        Assert.assertEquals("Deberia estar vacio","", nombreUsuario.getText());
        Assert.assertEquals("Deberia estar vacio","", password.getText());
        
    }
	
	@Test
    public void testCerrarSesionEmpleadorEstadoInicial(){ 
        robot.delay(TestUtils.getDelay());
		Ventana ventana = (Ventana) controlador.getVista();

        JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName(ventana,Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName(ventana,Constantes.PASSWORD);
        JButton login = (JButton) TestUtils.getComponentForName(ventana, Constantes.LOGIN);
        
        TestUtils.clickComponent(nombreUsuario, robot);
        TestUtils.tipeaTexto("Lee123", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("123456", robot);
        TestUtils.clickComponent(login, robot);
       
        robot.delay(TestUtils.getDelay());
        //cambia de panel
        JButton cerrarSesion = (JButton) TestUtils.getComponentForName(ventana, Constantes.CERRARSESION);
        TestUtils.clickComponent(cerrarSesion, robot);
        
        robot.delay(TestUtils.getDelay()+8000);

       Assert.assertEquals("Deberia estar vacio","",nombreUsuario.getText());
       Assert.assertEquals("Deberia estar vacio","", password.getText());

    }
    
}

