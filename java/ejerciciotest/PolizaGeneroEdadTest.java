package ejerciciotest;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolizaGeneroEdadTest {

	@Test
	public void testCalculaPolizaEdadGeneroRango20_25() {
		double resultado;
		PolizaGeneroEdad polizaGeneroEdad= new PolizaGeneroEdad();
		resultado= polizaGeneroEdad.calcularPoliza("F", 21);		
		assertEquals(18000.00, resultado,0);
							
	}
	
	@Test
	public void testCalculaPolizaEdadGeneroRango26_30() {
		double resultado;
		PolizaGeneroEdad polizaGeneroEdad= new PolizaGeneroEdad();
		resultado= polizaGeneroEdad.calcularPoliza("F", 27);
		assertEquals(23000.00, resultado,0);
							
	}
	
	@Test
	public void testCalculaPolizaEdadGeneroRango31_35() {
		double resultado;
		PolizaGeneroEdad polizaGeneroEdad= new PolizaGeneroEdad();
		resultado= polizaGeneroEdad.calcularPoliza("F", 32);
		assertEquals(28000.00, resultado,0);
							
	}
	
	@Test
	public void testCalculaPolizaEdadGeneroRangoMascu31_35() {
		double resultado;
		PolizaGeneroEdad polizaGeneroEdad= new PolizaGeneroEdad();
		resultado= polizaGeneroEdad.calcularPoliza("M", 32);
		assertEquals(30000.00, resultado,0);
							
	}
	
	@Test
	public void testCalculaPolizaEdadGeneroRangoMascu26_30() {
		double resultado;
		PolizaGeneroEdad polizaGeneroEdad= new PolizaGeneroEdad();
		resultado= polizaGeneroEdad.calcularPoliza("M", 27);
		assertEquals(25000.00, resultado,0);
							
	}

	@Test
	public void testCalculaPolizaEdadGeneroRangoMascu20_25() {
		double resultado;
		PolizaGeneroEdad polizaGeneroEdad= new PolizaGeneroEdad();
		resultado= polizaGeneroEdad.calcularPoliza("M", 25);
		assertEquals(20000.00, resultado,0);
							
	}
	
}
