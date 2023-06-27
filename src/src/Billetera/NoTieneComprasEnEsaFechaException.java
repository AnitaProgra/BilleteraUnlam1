package src.Billetera;

public class NoTieneComprasEnEsaFechaException extends Exception {

	protected String mensaje;

	public NoTieneComprasEnEsaFechaException(String mensaje) {
		super(mensaje); 
	} 
	
	
}
