package test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;



public class TestEmpleadoPretenso {
	
	@Test
	public void testEmpleadoPretenso() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		int Edad = empleado.getEdad();
		Assert.assertEquals(Edad, 25);
		//Assert.assertNotNull("TaBien", empleadoTest);
	}

	@Test
	public void testSetEdad() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		int nuevaEdad = 26;
		
		Assert.assertEquals("La edad no se seteo correctamente", nuevaEdad, empleado.getEdad());
	}
	
	@Test
	public void testSetCandidato() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		Empleador candidato = new Empleador("Juan123","Juan123","Juan123","2235698547","SALUD","COMERCIO_INTERNACIONAL");
		
		empleado.setCandidato(candidato);
		Assert.assertEquals("El candidato no se seteo correctamnete", candidato, empleado.getCandidato());
		
	}
	
	@Test
	public void testSetListaDePostulantes() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		ArrayList<ClientePuntaje> listaDePostulantes = new ArrayList<ClientePuntaje>();
		
		empleado.setListaDePostulantes(listaDePostulantes);
		Assert.assertEquals("La lista de postulantes no se seteo correctamente", listaDePostulantes, empleado.getListaDePostulantes());

	}

}
