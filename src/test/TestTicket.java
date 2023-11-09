package test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.Ticket;



public class TestTicket {
	
	Ticket testTicket1= new Ticket(util.Constantes.PRESENCIAL, 1200, util.Constantes.JORNADA_MEDIA, util.Constantes.JUNIOR, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS); 
	Ticket testTicket2 = new Ticket(util.Constantes.HOME_OFFICE, 1200, util.Constantes.JORNADA_COMPLETA, util.Constantes.SENIOR, util.Constantes.EXP_MEDIA, util.Constantes.SECUNDARIOS);
	Ticket testTicket3 = new Ticket(util.Constantes.INDISTINTO, 1200, util.Constantes.JORNADA_EXTENDIDA, util.Constantes.MANAGMENT, util.Constantes.EXP_MUCHA, util.Constantes.TERCIARIOS);

	@Test
	public void TestConstructor1() {
		 
		String locacionTest = util.Constantes.PRESENCIAL;
		int remuneracionTest = 1200;
		String jornadaTest = util.Constantes.JORNADA_MEDIA;
		String puestoTest = util.Constantes.JUNIOR; 
		String experienciaTest = util.Constantes.EXP_NADA; 
		String estudiosTest = util.Constantes.PRIMARIOS;		
		
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket1.getLocacion());
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket1.getRemuneracion());
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket1.getJornada());
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket1.getPuesto());
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket1.getExperiencia());
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket1.getEstudios());
		
	}
	
	@Test
	public void TestConstructor2() {
		String locacionTest = util.Constantes.HOME_OFFICE;
		int remuneracionTest = 1200;
		String jornadaTest = util.Constantes.JORNADA_COMPLETA;
		String puestoTest = util.Constantes.SENIOR; 
		String experienciaTest = util.Constantes.EXP_MEDIA; 
		String estudiosTest = util.Constantes.SECUNDARIOS;		
		
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket2.getLocacion());
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket2.getRemuneracion());
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket2.getJornada());
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket2.getPuesto());
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket2.getExperiencia());
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket2.getEstudios());
		
	}
	
	@Test
	public void TestConstructor3() {
		String locacionTest = util.Constantes.INDISTINTO;
		int remuneracionTest = 1200;
		String jornadaTest = util.Constantes.JORNADA_EXTENDIDA;
		String puestoTest = util.Constantes.MANAGMENT; 
		String experienciaTest = util.Constantes.EXP_MUCHA; 
		String estudiosTest = util.Constantes.TERCIARIOS;		

		
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket3.getLocacion());
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket3.getRemuneracion());
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket3.getJornada());
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket3.getPuesto());
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket3.getExperiencia());
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket3.getEstudios());
		
	}

	@Test
	public void testSetRemuneracion() {
		Ticket testTicket = new Ticket(util.Constantes.HOME_OFFICE, 1200, util.Constantes.HOME_OFFICE, util.Constantes.JUNIOR, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS);
		testTicket.setRemuneracion(5200);
		int remuneracionTest = 5200; 
		Assert.assertEquals("No se seteo la remuneracion correctamente", remuneracionTest, testTicket.getRemuneracion());
		
		
	}

	@Test
	public void testGetComparacionLocacion() {
		
		double ResultadoLocacionTest1 = 1;
		double ResultadoLocacionTest2 = -1;
		double resultado;
		//Escenario 1, this.ticket.locacion == PRESENCIAL: 
		resultado = testTicket1.getComparacionLocacion(testTicket1);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0); 
		resultado = testTicket1.getComparacionLocacion(testTicket2);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0); 
		resultado = testTicket1.getComparacionLocacion(testTicket3);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0); 
		
		//Escenario 2, this.ticket.locacion == HOME_OFFICE:
		resultado = testTicket2.getComparacionLocacion(testTicket1);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0);
		resultado = testTicket2.getComparacionLocacion(testTicket2);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
		resultado = testTicket2.getComparacionLocacion(testTicket3);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
		
		//Escenario 3, this.ticket.locacion == INDIFERENTE:
		resultado = testTicket3.getComparacionLocacion(testTicket1);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0);
		resultado = testTicket3.getComparacionLocacion(testTicket2);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
		resultado = testTicket3.getComparacionLocacion(testTicket3);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
	}

	@Test
	public void testGetComparacionJornada() {
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultado;
		//Escenario 1: (this.jornada== JORNADA_"MEDIA")				
		resultado = testTicket1.getComparacionJornada(testTicket1);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket1.getComparacionJornada(testTicket2);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicket1.getComparacionJornada(testTicket3);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		
		//Escenario 2: (this.jornada== JORNADA_"COMPLETA")				
		resultado = testTicket2.getComparacionJornada(testTicket1);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicket2.getComparacionJornada(testTicket2);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket2.getComparacionJornada(testTicket3);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		
		//Escenario 3: (this.jornada== JORNADA_"EXTENDIDA")				
		resultado = testTicket3.getComparacionJornada(testTicket1);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		resultado = testTicket3.getComparacionJornada(testTicket2);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket3.getComparacionJornada(testTicket3);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionPuesto() {
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultado;
		
		//Escenario 1: (this.puesto== "JUNIOR")
		resultado = testTicket1.getComparacionPuesto(testTicket1);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket1.getComparacionPuesto(testTicket2);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicket1.getComparacionPuesto(testTicket3);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		
		//Escenario 2: (this.puesto== "SENIOR")
		resultado = testTicket2.getComparacionPuesto(testTicket1);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicket2.getComparacionPuesto(testTicket2);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket2.getComparacionPuesto(testTicket3);
		Assert.assertEquals(resultado, resultadoTest3, 0);
	
		//Escenario 3: (this.puesto== "MANAGMENT")			
		resultado = testTicket3.getComparacionPuesto(testTicket1);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		resultado = testTicket3.getComparacionPuesto(testTicket2);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket3.getComparacionPuesto(testTicket3);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionEstudios() {
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultadoTest4 = -2;
		double resultadoTest5 = 1.5;
		double resultadoTest6 = -1.5;
		double resultadoTest7 = 2;
		double resultado;
		
		//Escenario 1: (this.puesto== "PRIMARIO")	
		resultado = testTicket1.getComparacionEstudios(testTicket1);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket1.getComparacionEstudios(testTicket2);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		resultado = testTicket1.getComparacionEstudios(testTicket3);
		Assert.assertEquals(resultado, resultadoTest7, 0);
		
		//Escenario 2: (this.puesto== "SECUNDARIO")
		resultado = testTicket2.getComparacionEstudios(testTicket1);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicket2.getComparacionEstudios(testTicket2);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket2.getComparacionEstudios(testTicket3);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		
		//Escenario 3: (this.puesto== "TERCIARIO")		
		resultado = testTicket3.getComparacionEstudios(testTicket1);
		Assert.assertEquals(resultado, resultadoTest4, 0);
		resultado = testTicket3.getComparacionEstudios(testTicket2);
		Assert.assertEquals(resultado, resultadoTest6, 0);
		resultado = testTicket3.getComparacionEstudios(testTicket3);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionExperiencia() {
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultadoTest4 = -2;
		double resultadoTest5 = 1.5;
		double resultadoTest6 = -1.5;
		double resultadoTest7 = 2;
		double resultado;
		
		//Escenario 1: (this.experiencia== "NADA")
		resultado = testTicket1.getComparacionExperiencia(testTicket1);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket1.getComparacionExperiencia(testTicket2);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		resultado = testTicket1.getComparacionExperiencia(testTicket3);
		Assert.assertEquals(resultado, resultadoTest7, 0);
		
		//Escenario 2: (this.experiencia== "MEDIA")
		resultado = testTicket2.getComparacionExperiencia(testTicket1);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicket2.getComparacionExperiencia(testTicket2);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicket2.getComparacionExperiencia(testTicket3);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		
		//Escenario 3: (this.experiencia== "MUCHA")			
		resultado = testTicket3.getComparacionExperiencia(testTicket1);
		Assert.assertEquals(resultado, resultadoTest4, 0);
		resultado = testTicket3.getComparacionExperiencia(testTicket2);
		Assert.assertEquals(resultado, resultadoTest6, 0);
		resultado = testTicket3.getComparacionExperiencia(testTicket3);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionRemuneracion() {
		/*Ticket testTicketr= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketExpMedia= new Ticket("PRESENCIAL", 1200, "JORNADA_COMPLETA", "SENIOR", "EXP_MEDIA", "SECUNDARIOS");
		Ticket testTicketExpMucha= new Ticket("PRESENCIAL", 1200, "JORNADA_EXTENDIDA", "MANAGMENT", "EXP_MUCHA", "TERCIARIOS");
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultadoTest4 = -2;
		double resultadoTest5 = 1.5;
		double resultadoTest6 = -1.5;
		double resultadoTest7 = 2;
		double resultado;*/
		fail("Not yet implemented");
	}

	@Test
	public void testGetComparacionTotal() {
		/*Ticket testTicketTotal1= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketTotal2= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		double resultadoEsperado = 6;
		double resultado = testTicketTotal1.getComparacionTotal(testTicketTotal2);
		Assert.assertEquals(resultado, resultadoEsperado, 0);*/
		fail("Not yet implemented");
	}

}
