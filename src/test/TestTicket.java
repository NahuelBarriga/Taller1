package test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.Ticket;

public class TestTicket {

	@Test
	public void TestConstructor1() {
		Ticket testTicket = new Ticket("HOME_OFFICE", 1200, "JORNADA_COMPLETA", "JUNIOR", "EXP_NADA", "PRIMARIOS"); 
		String locacionTest = "HOME_OFFICE";
		int remuneracionTest = 1200;
		String jornadaTest = "JORNADA_COMPLETA";
		String puestoTest = "JUNIOR"; 
		String experienciaTest = "EXP_NADA"; 
		String estudiosTest = "PRIMARIOS";
		
		Assert.assertEquals(locacionTest, testTicket.getLocacion());
		Assert.assertEquals(remuneracionTest, testTicket.getRemuneracion());
		Assert.assertEquals(jornadaTest, testTicket.getJornada());
		Assert.assertEquals(puestoTest, testTicket.getPuesto());
		Assert.assertEquals(experienciaTest, testTicket.getExperiencia());
		Assert.assertEquals(estudiosTest, testTicket.getEstudios());
		
	}
	
	@Test
	public void TestConstructor2() {
		Ticket testTicket = new Ticket("PRESENCIAL", 20000, "JORNADA_MEDIA", "SENIOR", "EXP_MEDIA", "SECUNDARIOS"); 
		String locacionTest = "PRESENCIAL";
		int remuneracionTest = 20000;
		String jornadaTest = "JORNADA_MEDIA";
		String puestoTest = "SENIOR"; 
		String experienciaTest = "EXP_MEDIA"; 
		String estudiosTest = "SECUNDARIOS";
		
		Assert.assertEquals(locacionTest, testTicket.getLocacion());
		Assert.assertEquals(remuneracionTest, testTicket.getRemuneracion());
		Assert.assertEquals(jornadaTest, testTicket.getJornada());
		Assert.assertEquals(puestoTest, testTicket.getPuesto());
		Assert.assertEquals(experienciaTest, testTicket.getExperiencia());
		Assert.assertEquals(estudiosTest, testTicket.getEstudios());
		
	}
	
	@Test
	public void TestConstructor3() {
		Ticket testTicket = new Ticket("PRESENCIAL", 58000, "JORNADA_EXTENDIDA", "GERENCIA", "EXP_MUCHA", "TERCIARIOS"); 
		String locacionTest = "PRESENCIAL";
		int remuneracionTest = 58000;
		String jornadaTest = "JORNADA_EXTENDIDA";
		String puestoTest = "GERENCIA"; 
		String experienciaTest = "EXP_MUCHA"; 
		String estudiosTest = "TERCIARIOS";
		
		Assert.assertEquals(locacionTest, testTicket.getLocacion());
		Assert.assertEquals(remuneracionTest, testTicket.getRemuneracion());
		Assert.assertEquals(jornadaTest, testTicket.getJornada());
		Assert.assertEquals(puestoTest, testTicket.getPuesto());
		Assert.assertEquals(experienciaTest, testTicket.getExperiencia());
		Assert.assertEquals(estudiosTest, testTicket.getEstudios());
		
	}

	@Test
	public void testSetRemuneracion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionLocacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionJornada() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionPuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionEstudios() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionExperiencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionRemuneracion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionTotal() {
		fail("Not yet implemented");
	}

}
