package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;

public class TestEmpleador {

	@Test
	public void  testEmpleador1() {
		
		String nombre =  "Juan123";
		String password =  "Juan123";
		String realName =  "Juan";
		String telefono =  "2235698547";
		String rubro =  util.Constantes.SALUD;
		String persona =  util.Constantes.FISICA;
		Empleador empleador = new Empleador("Juan123", "Juan123", "Juan", "2235698547", rubro, persona);
		
		Assert.assertNotNull("Falla en constructor, constructor nulo",empleador);
		Assert.assertEquals("Falla en constructor, parametro: UsserName", nombre,empleador.getUsserName());
		Assert.assertEquals("Falla en constructor, parametro: Password", password,empleador.getPassword());
		Assert.assertEquals("Falla en constructor, parametro: RealName",realName,empleador.getRealName());
		Assert.assertEquals("Falla en constructor, parametro: Telefono", telefono,empleador.getTelefono());
		Assert.assertEquals("Falla en constructor, parametro: Rubro", rubro,empleador.getRubro());
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", persona, empleador.getTipoPersona());
		
	}
	
	@Test
	public void  testEmpleador2() {
		String nombre =  "Juan123";
		String password =  "Juan123";
		String realName =  "Juan";
		String telefono =  "2235698547";
		String rubro =  util.Constantes.COMERCIO_INTERNACIONAL;
		String persona =  util.Constantes.JURIDICA;
		
		Empleador empleador = new Empleador("Juan123", "Juan123", "Juan", "2235698547", rubro, persona);
		Assert.assertNotNull("Falla en constructor, constructor nulo",empleador);
		Assert.assertEquals("Falla en constructor, parametro: UsserName", nombre,empleador.getUsserName());
		Assert.assertEquals("Falla en constructor, parametro: Password", password,empleador.getPassword());
		Assert.assertEquals("Falla en constructor, parametro: RealName",realName,empleador.getRealName());
		Assert.assertEquals("Falla en constructor, parametro: Telefono", telefono,empleador.getTelefono());
		Assert.assertEquals("Falla en constructor, parametro: Rubro", rubro,empleador.getRubro());
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", persona, empleador.getTipoPersona());
		
	}
	
	@Test
	public void  testEmpleador3() {
		String nombre =  "Juan123";
		String password =  "Juan123";
		String realName =  "Juan";
		String telefono =  "2235698547";
		String rubro =  util.Constantes.COMERCIO_LOCAL;
		String persona =  util.Constantes.FISICA;
		
		Empleador empleador = new Empleador("Juan123", "Juan123", "Juan", "2235698547", rubro, persona);
		Assert.assertNotNull("Falla en constructor, constructor nulo",empleador);
		Assert.assertEquals("Falla en constructor, parametro: UsserName", nombre,empleador.getUsserName());
		Assert.assertEquals("Falla en constructor, parametro: Password", password,empleador.getPassword());
		Assert.assertEquals("Falla en constructor, parametro: RealName",realName,empleador.getRealName());
		Assert.assertEquals("Falla en constructor, parametro: Telefono", telefono,empleador.getTelefono());
		Assert.assertEquals("Falla en constructor, parametro: Rubro", rubro,empleador.getRubro());
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", persona, empleador.getTipoPersona());
		
	}
	
	@Test
	public void testCalculaComision() {
		Empleador empleadorSaludTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.SALUD, util.Constantes.FISICA);
		Empleador empleadorInternacionalTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.COMERCIO_INTERNACIONAL, util.Constantes.FISICA);
		Empleador empleadorLocalTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.COMERCIO_LOCAL, util.Constantes.FISICA);
		int remuneracion = 250000;
		
		Ticket ticketTest = new Ticket("PRESENCIAL", remuneracion, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");

		//Escenario1:  this.empleador.rubro == "Salud"
		Double remuneracionSalud = empleadorSaludTest.calculaComision(ticketTest);
		Double remuneracionEsperada = remuneracion*0.6;
		Assert.assertEquals("Falla en calculo de comision, Escenario 1", remuneracionEsperada, remuneracionSalud);
		
		//Escenario2: this.rubro == "comercio_local" 
		Double remuneracionLocal = empleadorInternacionalTest.calculaComision(ticketTest);
		remuneracionEsperada = remuneracion*0.7;
		Assert.assertEquals("Falla en calculo de comision, Escenario 2", remuneracionEsperada, remuneracionLocal);
		
		//Escenario3 this.rubro == "comercio_internacional"	
		Double remuneracionInternacional = empleadorLocalTest.calculaComision(ticketTest);
		remuneracionEsperada = remuneracion*0.8;
		Assert.assertEquals("Falla en calculo de comision, Escenario 3", remuneracionEsperada, remuneracionInternacional);
		
		
	}
	
	@Test
	public void TestSetCandidato() { 
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.SALUD, util.Constantes.FISICA);
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Marcos123", "Marcos123", "Marcos", "2235698456", "Rodriguez", 25);
		empleadorTest.setCandidato(empleadoTest); 

		Assert.assertEquals("Falla en setCandidato, candidato no agregado", empleadoTest, empleadorTest.getCandidato());
	}
	
	
	@Test
	public void TestListaDePostulantes() {
		ArrayList<ClientePuntaje> listaPostulantesTest = new ArrayList<ClientePuntaje>();
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "salud", "fisica");
		empleadorTest.setListaDePostulantes(listaPostulantesTest);
		Assert.assertEquals("La lista de postulantes no se seteo correctamente", listaPostulantesTest, empleadorTest.getListaDePostulantes());
		
	}

}
