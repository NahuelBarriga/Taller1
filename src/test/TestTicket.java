package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;



public class TestTicket {
	
	private Ticket testTicket1;
	private Ticket testTicket2;
	private Ticket testTicket3;	
	private Agencia agencia;
	
	
	@Before
	public void setUp() {
		this.agencia = Agencia.getInstance();
		try {
			this.agencia.setLimitesRemuneracion(1000, 30000);
		} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			e.printStackTrace();
		}
		this.testTicket1 = new Ticket(util.Constantes.PRESENCIAL, 800, util.Constantes.JORNADA_MEDIA,
				util.Constantes.JUNIOR, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS);
		this.testTicket2 = new Ticket(util.Constantes.HOME_OFFICE, 1200, util.Constantes.JORNADA_COMPLETA,
				util.Constantes.SENIOR, util.Constantes.EXP_MEDIA, util.Constantes.SECUNDARIOS);
		this.testTicket3 = new Ticket(util.Constantes.INDISTINTO, 4000, util.Constantes.JORNADA_EXTENDIDA,
				util.Constantes.MANAGMENT, util.Constantes.EXP_MUCHA, util.Constantes.TERCIARIOS);
			
	}
	
	
	@Test
	public void TestConstructorLocacion1() {
		String locacionTest = util.Constantes.PRESENCIAL;
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket1.getLocacion());
		
	}
	
	@Test
	public void TestConstructorRemuneracion1() {
		int remuneracionTest = 800;
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket1.getRemuneracion());
	}
	
	@Test
	public void TestConstructorJornada1() {
		String jornadaTest = util.Constantes.JORNADA_MEDIA;
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket1.getJornada());
	}
	
	@Test
	public void TestConstructorPuesto1() {
		String puestoTest = util.Constantes.JUNIOR; 
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket1.getPuesto());
	}
	@Test
	public void TestConstructorExperiencia1() {
		String experienciaTest = util.Constantes.EXP_NADA; 
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket1.getExperiencia());
	}
	@Test
	public void TestConstructorEstudios1() {
		String estudiosTest = util.Constantes.PRIMARIOS;	
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket1.getEstudios());	
	}
	
	@Test
	public void TestConstructorLocacion2() {
		String locacionTest = util.Constantes.HOME_OFFICE;
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket2.getLocacion());	
	}
	
	@Test
	public void TestConstructorRemuneracion2() {
		int remuneracionTest = 1200;
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket2.getRemuneracion());
	}
	
	@Test
	public void TestConstructorJornada2() {
		String jornadaTest = util.Constantes.JORNADA_COMPLETA;
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket2.getJornada());
	}
	
	@Test
	public void TestConstructorPuesto2() {
		String puestoTest = util.Constantes.SENIOR; 
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket2.getPuesto());
	}
	@Test
	public void TestConstructorExperiencia2() {
		String experienciaTest = util.Constantes.EXP_MEDIA; 
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket2.getExperiencia());
	}
	@Test
	public void TestConstructorEstudios2() {
		String estudiosTest = util.Constantes.SECUNDARIOS;	
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket2.getEstudios());	
	}
	
	@Test
	public void TestConstructorLocacion3() {
		String locacionTest = util.Constantes.INDISTINTO;
		Assert.assertEquals("Fallo en constructor, parametro locacion",locacionTest, testTicket3.getLocacion());
	}
	
	@Test
	public void TestConstructorRemuneracion3() {
		int remuneracionTest = 4000;
		Assert.assertEquals("Fallo en constructor, parametro remuneracion",remuneracionTest, testTicket3.getRemuneracion());
	}
	
	@Test
	public void TestConstructorJornada3() {
		String jornadaTest = util.Constantes.JORNADA_EXTENDIDA;
		Assert.assertEquals("Fallo en constructor, parametro jornada",jornadaTest, testTicket3.getJornada());
	}
	
	@Test
	public void TestConstructorPuesto3() {
		String puestoTest = util.Constantes.MANAGMENT; 
		Assert.assertEquals("Fallo en constructor, parametro puesto",puestoTest, testTicket3.getPuesto());
	}
	@Test
	public void TestConstructorExperiencia3() {
		String experienciaTest = util.Constantes.EXP_MUCHA; 
		Assert.assertEquals("Fallo en constructor, parametro experiencia",experienciaTest, testTicket3.getExperiencia());
	}
	@Test
	public void TestConstructorEstudios3() {
		String estudiosTest = util.Constantes.TERCIARIOS;	
		Assert.assertEquals("Fallo en constructor, parametro estudios",estudiosTest, testTicket3.getEstudios());
	}
	
	@Test
	public void testSetRemuneracion() {
		Ticket testTicket = new Ticket(util.Constantes.HOME_OFFICE, 1200, util.Constantes.HOME_OFFICE,
				util.Constantes.JUNIOR, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS);
		testTicket.setRemuneracion(5200);
		int remuneracionTest = 5200; 
		Assert.assertEquals("No se seteo la remuneracion correctamente", remuneracionTest, testTicket.getRemuneracion());	
	}
	
	
	//Escenario 1, this.ticket.locacion == PRESENCIAL: 
	@Test
	public void testGetComparacionLocacionT1T1() {
		double resultado = testTicket1.getComparacionLocacion(testTicket1);
		Assert.assertEquals(resultado,1, 0);
	}	
	
	public void testGetComparacionLocacionT1T2() {
		double resultado = testTicket1.getComparacionLocacion(testTicket2);
		Assert.assertEquals(resultado,-1, 0);
	}
	
	public void testGetComparacionLocacionT1T3() {
		double resultado = testTicket1.getComparacionLocacion(testTicket3);
		Assert.assertEquals(resultado,-1, 0);
	}	
	//Escenario 2, this.ticket.locacion == HOME_OFFICE:
	@Test
	public void testGetComparacionLocacionT2T1() {
		double resultado = testTicket2.getComparacionLocacion(testTicket1);
		Assert.assertEquals(resultado,-1, 0);
	}	
	
	public void testGetComparacionLocacionT2T2() {
		double resultado = testTicket2.getComparacionLocacion(testTicket2);
		Assert.assertEquals(resultado,1, 0);
	}
	
	public void testGetComparacionLocacionT2T3() {
		double resultado = testTicket2.getComparacionLocacion(testTicket3);
		Assert.assertEquals(resultado,1, 0);
	}	
	//Escenario 3, this.ticket.locacion == INDIFERENTE:
	@Test
	public void testGetComparacionLocacionT3T1() {
		double resultado = testTicket3.getComparacionLocacion(testTicket1);
		Assert.assertEquals(resultado,-1, 0);
	}	
	
	public void testGetComparacionLocacionT3T2() {
		double resultado = testTicket3.getComparacionLocacion(testTicket2);
		Assert.assertEquals(resultado,1, 0);
	}
	
	public void testGetComparacionLocacionT3T3() {
		double resultado = testTicket3.getComparacionLocacion(testTicket3);
		Assert.assertEquals(resultado,1, 0);
	}	
	
	//Escenario 1: (this.jornada== JORNADA_"MEDIA")	
	@Test
	public void testGetComparacionJornadaT1T1() {
		double resultado = testTicket1.getComparacionJornada(testTicket1);
		Assert.assertEquals(resultado, 1, 0);	
	}
	@Test
	public void testGetComparacionJornadaT1T2() {
		double resultado = testTicket1.getComparacionJornada(testTicket2);
		Assert.assertEquals(resultado, -0.5, 0);	
	}
	@Test
	public void testGetComparacionJornadaT1T3() {
		double resultado = testTicket1.getComparacionJornada(testTicket3);
		Assert.assertEquals(resultado, -1, 0);	
	}	
	//Escenario 2: (this.jornada== JORNADA_"COMPLETA")
	@Test
	public void testGetComparacionJornadaT2T1() {
		double resultado = testTicket2.getComparacionJornada(testTicket1);
		Assert.assertEquals(resultado, -0.5, 0);	
	}
	@Test
	public void testGetComparacionJornadaT2T2() {
		double resultado = testTicket2.getComparacionJornada(testTicket2);
		Assert.assertEquals(resultado, 1, 0);	
	}
	@Test
	public void testGetComparacionJornadaT2T3() {
		double resultado = testTicket2.getComparacionJornada(testTicket3);
		Assert.assertEquals(resultado, -0.5, 0);	
	}
	//Escenario 3: (this.jornada== JORNADA_"EXTENDIDA")
	@Test
	public void testGetComparacionJornadaT3T1() {
		double resultado = testTicket3.getComparacionJornada(testTicket1);
		Assert.assertEquals(resultado, -1, 0);	
	}
	@Test
	public void testGetComparacionJornadaT3T2() {
		double resultado = testTicket3.getComparacionJornada(testTicket2);
		Assert.assertEquals(resultado, 1, 0);	
	}
	
	@Test
	public void testGetComparacionJornadaT3T3() {
		double resultado = testTicket3.getComparacionJornada(testTicket3);
		Assert.assertEquals(resultado, 1, 0);	
	}
	
	//Escenario 1: (this.puesto== "JUNIOR")
	@Test
	public void testGetComparacionPuestoT1T1() {
		double resultado  = testTicket1.getComparacionPuesto(testTicket1);
		Assert.assertEquals(resultado, 1, 0);
	}	
	@Test
	public void testGetComparacionPuestoT1T2() {
		double resultado  = testTicket1.getComparacionPuesto(testTicket2);
		Assert.assertEquals(resultado, -0.5, 0);
	}		
	@Test
	public void testGetComparacionPuestoT1T3() {
		double resultado  = testTicket1.getComparacionPuesto(testTicket3);
		Assert.assertEquals(resultado, -1, 0);
	}
	//Escenario 2: (this.puesto== "SENIOR")
	@Test
	public void testGetComparacionPuestoT2T1() {
		double resultado  = testTicket2.getComparacionPuesto(testTicket1);
		Assert.assertEquals(resultado, -0.5, 0);
	}	
	@Test
	public void testGetComparacionPuestoT2T2() {
		double resultado  = testTicket2.getComparacionPuesto(testTicket2);
		Assert.assertEquals(resultado, 1, 0);
	}		
	@Test
	public void testGetComparacionPuestoT2T3() {
		double resultado  = testTicket2.getComparacionPuesto(testTicket3);
		Assert.assertEquals(resultado, -0.5, 0);
	}
	//Escenario 3: (this.puesto== "MANAGMENT")
	@Test
	public void testGetComparacionPuestoT3T1() {
		double resultado  = testTicket3.getComparacionPuesto(testTicket1);
		Assert.assertEquals(resultado, -1, 0);
	}	
	@Test
	public void testGetComparacionPuestoT3T2() {
		double resultado  = testTicket3.getComparacionPuesto(testTicket2);
		Assert.assertEquals(resultado, 1, 0);
	}		
	@Test
	public void testGetComparacionPuestoT3T3() {
		double resultado  = testTicket3.getComparacionPuesto(testTicket3);
		Assert.assertEquals(resultado, 1, 0);
	}
	
	//Escenario 1: (this.puesto== "PRIMARIO")	
	@Test
	public void testGetComparacionEstudiosT1T1() {
		double resultado = testTicket1.getComparacionEstudios(testTicket1);
		Assert.assertEquals(resultado, 1, 0);
	}	
	@Test
	public void testGetComparacionEstudiosT1T2() {
		double resultado = testTicket1.getComparacionEstudios(testTicket2);
		Assert.assertEquals(resultado, 1.5, 0);
	}
	@Test
	public void testGetComparacionEstudiosT1T3() {
		double resultado = testTicket1.getComparacionEstudios(testTicket3);
		Assert.assertEquals(resultado, 2, 0);
	}
	//Escenario 2: (this.puesto== "SECUNDARIO")
	@Test
	public void testGetComparacionEstudiosT2T1() {
		double resultado = testTicket2.getComparacionEstudios(testTicket1);
		Assert.assertEquals(resultado, -0.5, 0);
	}	
	@Test
	public void testGetComparacionEstudiosT2T2() {
		double resultado = testTicket2.getComparacionEstudios(testTicket2);
		Assert.assertEquals(resultado, 1, 0);
	}
	@Test
	public void testGetComparacionEstudiosT2T3() {
		double resultado = testTicket2.getComparacionEstudios(testTicket3);
		Assert.assertEquals(resultado, 1.5, 0);
	}
	//Escenario 3: (this.puesto== "TERCIARIO")
	@Test
	public void testGetComparacionEstudiosT3T1() {
		double resultado = testTicket3.getComparacionEstudios(testTicket1);
		Assert.assertEquals(resultado, -2, 0);
	}	
	@Test
	public void testGetComparacionEstudiosT3T2() {
		double resultado = testTicket3.getComparacionEstudios(testTicket2);
		Assert.assertEquals(resultado, -1.5, 0);
	}
	@Test
	public void testGetComparacionEstudiosT3T3() {
		double resultado = testTicket3.getComparacionEstudios(testTicket3);
		Assert.assertEquals(resultado, 1, 0);
	}

	//Escenario 1: (this.experiencia== "NADA") 
	@Test
	public void testGetComparacionExperienciaT1T1() {
		double resultado = testTicket1.getComparacionExperiencia(testTicket1);
		Assert.assertEquals(1, resultado, 0);
	}
	@Test
	public void testGetComparacionExperienciaT1T2() {
		double resultado = testTicket1.getComparacionExperiencia(testTicket2);
		Assert.assertEquals(1.5, resultado, 0);
	}
	@Test
	public void testGetComparacionExperienciaT1T3() {
		double resultado = testTicket1.getComparacionExperiencia(testTicket3);
		Assert.assertEquals(2, resultado, 0);
	}
	//Escenario 2: (this.experiencia== "MEDIA")
	@Test
	public void testGetComparacionExperienciaT2T1() {
		double resultado = testTicket2.getComparacionExperiencia(testTicket1);
		Assert.assertEquals(-0.5, resultado, 0);
	}
	@Test
	public void testGetComparacionExperienciaT2T2() {
		double resultado = testTicket2.getComparacionExperiencia(testTicket2);
		Assert.assertEquals(1, resultado, 0);
	}
	@Test
	public void testGetComparacionExperienciaT2T3() {
		double resultado = testTicket2.getComparacionExperiencia(testTicket3);
		Assert.assertEquals(1.5, resultado, 0);
	}
	//Escenario 3: (this.experiencia== "MUCHA")
	@Test
	public void testGetComparacionExperienciaT3T1() {
		double resultado = testTicket3.getComparacionExperiencia(testTicket1);
		Assert.assertEquals(-2, resultado, 0);
	}
	@Test
	public void testGetComparacionExperienciaT3T2() {
		double resultado = testTicket3.getComparacionExperiencia(testTicket2);
		Assert.assertEquals(-1.5, resultado, 0);
	}
	@Test
	public void testGetComparacionExperienciaT3T3() {
		double resultado = testTicket3.getComparacionExperiencia(testTicket3);
		Assert.assertEquals(1, resultado, 0);
	}

	//Escenario 1: (this.remuneracion < v1)
	@Test
	public void testGetComparacionRemuneracionT1T1() {
		double resultado = testTicket1.getComparacionRemuneracion(testTicket1);
		Assert.assertEquals(1, resultado, 0);
	}
	@Test
	public void testGetComparacionRemuneracionT1T2() {
		double resultado = testTicket1.getComparacionRemuneracion(testTicket2);
		Assert.assertEquals(-0.5, resultado, 0);
	} 		
	@Test
	public void testGetComparacionRemuneracionT1T3() {
		double resultado = testTicket1.getComparacionRemuneracion(testTicket3);
		Assert.assertEquals(-1, resultado, 0);
	} 		
	//Escenario 2: (this.remuneracion > v1 && this.remuneracion < v2)
	@Test
	public void testGetComparacionRemuneracionT2T1() {
		double resultado = testTicket2.getComparacionRemuneracion(testTicket1);
		Assert.assertEquals(1, resultado, 0);
	}
	@Test
	public void testGetComparacionRemuneracionT2T2() {
		double resultado = testTicket2.getComparacionRemuneracion(testTicket2);
		Assert.assertEquals(1, resultado, 0);
	} 		
	@Test
	public void testGetComparacionRemuneracionT2T3() {
		double resultado = testTicket2.getComparacionRemuneracion(testTicket3);
		Assert.assertEquals(-0.5, resultado, 0);
	} 	
	//Escenario 3: (this.remuneracion < v2)
	@Test
	public void testGetComparacionRemuneracionT3T1() {
		double resultado = testTicket3.getComparacionRemuneracion(testTicket1);
		Assert.assertEquals(1, resultado, 0);
	}
	@Test
	public void testGetComparacionRemuneracionT3T2() {
		double resultado = testTicket3.getComparacionRemuneracion(testTicket2);
		Assert.assertEquals(1, resultado, 0);
	} 		
	@Test
	public void testGetComparacionRemuneracionT3T3() {
		double resultado = testTicket3.getComparacionRemuneracion(testTicket3);
		Assert.assertEquals(1, resultado, 0);
	} 	

	@Test
	public void testGetComparacionTotal() {
		double resultadoEsperado = 6;
		double resultado = testTicket1.getComparacionTotal(testTicket1);
		Assert.assertEquals(resultadoEsperado, resultado,0);
		fail("Not yet implemented");
	}
	//corto aca pq sino muero

}


	
	
