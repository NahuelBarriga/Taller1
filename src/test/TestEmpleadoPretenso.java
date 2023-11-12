package test;



import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;



public class TestEmpleadoPretenso {
	EmpleadoPretenso empleado;
	
	@Before
	public void setUp() {
		this.empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25); 
	}
	
	@Test
	public void testEmpleadoPretensoApellido() {		
		Assert.assertEquals("Fallo en constructor, parametro apellido","Rodriguez",this.empleado.getApellido());
	}
	
	@Test
	public void testEmpleadoPretensoEdad() {
		Assert.assertEquals("Fallo en constructor, parametro edad", 25, this.empleado.getEdad());
	}
	
	@Test
	public void testSetEdad() {		
		int nuevaEdad = 26;
		this.empleado.setEdad(nuevaEdad);
		
		Assert.assertEquals("La edad no se seteo correctamente", nuevaEdad, empleado.getEdad());
	}
	
	@Test
	public void testSetCandidato() {
		Empleador candidato = new Empleador("Juan123","Juan123","Juan123","2235698547","SALUD","COMERCIO_INTERNACIONAL");
		
		empleado.setCandidato(candidato);
		Assert.assertEquals("El candidato no se seteo correctamnete", candidato, this.empleado.getCandidato());
		
	}
	
	@Test
	public void testSetListaDePostulantes() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235698547", "Rodriguez", 25);
		ArrayList<ClientePuntaje> listaDePostulantes = new ArrayList<ClientePuntaje>();		
		
		empleado.setListaDePostulantes(listaDePostulantes);
		Assert.assertEquals("La lista de postulantes no se seteo correctamente", listaDePostulantes, empleado.getListaDePostulantes());

	}

	//--------------TEST DE INTEGRACION--------------
	@Test
	public void testCalculaComision() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123", "Juan123", "Juan",
				"2235698547", "Rodriguez", 25);
		Ticket ticket= new Ticket(util.Constantes.PRESENCIAL, 1200, util.Constantes.JORNADA_MEDIA,
				util.Constantes.JUNIOR, util.Constantes.EXP_NADA, util.Constantes.PRIMARIOS); 
		double comision;
		
		empleado.setTicket(ticket);	
		empleado.setPuntaje(20);
		comision = empleado.calculaComision(ticket);
		Assert.assertEquals("Fallo en el calculo de comision", 720, comision,0.1);
				
	}
}
