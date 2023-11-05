package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		
		//Falta crear los hash con los empeados y empleadores
	}
	
	@Test
	public void testAplicaPromo1() {
		UtilPromo utilPromoTest = new UtilPromo();
		utilPromoTest.aplicaPromo();
	}

}
