package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;

public class TestEmpleador {
	private Empleador empleador;
	int remuneracion;
	Ticket ticket;
	
	@Before
	public void setUp() {
		this.empleador = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.SALUD,
				util.Constantes.FISICA);
		this.remuneracion = 200000;
		this.ticket = new Ticket("PRESENCIAL", remuneracion, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
	}
	
	@Test
	public void  testEmpleadorUsertName() {
		Assert.assertEquals("Falla en constructor, parametro: UsserName", "Juan123",empleador.getUsserName());
	}
	
	@Test
	public void testEmpleadorPassword() {
		Assert.assertEquals("Falla en constructor, parametro: Password", "Juan123",this.empleador.getPassword());
	}
	
	@Test
	public void testEmpleadorRealName() {
		Assert.assertEquals("Falla en constructor, parametro: RealName","Juan",this.empleador.getRealName());
	}
	
	@Test
	public void testEmpleadorTelefono() {
		Assert.assertEquals("Falla en constructor, parametro: Telefono", "2235698547",this.empleador.getTelefono());
	}
	
	@Test
	public void testEmpleadorRubro() {
		Assert.assertEquals("Falla en constructor, parametro: Rubro", util.Constantes.SALUD,empleador.getRubro());
	}
	
	@Test
	public void testEmpleadorTipoPersona() {
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", util.Constantes.FISICA, empleador.getTipoPersona());
	}
	
	@Test
	public void testCalculaComisionSalud() {
		double esperada = this.remuneracion*0.6;
		Assert.assertEquals("Falla en calculo de comision, escenario salud", esperada, this.empleador.calculaComision(this.ticket),0);
	}
	
	@Test
	public void testCalculaComisionLocal() {
		Empleador empleador = new Empleador("Juan123", "Juan123", "Juan", "2235698547",
				util.Constantes.COMERCIO_LOCAL, util.Constantes.FISICA);
		double esperada = this.remuneracion*0.7;
		Assert.assertEquals("Falla en calculo de comision, escenario local", esperada, empleador.calculaComision(this.ticket),0);
	}
	
	@Test
	public void testCalculaComisionInternacional() {
		Empleador empleador = new Empleador("Juan123", "Juan123", "Juan", "2235698547",
				util.Constantes.COMERCIO_INTERNACIONAL, util.Constantes.FISICA);
		double esperada = this.remuneracion*0.8;
		Assert.assertEquals("Falla en calculo de comision, escenario internacional", esperada, empleador.calculaComision(this.ticket),0);
		
	}
	
	@Test
	public void TestSetCandidato() { 
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.SALUD, util.Constantes.FISICA);
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Marcos123", "Marcos123", "Marcos", "2235698456", "Rodriguez", 25);
		empleadorTest.setCandidato(empleadoTest); 

		Assert.assertEquals("Falla en setCandidato, candidato no agregado", empleadoTest, empleadorTest.getCandidato());
	}
	
	@Test
	public void TestSetListaDePostulantes() {
		ArrayList<ClientePuntaje> listaPostulantesTest = new ArrayList<ClientePuntaje>();
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "salud", "fisica");
		empleadorTest.setListaDePostulantes(listaPostulantesTest);
		Assert.assertEquals("La lista de postulantes no se seteo correctamente", listaPostulantesTest, empleadorTest.getListaDePostulantes());
		
	}

}
