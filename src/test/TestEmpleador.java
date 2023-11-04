package test;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;

public class TestEmpleador {

	@Test
	public void  testEmpleador1() {
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "salud", "fisica");
		String empleadoNombreTest =  "Juan123";
		String empleadoPasswordTest =  "Juan123";
		String empleadoRealNameTest =  "Juan";
		String empleadoTelefonoTest =  "2235698547";
		String empleadoRubroTest =  "salud";
		String empleadoTipoPersonaTest =  "fisica";
		Assert.assertNotNull("Falla en constructor, constructor nulo",empleadorTest);
		Assert.assertEquals("Falla en constructor, parametro: UsserName", empleadoNombreTest,empleadorTest.getUsserName());
		Assert.assertEquals("Falla en constructor, parametro: Password", empleadoPasswordTest,empleadorTest.getPassword());
		Assert.assertEquals("Falla en constructor, parametro: RealName",empleadoRealNameTest,empleadorTest.getRealName());
		Assert.assertEquals("Falla en constructor, parametro: Telefono", empleadoTelefonoTest,empleadorTest.getTelefono());
		Assert.assertEquals("Falla en constructor, parametro: Rubro", empleadoRubroTest,empleadorTest.getRubro());
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", empleadoTipoPersonaTest, empleadorTest.getTipoPersona());
		
	}
	
	@Test
	public void  testEmpleador2() {
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "comercio_internacional", "juridica");
		String empleadoNombreTest =  "Juan123";
		String empleadoPasswordTest =  "Juan123";
		String empleadoRealNameTest =  "Juan";
		String empleadoTelefonoTest =  "2235698547";
		String empleadoRubroTest =  "comercio_internacional";
		String empleadoTipoPersonaTest =  "juridica";
		Assert.assertNotNull("Falla en constructor, constructor nulo",empleadorTest);
		Assert.assertEquals("Falla en constructor, parametro: UsserName", empleadoNombreTest,empleadorTest.getUsserName());
		Assert.assertEquals("Falla en constructor, parametro: Password", empleadoPasswordTest,empleadorTest.getPassword());
		Assert.assertEquals("Falla en constructor, parametro: RealName",empleadoRealNameTest,empleadorTest.getRealName());
		Assert.assertEquals("Falla en constructor, parametro: Telefono", empleadoTelefonoTest,empleadorTest.getTelefono());
		Assert.assertEquals("Falla en constructor, parametro: Rubro", empleadoRubroTest,empleadorTest.getRubro());
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", empleadoTipoPersonaTest, empleadorTest.getTipoPersona());
		
	}
	
	@Test
	public void  testEmpleador3() {
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "comercio_local", "fisica");
		String empleadoNombreTest =  "Juan123";
		String empleadoPasswordTest =  "Juan123";
		String empleadoRealNameTest =  "Juan";
		String empleadoTelefonoTest =  "2235698547";
		String empleadoRubroTest =  "comercio_local";
		String empleadoTipoPersonaTest =  "fisica";
		Assert.assertNotNull("Falla en constructor, constructor nulo",empleadorTest);
		Assert.assertEquals("Falla en constructor, parametro: UsserName", empleadoNombreTest,empleadorTest.getUsserName());
		Assert.assertEquals("Falla en constructor, parametro: Password", empleadoPasswordTest,empleadorTest.getPassword());
		Assert.assertEquals("Falla en constructor, parametro: RealName",empleadoRealNameTest,empleadorTest.getRealName());
		Assert.assertEquals("Falla en constructor, parametro: Telefono", empleadoTelefonoTest,empleadorTest.getTelefono());
		Assert.assertEquals("Falla en constructor, parametro: Rubro", empleadoRubroTest,empleadorTest.getRubro());
		Assert.assertEquals("Falla en constructor, parametro: TipoPersona", empleadoTipoPersonaTest, empleadorTest.getTipoPersona());
		
	}
	
	@Test
	public void testCalculaComision() {
		Empleador empleadorSaludTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "salud", "fisica");
		Empleador empleadorInternacionalTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "comercio_internacional", "fisica");
		Empleador empleadorLocalTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "comercio_local", "fisica");
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
		Empleador empleadorTest = new Empleador("Juan123", "Juan123", "Juan", "2235698547", "salud", "fisica");
		EmpleadoPretenso empleadoTest = new EmpleadoPretenso("Marcos123", "Marcos123", "Marcos", "2235698456", "Rodriguez", 25);
		empleadorTest.setCandidato(empleadoTest); 

		Assert.assertEquals("Falla en setCandidato, candidato no agregado", empleadoTest, empleadorTest.getCandidato());
	}
	
	

}
