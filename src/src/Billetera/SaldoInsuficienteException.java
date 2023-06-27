package src.Billetera;

public class SaldoInsuficienteException  extends Exception{
	protected String mensaje;

	public SaldoInsuficienteException(String mensaje) {
		super(mensaje);
	} 
	
	

}
