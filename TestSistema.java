package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ComensalesInsuficientesException;
import excepciones.ContraseniaIncorrectaException;
import excepciones.HijosNegativosException;
import excepciones.MenorDeDieciochoException;
import excepciones.MesaNoAsignadaException;
import excepciones.MesaNoExistenteException;
import excepciones.MesaOcupadaException;
import excepciones.MesaYaExistenteException;
import excepciones.MozoDuplicadoException;
import excepciones.NegativoException;
import excepciones.NoHayDosPromosException;
import excepciones.NoHayMozosException;
import excepciones.NoHayProductosException;
import excepciones.NoHayPromoException;
import excepciones.PrecioVentaMenorCostoException;
import excepciones.ProductoDuplicadoException;
import excepciones.UsuarioIncorrectoException;
import main.Factura;
import main.Mesa;
import main.Mozo;
import main.Operario;
import main.Producto;
import main.PromocionPermanente;
import main.Sistema;

public class TestSistema {
	Sistema sistema;
	
	@Before
	public void setUp() throws Exception {
		this.sistema= Sistema.getInstancia();
		System.out.println(this.sistema.getMesas().size());

	}

	@After
	public void tearDown() throws Exception {
		this.sistema.setMesas(new ArrayList<Mesa>());
	}

	
	@Test
	public void testLoginAdminExitoso() {
		Operario admin=null;
		try {
			admin=this.sistema.loginAdmin("ADMIN", "ADMIN1234");
		} catch (ContraseniaIncorrectaException  e) {
			fail("No deberia lanzar contraseniaIncorectaException()" );
		}catch (UsuarioIncorrectoException e) {
			fail("No deberia lanzar UsuarioIncorrectoException()" );
		}
		assertEquals("No se logeo correctamente", sistema.getAdmin(), admin);
	}
	@Test
	public void testLoginAdminContraseniaIncorrecta() {
		Operario admin=null;
		try {
			admin=this.sistema.loginAdmin("ADMIN", "ADMIN124");
		} catch (ContraseniaIncorrectaException  e) {
			
		}catch (UsuarioIncorrectoException e) {
			fail("No deberia lanzar UsuarioIncorrectoException()" );
		}
		
		assertNotEquals("No deberia legearse correctamente", sistema.getAdmin(), admin);
		
	}
	
	@Test
	public void testLoginAdminUsuarioIncorrecto() {
		Operario admin=null;
		try {
			admin=this.sistema.loginAdmin("ADMINN", "ADMIN1234");
		} catch (ContraseniaIncorrectaException  e) {
			fail("No deberia lanzar ContraseniaIncorrectaException()" );
		}catch (UsuarioIncorrectoException e) {
			
		}
		
		assertNotEquals("No deberia legearse correctamente", sistema.getAdmin(), admin);
		}
	
	@Test
	public void testSetFacturas() {
		Factura factura=new Factura(null,null,null,null,50,null);
		ArrayList<Factura> nuevaFacturas=new ArrayList<Factura>();
		nuevaFacturas.add(factura);
		this.sistema.setFacturas(nuevaFacturas);
		assertEquals("Las facturas no se setean correctamente", nuevaFacturas, this.sistema.getFacturas());
	}
	
	@Test
	public void testSetPromosFijas() throws NoHayPromoException, NegativoException {
		PromocionPermanente promo=new PromocionPermanente(true,null,null,true,true,5,5);
		ArrayList<PromocionPermanente> nuevaPromosPer=new ArrayList<PromocionPermanente>();
		nuevaPromosPer.add(promo);
		this.sistema.setPromosFijas(nuevaPromosPer);
		assertEquals("Las promos permanentes no se setean correctamente", nuevaPromosPer, this.sistema.getPromosFijas());
	}
	
	//TEST OCUPAMESA(INT NUMEROMESA,INT CANTIDADCOMENSALES)
	
	/**
	 * Test metodo ocupaMesa(int numeroMesa,int cantComensales)
	 * Escenario lista mesas en sistema vacia o numeroMesa no coincide con
	 * ninguna mesa en sistema
	 * */
	@Test
	public void camino1() {
		try {
			this.sistema.ocupaMesa(0, 0);
		} catch (MesaNoExistenteException e) {
			
		} catch (ComensalesInsuficientesException e) {
			fail("No debe lanzar ComensalesInsuficientesException()");
		} catch (MesaOcupadaException e) {
			fail("No debe lanzar MesaOcupadaException()");
		} catch (NoHayProductosException e) {
			fail("No debe lanzar NoHayProductosException()");
		} catch (MesaNoAsignadaException e) {
			fail("No debe lanzar MesaNoAsignadaException()");
		} catch (NoHayMozosException e) {
			fail("No debe lanzar NoHayMozosException()");
		} catch (NoHayDosPromosException e) {
			fail("No debe lanzar NoHayDosPromosException()");
		}
		
	}
	
	@Test
	public void camino2() {
		try {
			try {
				this.sistema.agregaMesa(0, 0);
			} catch (MesaYaExistenteException e) {
				fail("No debe lanzar MesaYaExistenteException()");
			}
			this.sistema.ocupaMesa(1, 0);
		} catch (MesaNoExistenteException e) {
			
		} catch (ComensalesInsuficientesException e) {
			fail("No debe lanzar ComensalesInsuficientesException()");
		} catch (MesaOcupadaException e) {
			fail("No debe lanzar MesaOcupadaException()");
		} catch (NoHayProductosException e) {
			fail("No debe lanzar NoHayProductosException()");
		} catch (MesaNoAsignadaException e) {
			fail("No debe lanzar MesaNoAsignadaException()");
		} catch (NoHayMozosException e) {
			fail("No debe lanzar NoHayMozosException()");
		} catch (NoHayDosPromosException e) {
			fail("No debe lanzar NoHayDosPromosException()");
		}
		
	}
	
	/**
	 * Test metodo ocupaMesa(int numeroMesa,int cantComensales)
	 * Escenario lista mesas en sistema con elementos, y parametro numeroMesa igual a 
	 * el numero de mesa de las del sistema y las mesas con estado distinto a libre.
	 */
	@Test
	public void camino3() {
		try {
			this.sistema.agregaMesa(0, 0);
			this.sistema.getMesas().get(0).setEstado("");
			try {
				this.sistema.ocupaMesa(0, 0);
			} catch (MesaNoExistenteException e) {
				fail("No debe lanzar MesaNoExistenteException" );
			} catch (ComensalesInsuficientesException e) {
				fail("No debe lanzar ComensalesInsuficientesException" );
			} catch (MesaOcupadaException e) {
				
			} catch (NoHayProductosException e) {
				fail("No debe lanzar NoHayProductosException" );
			} catch (MesaNoAsignadaException e) {
				fail("No debe lanzar MesaNoAsignadaException" );
			} catch (NoHayMozosException e) {
				fail("No debe lanzar NoHayMozosException" );
			} catch (NoHayDosPromosException e) {
				fail("No debe lanzar NoHayDosPromosException" );
			}
		} catch (MesaYaExistenteException e) {
			fail("No debe lanzar MesaYaExistenteException" );
		}
	}
	
	
	/**
	 * Test metodo ocupaMesa(int numeroMesa,int cantComensales)
	 * Escenario lista mesas en sistema con elementos, y parametro numeroMesa igual a 
	 * el numero de mesa de una del sistema y estado libre.
	 * */
	@Test
	public void camino4() {
		try {
			this.sistema.agregaMesa(0, 0);
			try {
				this.sistema.ocupaMesa(0, 5);
			} catch (MesaNoExistenteException e) {
				fail("No debe lanzar MesaNoExistenteException()");
			} catch (ComensalesInsuficientesException e) {
				
			} catch (MesaOcupadaException e) {
				fail("No debe lanzar MesaOcupadaException()");
			} catch (NoHayProductosException e) {
				fail("No debe lanzar NoHayProductosException()");
			} catch (MesaNoAsignadaException e) {
				fail("No debe lanzar MesaNoAsignadaException()");
			} catch (NoHayMozosException e) {
				fail("No debe lanzar NoHayMozosException()");
			} catch (NoHayDosPromosException e) {
				fail("No debe lanzar NoHayDosPromosException()");
			}
		} catch (MesaYaExistenteException e) {
			fail("No debe lanzar MesaYaExistenteException" );
		}
		
	}
	
	/**
	 * Test metodo ocupaMesa(int numeroMesa,int cantComensales)
	 * Escenario lista mesas en sistema con elementos, y parametro numeroMesa igual a 
	 * el numero de mesa de una del sistema con estado libre, con mozo en sistema, con un mozo 
	 * ue tenga asignada la mesa y ue haya dos promos activas en sistema
	 */
	
	@Test
	public void camino5() {
		try {
			this.sistema.agregaMesa(0, 2);
			//this.sistema.agregaMesa(1, 3);
			try {
				try {
					this.sistema.agregaProductos(new Producto("hola",50,100,20));
					this.sistema.agregaProductos(new Producto("chau",50,100,20));
					try {
						this.sistema.agregaMozo(new Mozo("Activo",0,"nombre", LocalDate.of(1998,04,04)));
						this.sistema.getMozos().get(0).agregarMesa(this.sistema.getMesas().get(0));
						try {
							this.sistema.getPromosFijas().add(new PromocionPermanente(true,null,this.sistema.getProducto().get(0),false,true,5,5));
							this.sistema.getPromosFijas().add(new PromocionPermanente(true,null,this.sistema.getProducto().get(1),true,false,5,5));
						} catch (NoHayPromoException e1) {
							fail("No debe lanzar NoHayPromoException");
						}
						
						try {
							this.sistema.ocupaMesa(0, 2);
						} catch (MesaNoExistenteException e) {
							fail("No debe lanzar MesaNoExistenteException");
						} catch (ComensalesInsuficientesException e) {
							fail("No debe lanzar ComensalesInsuficientesException");
						} catch (MesaOcupadaException e) {
							fail("No debe lanzar MesaOcupadaException");
						} catch (NoHayProductosException e) {
							fail("No debe lanzar NoHayProductosException");
						} catch (MesaNoAsignadaException e) {
							fail("No debe lanzar MesaNoAsignadaException");
						} catch (NoHayMozosException e) {
							fail("No debe lanzar NoHayMozosException");
						} catch (NoHayDosPromosException e) {
							fail("No debe lanzar NoHayDosPromosException");
						}
					} catch (MozoDuplicadoException e) {
						fail("No debe lanzar MozoDuplicadoException");
					} catch (HijosNegativosException e) {
						fail("No debe lanzar HijosNegativosException");
					} catch (MenorDeDieciochoException e) {
						fail("No debe lanzar MenorDeDieciochoException");
					}
				} catch (NegativoException e) {
					fail("No debe lanzar NegativoException" );
				} catch (PrecioVentaMenorCostoException e) {
					fail("No debe lanzar PrecioVentaMenorCostoException" );
				}
			} catch (ProductoDuplicadoException e1) {
				fail("No debe lanzar ProductoDuplicadoException" );
			}
			
		} catch (MesaYaExistenteException e) {
			fail("No debe lanzar MesaYaExistenteException" );
		}
		
	}
	/*@Test
	public void camino5() {
		try {
			this.sistema.agregaMesa(3, 2);
			try {
				this.sistema.ocupaMesa(3, 4);
			} catch (MesaNoExistenteException e) {
				fail("No debe lanzar MesaNoExistenteException");
			} catch (ComensalesInsuficientesException e) {
				
			} catch (MesaOcupadaException e) {
				fail("No debe lanzar MesaOcupadaException");
			} catch (NoHayProductosException e) {
				fail("No debe lanzar NoHayProductosException");
			} catch (MesaNoAsignadaException e) {
				fail("No debe lanzar MesaNoAsignadaException");
			} catch (NoHayMozosException e) {
				fail("No debe lanzar NoHayMozosException");
			} catch (NoHayDosPromosException e) {
				fail("No debe lanzar NoHayDosPromosException");
			}
		} catch (MesaYaExistenteException e) {
			fail("No debe lanzar MesaYaExistenteException" );
		}
		
	}*/
	

}
