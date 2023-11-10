package test;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class TestContratacion {

	@Test
	public void testContratacion() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Juan123","Juan123","Juan","2235698547","Rodriguez",25);
		Empleador empleador = new Empleador("Marcos123","Marcos123","Marcos","223566985",util.Constantes.SALUD,
				util.Constantes.FISICA);
		Contratacion contratacion = new Contratacion(empleador,empleado);
		Assert.assertEquals("Fallo en el constructor, parametro empleador", empleador, contratacion.getEmpleador());
		Assert.assertEquals("Fallo en el constructor, parametro empleado", empleado, contratacion.getEmpleado());
		Assert.assertNotNull("Fallo en el constructor, parametro fecha", contratacion.getFecha());
	}

}
