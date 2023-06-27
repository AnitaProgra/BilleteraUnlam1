package src.Billetera;

public class CUITInvalidoException extends Exception{

	protected String mensaje;

	public CUITInvalidoException(String mensaje) {
		super(mensaje);
	} 
	
	
}
