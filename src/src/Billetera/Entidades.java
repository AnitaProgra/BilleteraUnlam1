package src.Billetera;

import java.util.HashSet;
import java.util.Objects;

public abstract class Entidades {


	protected String nombre;
	protected Integer nroUsuario;
	protected HashSet<Compra> misTransacciones; 
	
	public Entidades(String nombre, Integer nroUsuario) {
		this.nombre = nombre;
		this.nroUsuario = nroUsuario;
		this.misTransacciones= new HashSet<>(); 
	}


	
	
	public abstract String getNombre(); 

	public abstract void setNombre(String nombre); 

	public abstract Integer getNroUsuario();


	public abstract void setNroUsuario(Integer nroUsuario); 


	@Override
	public int hashCode() {
		return Objects.hash(nroUsuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidades other = (Entidades) obj;
		return Objects.equals(nroUsuario, other.nroUsuario);
	}  
	

	
	
	
}
