package src.Billetera;

public class NoCoincideTitularException extends Exception {

	protected String mensaje;

	public NoCoincideTitularException(String mensaje) {
		super(mensaje);
	}
	
	
}
