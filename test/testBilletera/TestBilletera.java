package testBilletera;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import src.Billetera.CBUInvalidoException;
import src.Billetera.CUITInvalidoException;
import src.Billetera.CVUInvalidoException;
import src.Billetera.Comercio;
import src.Billetera.Compra;
import src.Billetera.Consumidor;
import src.Billetera.Entidades;
import src.Billetera.ExcedeLimiteDeCompraException;
import src.Billetera.MisMediosDePagos;
import src.Billetera.NoCoincideTitularException;
import src.Billetera.NoTieneComprasEnEsaFechaException;
import src.Billetera.NumeroDeTarjetaInvalidoException;
import src.Billetera.SaldoInsuficienteException;
import src.Billetera.TiposDeMediosDePagos;

public class TestBilletera {

	@Test
	public void testQueSePuedaRegistrarUnComercio() throws CUITInvalidoException{
	
		Entidades zara = new Comercio("Zara", 001, "30765745740", 1234); 
		
		assertTrue(((Comercio)zara).verificarQueElComercioSeHayaCreadoCorrectamente()); 
		
		
	}

	@Test
	public void testQueSePuedaRegistrarUnConsumidor() throws NumeroDeTarjetaInvalidoException{
	
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO, ((Consumidor)consumidor1), "1627789000987678"); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO, ((Consumidor)consumidor1), "162533334");
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		assertTrue(((Consumidor)consumidor1).verificarQueElConsumidorSeHayaCreadoCorrectamente()); 
		
		
	}
	
	
	@Test
	public void testQueSePuedaRegistrarUnConsumidorConsuCBUcorrecto() throws CBUInvalidoException{
	
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO, ((Consumidor)consumidor1), "1627789000987678", "0", "31231231112223334567"); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO, ((Consumidor)consumidor1), "162533334", "0", "312312311122233567");
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		assertFalse(((Consumidor)consumidor1).verificarQueElCBUseHayaRegistradoCorrectamente()); 
		
		
	}
	
	
	@Test
	public void testQueSePuedaRegistrarUnConsumidorConsuCVUcorrecto() throws CVUInvalidoException{
	
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO, ((Consumidor)consumidor1), "1627789000987678", "0", "31231231112223334567"); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO, ((Consumidor)consumidor1), "162533334", "0", "31231231112223356700000");
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		assertFalse(((Consumidor)consumidor1).verificarQueElCVUseHayaRegistradoCorrectamente()); 
		
		
	}
	
	@Test
	public void testQueElConsumidorSeaElTitularDeLosMediosDePago() throws NoCoincideTitularException{
	
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan diaz", ((Consumidor)consumidor1)); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan perez", ((Consumidor)consumidor1));
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		assertTrue(((Consumidor)consumidor1).verificarQueElTitularDelMedioDePagoSeaCorrecto(tarjetaVisa)); 
		
		
	}
	
	@Test
	public void testQueLaCompraNoSePuedaRealizarSiHaySaldoInsuficiente() throws SaldoInsuficienteException{
	
		Entidades comercio1 = new Comercio("Zara", 001, "30765745740", 1234); 
		
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan diaz", ((Consumidor)consumidor1), 200.0, 0.0); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan perez", ((Consumidor)consumidor1), 0.0, 300.0);
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		
		Compra compra01 = new Compra(LocalDate.of(2023,06,27), 001, ((Comercio)comercio1) ,((Consumidor)consumidor1), 199.0, true); 
		
		assertTrue(compra01.queLaCompraNoExcedaElSaldoDeLaTarjeta(compra01, tarjetaVisa)); 
		
		
	}
	
	
	@Test
	public void testQueLaCompraNoSePuedaRealizarSiSuperaElLimite() throws ExcedeLimiteDeCompraException{
	
		Entidades comercio1 = new Comercio("Zara", 001, "30765745740", 1234); 
		
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan diaz", ((Consumidor)consumidor1), 200.0, 0.0); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan perez", ((Consumidor)consumidor1), 0.0, 200.0);
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		
		Compra compra01 = new Compra(LocalDate.of(2023,06,27), 001, ((Comercio)comercio1) ,((Consumidor)consumidor1), 299.0, true); 
		
		assertFalse(compra01.queLaCompraNoExcedaElLimiteDeLaTarjeta(compra01, tarjetaMastercard)); 
		
		
	}
	
	@Test
	public void testQuePuedaVisualizarMisCompras() throws NoTieneComprasEnEsaFechaException{
	
		Entidades comercio1 = new Comercio("Zara", 001, "30765745740", 1234); 
		
		Entidades consumidor1 = new Consumidor("juan diaz", 001, 002, 02034444000, 2034444000); 
		
		MisMediosDePagos tarjetaVisa = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan diaz", ((Consumidor)consumidor1), 200.0, 0.0); 		
		MisMediosDePagos tarjetaMastercard = new MisMediosDePagos(TiposDeMediosDePagos.TARJETA_CREDITO,"juan perez", ((Consumidor)consumidor1), 0.0, 200.0);
		
		
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaVisa);
		((Consumidor)consumidor1).agregarMisTarjetas(tarjetaMastercard);
		
		
		Compra compra01 = new Compra(LocalDate.of(2023,06,27), 001, ((Comercio)comercio1) ,((Consumidor)consumidor1), 299.0, true);
		Compra compra02 = new Compra(LocalDate.of(2023,06,28), 002, ((Comercio)comercio1) ,((Consumidor)consumidor1), 299.0, true);
		Compra compra03 = new Compra(LocalDate.of(2023,06,29), 003, ((Comercio)comercio1) ,((Consumidor)consumidor1), 299.0, true);
		
		((Consumidor)consumidor1).guardarMisCompras(compra01);
		((Consumidor)consumidor1).guardarMisCompras(compra02);
		((Consumidor)consumidor1).guardarMisCompras(compra03);
		
		String esperado = "Las compras el dia seleccionado fueron la nro: 1 con un monto de: 299.0";
		
		assertEquals(esperado, ((Consumidor)consumidor1).verMisCompras(LocalDate.of(2023, 06, 27)));
		
		
	}
	
	
	
	
}
