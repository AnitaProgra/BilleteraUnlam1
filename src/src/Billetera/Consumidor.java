package src.Billetera;

import java.time.LocalDate;
import java.util.HashSet;

public class Consumidor extends Entidades implements Acciones {
  
	
	protected Integer nroCliente; 
	protected long cuil; 
	protected long dni;
	protected HashSet <MisMediosDePagos> misTarjetas; 
	
	public Consumidor(String nombre, Integer nroUsuario,Integer nroCliente, long cuil, long dni) {
		super(nombre, nroUsuario);
		this.nroCliente=  nroCliente; 
		this.cuil= cuil; 
		this.dni= dni;
		this.misTarjetas= new HashSet<>(); 

	}

	public HashSet<MisMediosDePagos> getMisTarjetas() {
		return misTarjetas;
	}

	public void setMisTarjetas(HashSet<MisMediosDePagos> misTarjetas) {
		this.misTarjetas = misTarjetas;
	}

	
	public void agregarMisTarjetas(MisMediosDePagos tarjetas) {
		this.misTarjetas.add(tarjetas); 
	}
	
	public void guardarMisCompras(Compra compra) {
		this.misTransacciones.add(compra); 
	}
	
	@Override

	public String verMisCompras(LocalDate fecha) throws NoTieneComprasEnEsaFechaException {
	    for (Compra c : misTransacciones) {
	        if (c.getFechaCompra().equals(fecha)) {
	            return "Las compras el dia seleccionado "  +"fueron la nro: " + c.getNroCompra().toString() + " con un monto de: " + c.getMonto().toString();
	        }
	    }
	    
	    throw new NoTieneComprasEnEsaFechaException("No hay compras en esa fecha");
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

	public boolean verificarQueElConsumidorSeHayaCreadoCorrectamente() throws NumeroDeTarjetaInvalidoException{
		try {
			for(MisMediosDePagos t : misTarjetas) {
			if(t.getNumeroTarjeta().length()!=16) {
				throw new NumeroDeTarjetaInvalidoException ("los nros de tarjeta debe tener 16 caracteres ");
			}
			}
			return true; 		
		}
		catch(NumeroDeTarjetaInvalidoException e) {
			System.out.println(e.getMessage());
			 return false; 
		}

	}
	
	public boolean verificarQueElCBUseHayaRegistradoCorrectamente() throws CBUInvalidoException{
		try {
			for(MisMediosDePagos t : misTarjetas) {
			if(t.getCbu().length()!=20) {
				throw new CBUInvalidoException ("los cbu deben tener 20 caracteres ");
			}
			}
			return true; 		
		}
		catch(CBUInvalidoException e) {
			System.out.println(e.getMessage());
			 return false; 
		}

	}
	
	public boolean verificarQueElCVUseHayaRegistradoCorrectamente() throws CVUInvalidoException{
		try {
			for(MisMediosDePagos t : misTarjetas) {
			if(t.getCvu().length()!=23) {
				throw new CVUInvalidoException ("los cvu deben tener 23 digitos ");
			}
			}
			return true; 		
		}
		catch(CVUInvalidoException e) {
			System.out.println(e.getMessage());
			 return false; 
		}

	}
	
	
	public boolean verificarQueElTitularDelMedioDePagoSeaCorrecto(MisMediosDePagos tarjeta) throws NoCoincideTitularException{
		try {
			
			if(tarjeta.getNombreDelTitular()!= tarjeta.getTitular().getNombre()) {
				throw new NoCoincideTitularException ("el titular de la tarjeta no es la misma persona asociada al medio de pago");
			}
			
			return true; 		
		}
		catch(NoCoincideTitularException e) {
			System.out.println(e.getMessage());
			 return false; 
		}

	}
	
	
}
