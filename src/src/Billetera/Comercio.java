package src.Billetera;

import java.time.LocalDate;
import java.util.Objects;

public class Comercio extends Entidades {

	protected String cuit; 
	protected Integer nroDeComercio; 
	protected boolean QRgenerado; 

	public Comercio(String nombre, Integer nroUsuario, String cuit, Integer nroDeComercio) {
		super(nombre, nroUsuario);
	    this.cuit=  cuit; 
		this.nroDeComercio= nroDeComercio; 
	}

	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre= nombre; 
		
	}

	@Override
	public Integer getNroUsuario() {
	return nroUsuario;
	}

	@Override
	public void setNroUsuario(Integer nroUsuario) {
	this.nroUsuario= nroUsuario; 
	}

	
	
	public boolean getQRgenerado() {
		return QRgenerado;
	}

	public void setQRgenerado(boolean qRgenerado) {
		QRgenerado = qRgenerado;
	}

	
	public boolean verificarQueElComercioSeHayaCreadoCorrectamente() throws CUITInvalidoException{
		try {
			if(getCuit().length()==11 && getCuit().startsWith("30")) {
				return true; 
			}
			else {throw new CUITInvalidoException ("el cuit debe comenzar con 30 y tener 11 digitos ");}
		}
		catch(CUITInvalidoException e) {
			System.out.println(e.getMessage());
			return false; 
		}
	}
	
	
	
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Integer getNroDeComercio() {
		return nroDeComercio;
	}

	public void setNroDeComercio(Integer nroDeComercio) {
		this.nroDeComercio = nroDeComercio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nroDeComercio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comercio other = (Comercio) obj;
		return Objects.equals(nroDeComercio, other.nroDeComercio);
	}	
	
	
	
	
}
