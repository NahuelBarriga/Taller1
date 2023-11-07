package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import promo.UtilPromo;

public class TestUtilPromo {

	@Before 
	public void setUp(){
		boolean promoPorListaDePostulantesTrue = true;
		boolean promoPorListaDePostulantesFalse = false;
		EmpleadoPretenso empleado1 = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		EmpleadoPretenso empleado2 = new EmpleadoPretenso("Marcos123", "Marcos123", "Marcos", "2235956575", "Gutierrez", 56);
		empleado1.setPuntaje(1);
		empleado2.setPuntaje(4);
		Empleador empleador1 = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.SALUD, util.Constantes.FISICA);
		Empleador empleador2 = new Empleador("Juan123", "Juan123", "Juan", "2235698547", util.Constantes.COMERCIO_INTERNACIONAL, util.Constantes.JURIDICA);
		ClientePuntaje puntajeTest1 = new ClientePuntaje(3.4, empleado1);
		ClientePuntaje puntajeTest2 = new ClientePuntaje(4.2, empleador1);
		ArrayList<ClientePuntaje> lista1 = new ArrayList<ClientePuntaje>(); 
		ArrayList<ClientePuntaje> lista2 = new ArrayList<ClientePuntaje>();
		lista1.add(puntajeTest1);
		lista2.add(puntajeTest2);
		empleador2.setListaDePostulantes(lista1);
		empleado2.setListaDePostulantes(lista2);
		HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
		HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
		
	}
	
	@Test
	public void testAplicaPromo1() {
		UtilPromo utilPromoTest = new UtilPromo();
		utilPromoTest.aplicaPromo(false, empleados, empleadores); //empleadores y empleados vacios 
	}
	@Test
	public void testAplicaPromo2() {
		UtilPromo utilPromoTest = new UtilPromo();
		utilPromoTest.aplicaPromo(true, empleados, empleadores); //empleadores y empleados vacios 
	}
	@Test
	public void testAplicaPromo3() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleadores.put(null, empleador1);	
		utilPromoTest.aplicaPromo(true, empleados, empleadores); //empleados vacio, empleadores con empleador 1 cargado 
	}
	@Test
	public void testAplicaPromo4() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleadores.put(null, empleador2);	
		utilPromoTest.aplicaPromo(true, empleados, empleadores); //empleados vacio, empleadores con empleador 1 cargado 
	}
	@Test
	public void testAplicaPromo5() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleados.put(null, empleado1);	
		utilPromoTest.aplicaPromo(true, empleados, empleadores); //empleadores vacio, empleados con empleado 1 cargado 
	}
	@Test
	public void testAplicaPromo6() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleados.put(null, empleado2);	
		utilPromoTest.aplicaPromo(true, empleados, empleadores); //empleadores vacio, empleados con empleado 2 cargado 
	}
	@Test
	public void testAplicaPromo7() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleadores.put(null, empleador1);	
		utilPromoTest.aplicaPromo(false, empleados, empleadores); //empleados vacio, empleadores con empleador 2 cargado 
	}
	@Test
	public void testAplicaPromo8() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleados.put(null, empleado1);	
		utilPromoTest.aplicaPromo(false, empleados, empleadores); //empleadores vacio, empleados con empleado 1 cargado  
	}
	@Test
	public void testAplicaPromo9() {
		UtilPromo utilPromoTest = new UtilPromo();
		empleados.put(null, empleado2);	
		utilPromoTest.aplicaPromo(false, empleados, empleadores); //empleadores vacio, empleados con empleado 1 cargado 
	}
	
}
