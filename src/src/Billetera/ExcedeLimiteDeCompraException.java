package src.Billetera;

public class ExcedeLimiteDeCompraException extends Exception{

	protected String mensaje;

	public ExcedeLimiteDeCompraException(String mensaje) {
		super(mensaje);
	} 
	
}
