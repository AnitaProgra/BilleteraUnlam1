package src.Billetera;

import java.time.LocalDate;

public interface Acciones {



	String verMisCompras(LocalDate fecha) throws NoTieneComprasEnEsaFechaException; 
	
}
