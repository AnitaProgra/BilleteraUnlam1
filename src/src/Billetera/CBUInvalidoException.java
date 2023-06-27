package src.Billetera;

public class CBUInvalidoException extends Exception{

	protected String mensaje;

	public CBUInvalidoException(String mensaje) {
		super(mensaje);
	} 
	

}
