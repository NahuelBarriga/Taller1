package TestPersistencia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import persistencia.AgenciaDTO;
import persistencia.UtilPersistencia;

public class TestPersistenciaAgenciaDTO {
	
	UtilPersistencia testDePersistencia;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAgenciaDTOFromAgencia() throws Exception {
		try {
			AgenciaDTO agdto;
			EmpleadoPretenso testPretenso = new EmpleadoPretenso ("Maite","que123","Maiten","35762334","Pratt",25);
			HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
			testComisiones.put(testPretenso, 0.9);
			HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
			HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
			ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
			Agencia.getInstance().setComisionesUsuarios(testComisiones);
			Agencia.getInstance().setContrataciones(testContrataciones);
			Agencia.getInstance().setEmpleadores(testEmpleadores);
			Agencia.getInstance().setEmpleados(testEmpleadosPretensos);
			Agencia.getInstance().setEstadoContratacion(false);
			Agencia.getInstance().setLimitesRemuneracion(1000,2000);
			agdto= UtilPersistencia.AgenciaDtoFromAgencia();
			assertEquals("No coincide comisiones", agdto.getComisionesUsuarios(),Agencia.getInstance().getComisionesUsuarios());
			assertEquals("No coincide contrataciones", agdto.getContrataciones(),Agencia.getInstance().getContrataciones());
			assertEquals("No coincide empleadores", agdto.getEmpleadores(),Agencia.getInstance().getEmpleadores());
			assertEquals("No coincide empleados", agdto.getEmpleados(),Agencia.getInstance().getEmpleados());
			assertTrue("No coincide estado de contratacion", agdto.isEstadoContratacion()==Agencia.getInstance().isEstadoContratacion());
			assertTrue("No coincide limite inferior", agdto.getLimiteInferior()==Agencia.getInstance().getLimiteInferior());
			assertTrue("No coincide limite superior", agdto.getLimiteSuperior()==Agencia.getInstance().getLimiteSuperior());   
		} catch (Exception e){
			fail ("No deberia lanzar excepcion");
		}
		
	}
	
	@Test
	public void testAgenciaFromAgenciaDTO() throws Exception {
	   try {	
		AgenciaDTO agenciaDTO = new AgenciaDTO();
		EmpleadoPretenso testPretenso = new EmpleadoPretenso ("Maite","que123","Maiten","35762334","Pratt",25);
		HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
		testComisiones.put(testPretenso, 0.9);
		HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
		HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
		ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
		agenciaDTO.setComisionesUsuarios(testComisiones);
		agenciaDTO.setContrataciones(testContrataciones);
		agenciaDTO.setEmpleadores(testEmpleadores);
		agenciaDTO.setEmpleados(testEmpleadosPretensos);
		agenciaDTO.setEstadoContratacion(false);
		agenciaDTO.setLimiteInferior(1000);
		agenciaDTO.setLimiteSuperior(2000);
		UtilPersistencia.agenciaFromAgenciaDTO(agenciaDTO);
		assertEquals("No coincide comisiones", agenciaDTO.getComisionesUsuarios(),Agencia.getInstance().getComisionesUsuarios());
		assertEquals("No coincide contrataciones", agenciaDTO.getContrataciones(),Agencia.getInstance().getContrataciones());
		assertEquals("No coincide empleadores", agenciaDTO.getEmpleadores(),Agencia.getInstance().getEmpleadores());
		assertEquals("No coincide empleados", agenciaDTO.getEmpleados(),Agencia.getInstance().getEmpleados());
		assertTrue("No coincide estado de contratacion", agenciaDTO.isEstadoContratacion()==Agencia.getInstance().isEstadoContratacion());
		assertTrue("No coincide limite inferior", agenciaDTO.getLimiteInferior()==Agencia.getInstance().getLimiteInferior());
		assertTrue("No coincide limite superior", agenciaDTO.getLimiteSuperior()==Agencia.getInstance().getLimiteSuperior());   
	   }
	   catch (Exception e) {
		   fail("No deberia arrojar una excepcion");
	   }
	}
}
