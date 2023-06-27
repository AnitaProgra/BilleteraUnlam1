package src.Billetera;

public class NumeroDeTarjetaInvalidoException extends Exception{

	protected String mensaje;

	public NumeroDeTarjetaInvalidoException(String mensaje) {
		super(mensaje);
	} 
	
	
}
