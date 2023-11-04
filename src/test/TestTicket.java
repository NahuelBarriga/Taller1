package test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.Ticket;

public class TestTicket {

	@Test
	public void TestConstructor1() {
		 
		String locacionTest = util.Constantes.HOME_OFFICE;
		int remuneracionTest = 1200;
		String jornadaTest = util.Constantes.JORNADA_COMPLETA;
		String puestoTest = util.Constantes.JUNIOR; 
		String experienciaTest = util.Constantes.EXP_NADA; 
		String estudiosTest = util.Constantes.PRIMARIOS;		
		Ticket testTicket = new Ticket(locacionTest, 1200, jornadaTest, puestoTest, experienciaTest, estudiosTest);
		
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket.getLocacion());
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket.getRemuneracion());
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket.getJornada());
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket.getPuesto());
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket.getExperiencia());
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket.getEstudios());
		
	}
	
	@Test
	public void TestConstructor2() {
		String locacionTest = util.Constantes.PRESENCIAL;
		int remuneracionTest = 1200;
		String jornadaTest = util.Constantes.JORNADA_MEDIA;
		String puestoTest = util.Constantes.SENIOR; 
		String experienciaTest = util.Constantes.EXP_MEDIA; 
		String estudiosTest = util.Constantes.SECUNDARIOS;		
		Ticket testTicket = new Ticket(locacionTest, 1200, jornadaTest, puestoTest, experienciaTest, estudiosTest);
		
		Assert.assertEquals(locacionTest, testTicket.getLocacion());
		Assert.assertEquals(remuneracionTest, testTicket.getRemuneracion());
		Assert.assertEquals(jornadaTest, testTicket.getJornada());
		Assert.assertEquals(puestoTest, testTicket.getPuesto());
		Assert.assertEquals(experienciaTest, testTicket.getExperiencia());
		Assert.assertEquals(estudiosTest, testTicket.getEstudios());
		
	}
	
	@Test
	public void TestConstructor3() {
		String locacionTest = util.Constantes.PRESENCIAL;
		int remuneracionTest = 1200;
		String jornadaTest = util.Constantes.JORNADA_EXTENDIDA;
		String puestoTest = util.Constantes.MANAGMENT; 
		String experienciaTest = util.Constantes.EXP_MUCHA; 
		String estudiosTest = util.Constantes.TERCIARIOS;		
		Ticket testTicket = new Ticket(locacionTest, 1200, jornadaTest, puestoTest, experienciaTest, estudiosTest);
		
		Assert.assertEquals(locacionTest, testTicket.getLocacion());
		Assert.assertEquals(remuneracionTest, testTicket.getRemuneracion());
		Assert.assertEquals(jornadaTest, testTicket.getJornada());
		Assert.assertEquals(puestoTest, testTicket.getPuesto());
		Assert.assertEquals(experienciaTest, testTicket.getExperiencia());
		Assert.assertEquals(estudiosTest, testTicket.getEstudios());
		
	}

	@Test
	public void testSetRemuneracion() {
		Ticket testTicket = new Ticket(util.Constantes.HOME_OFFICE, 1200, util.Constantes.HOME_OFFICE, util.Constantes.JUNIOR, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS);
		testTicket.setRemuneracion(5200);
		int remuneracionTest = 5200; 
		Assert.assertEquals("No se seteo la remuneracion correctamente", remuneracionTest, testTicket.getRemuneracion());
		
		
	}

	@Test
	//asumo que esta mal la forma en lo que lo hice pq si fuese asi y tengo un error no tengo idea de donde carajo salio
	public void testGetComparacionLocacion() {
		Ticket testTicketPresencial= new Ticket("PRESENCIAL", 1200, "JORNADA_COMPLETA", "JUNIOR", "EXP_NADA", "PRIMARIOS"); 
		Ticket testTicketHomeOffice = new Ticket("HOME_OFFICE", 1200, "JORNADA_COMPLETA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketIndiferente = new Ticket("INDIFERENTE", 1200, "JORNADA_COMPLETA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		double ResultadoLocacionTest1 = 1;
		double ResultadoLocacionTest2 = -1;
		double resultado;
		//Escenario 1, this.ticket.locacion == PRESENCIAL: 
		resultado = testTicketPresencial.getComparacionLocacion(testTicketPresencial);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0); 
		resultado = testTicketPresencial.getComparacionLocacion(testTicketHomeOffice);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0); 
		resultado = testTicketPresencial.getComparacionLocacion(testTicketIndiferente);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0); 
		
		/*//Escenario 2, this.ticket.locacion == HOME_OFFICE:
		
		resultado = testTicketHomeOffice.getComparacionLocacion(testTicketPresencial);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0);
		resultado = testTicketHomeOffice.getComparacionLocacion(testTicketHomeOffice);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
		resultado = testTicketHomeOffice.getComparacionLocacion(testTicketIndiferente);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
		
		//Escenario 3, this.ticket.locacion == INDIFERENTE:
		resultado = testTicketIndiferente.getComparacionLocacion(testTicketPresencial);
		Assert.assertEquals(ResultadoLocacionTest2, resultado, 0);
		resultado = testTicketIndiferente.getComparacionLocacion(testTicketHomeOffice);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);
		resultado = testTicketIndiferente.getComparacionLocacion(testTicketIndiferente);
		Assert.assertEquals(ResultadoLocacionTest1, resultado, 0);*/
	}

	@Test
	public void testGetComparacionJornada() {
		Ticket testTicketJornadaMedia= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketJornadaCompleta= new Ticket("PRESENCIAL", 1200, "JORNADA_COMPLETA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketJornadaExtendida= new Ticket("PRESENCIAL", 1200, "JORNADA_EXTENDIDA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultado;
		//Escenario 1: (this.jornada== JORNADA_"MEDIA")				
		resultado = testTicketJornadaMedia.getComparacionJornada(testTicketJornadaMedia);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketJornadaMedia.getComparacionJornada(testTicketJornadaCompleta);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicketJornadaMedia.getComparacionJornada(testTicketJornadaExtendida);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		
		//Escenario 2: (this.jornada== JORNADA_"COMPLETA")				
		resultado = testTicketJornadaCompleta.getComparacionJornada(testTicketJornadaMedia);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicketJornadaCompleta.getComparacionJornada(testTicketJornadaCompleta);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketJornadaCompleta.getComparacionJornada(testTicketJornadaExtendida);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		
		//Escenario 3: (this.jornada== JORNADA_"EXTENDIDA")				
		resultado = testTicketJornadaExtendida.getComparacionJornada(testTicketJornadaMedia);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		resultado = testTicketJornadaExtendida.getComparacionJornada(testTicketJornadaCompleta);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketJornadaExtendida.getComparacionJornada(testTicketJornadaExtendida);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionPuesto() {
		Ticket testTicketJunior= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketSenior= new Ticket("PRESENCIAL", 1200, "JORNADA_COMPLETA", "SENIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketManagment= new Ticket("PRESENCIAL", 1200, "JORNADA_EXTENDIDA", "MANAGMENT", "EXP_NADA", "PRIMARIOS");
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultado;
		
		//Escenario 1: (this.puesto== "JUNIOR")
		resultado = testTicketJunior.getComparacionPuesto(testTicketJunior);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketJunior.getComparacionPuesto(testTicketSenior);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicketJunior.getComparacionPuesto(testTicketManagment);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		
		//Escenario 2: (this.puesto== "SENIOR")
		resultado = testTicketSenior.getComparacionPuesto(testTicketJunior);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicketSenior.getComparacionPuesto(testTicketSenior);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketSenior.getComparacionPuesto(testTicketManagment);
		Assert.assertEquals(resultado, resultadoTest3, 0);
	
		//Escenario 3: (this.puesto== "MANAGMENT")			
		resultado = testTicketManagment.getComparacionPuesto(testTicketJunior);
		Assert.assertEquals(resultado, resultadoTest2, 0);
		resultado = testTicketManagment.getComparacionPuesto(testTicketSenior);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketManagment.getComparacionPuesto(testTicketManagment);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionEstudios() {
		Ticket testTicketPrimarios= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketSecundarios= new Ticket("PRESENCIAL", 1200, "JORNADA_COMPLETA", "SENIOR", "EXP_NADA", "SECUNDARIOS");
		Ticket testTicketTerciarios= new Ticket("PRESENCIAL", 1200, "JORNADA_EXTENDIDA", "MANAGMENT", "EXP_NADA", "TERCIARIOS");
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultadoTest4 = -2;
		double resultadoTest5 = 1.5;
		double resultadoTest6 = -1.5;
		double resultadoTest7 = 2;
		double resultado;
		
		//Escenario 1: (this.puesto== "PRIMARIO")	
		resultado = testTicketPrimarios.getComparacionEstudios(testTicketPrimarios);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketPrimarios.getComparacionEstudios(testTicketSecundarios);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicketPrimarios.getComparacionEstudios(testTicketTerciarios);
		Assert.assertEquals(resultado, resultadoTest4, 0);
		
		//Escenario 2: (this.puesto== "SECUNDARIO")
		resultado = testTicketSecundarios.getComparacionEstudios(testTicketPrimarios);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		resultado = testTicketSecundarios.getComparacionEstudios(testTicketSecundarios);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketSecundarios.getComparacionEstudios(testTicketTerciarios);
		Assert.assertEquals(resultado, resultadoTest6, 0);
		
		//Escenario 3: (this.puesto== "TERCIARIO")		
		resultado = testTicketTerciarios.getComparacionEstudios(testTicketPrimarios);
		Assert.assertEquals(resultado, resultadoTest7, 0);
		resultado = testTicketTerciarios.getComparacionEstudios(testTicketSecundarios);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		resultado = testTicketTerciarios.getComparacionEstudios(testTicketTerciarios);
		Assert.assertEquals(resultado, resultadoTest1, 0);
	}

	@Test
	public void testGetComparacionExperiencia() {
		Ticket testTicketExpNada= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketExpMedia= new Ticket("PRESENCIAL", 1200, "JORNADA_COMPLETA", "SENIOR", "EXP_MEDIA", "SECUNDARIOS");
		Ticket testTicketExpMucha= new Ticket("PRESENCIAL", 1200, "JORNADA_EXTENDIDA", "MANAGMENT", "EXP_MUCHA", "TERCIARIOS");
		double resultadoTest1 = 1;
		double resultadoTest2 = -1;
		double resultadoTest3 = -0.5;
		double resultadoTest4 = -2;
		double resultadoTest5 = 1.5;
		double resultadoTest6 = -1.5;
		double resultadoTest7 = 2;
		double resultado;
		
		//Escenario 1: (this.experiencia== "NADA")
		resultado = testTicketExpNada.getComparacionExperiencia(testTicketExpNada);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketExpNada.getComparacionExperiencia(testTicketExpMedia);
		Assert.assertEquals(resultado, resultadoTest3, 0);
		resultado = testTicketExpNada.getComparacionExperiencia(testTicketExpMucha);
		Assert.assertEquals(resultado, resultadoTest4, 0);
		//Escenario 2: (this.experiencia== "MEDIA")
		resultado = testTicketExpMedia.getComparacionExperiencia(testTicketExpNada);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		resultado = testTicketExpMedia.getComparacionExperiencia(testTicketExpMedia);
		Assert.assertEquals(resultado, resultadoTest1, 0);
		resultado = testTicketExpMedia.getComparacionExperiencia(testTicketExpMucha);
		Assert.assertEquals(resultado, resultadoTest6, 0);
		
		//Escenario 3: (this.experiencia== "MUCHA")			
		resultado = testTicketExpMucha.getComparacionExperiencia(testTicketExpNada);
		Assert.assertEquals(resultado, resultadoTest7, 0);
		resultado = testTicketExpMucha.getComparacionExperiencia(testTicketExpMedia);
		Assert.assertEquals(resultado, resultadoTest5, 0);
		resultado = testTicketExpMucha.getComparacionExperiencia(testTicketExpMucha);
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
		Ticket testTicketTotal1= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		Ticket testTicketTotal2= new Ticket("PRESENCIAL", 1200, "JORNADA_MEDIA", "JUNIOR", "EXP_NADA", "PRIMARIOS");
		double resultadoEsperado = 6;
		double resultado = testTicketTotal1.getComparacionTotal(testTicketTotal2);
		Assert.assertEquals(resultado, resultadoEsperado, 0);

	}

}
