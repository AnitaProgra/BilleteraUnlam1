package src.Billetera;

public class CVUInvalidoException extends Exception {

	protected String mensaje;

	public CVUInvalidoException(String mensaje) {
		super(mensaje);
	} 
	
}
