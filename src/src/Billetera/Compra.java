package src.Billetera;

import java.time.LocalDate;
import java.util.Objects;

public class Compra {


	protected LocalDate fechaCompra;
	protected Integer nroCompra; 
	protected Comercio comercio; 
	protected Consumidor cliente; 
	protected Double monto; 
	protected boolean compraAprobada;
	
	
	public Compra(LocalDate fechaCompra,Integer nroCompra,  Comercio comercio,Consumidor cliente, Double monto, boolean compraAprobada) {
		this.fechaCompra = fechaCompra;
		this.nroCompra= nroCompra; 
		this.comercio = comercio;
		this.cliente=cliente; 
		this.monto = monto;
		this.compraAprobada = compraAprobada;
	}


	public Integer getNroCompra() {
		return nroCompra;
	}


	public void setNroCompra(Integer nroCompra) {
		this.nroCompra = nroCompra;
	}


	public Consumidor getCliente() {
		return cliente;
	}


	public void setCliente(Consumidor cliente) {
		this.cliente = cliente;
	}


	public LocalDate getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public Comercio getComercio() {
		return comercio;
	}


	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}


	public Double getMonto() {
		return monto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}


	public boolean isCompraAprobada() {
		return compraAprobada;
	}


	public void setCompraAprobada(boolean compraAprobada) {
		this.compraAprobada = compraAprobada;
	} 
	
	
	public boolean queLaCompraNoExcedaElSaldoDeLaTarjeta(Compra compra, MisMediosDePagos tarjeta) throws SaldoInsuficienteException{
		try {
			if(compra.getMonto()<tarjeta.getSaldo()&& compra.isCompraAprobada()==true) {
				return true; 
			}
			else {throw new SaldoInsuficienteException ("saldo insuficiente");}
		}
		catch(SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
			return false; 
		}
	}
	
	
	
	public boolean queLaCompraNoExcedaElLimiteDeLaTarjeta(Compra compra, MisMediosDePagos tarjeta) throws ExcedeLimiteDeCompraException{
		try {
			if(compra.getMonto()<tarjeta.getLimite() && compra.isCompraAprobada()==true) {
				return true; 
			}
			else {throw new ExcedeLimiteDeCompraException ("limite insuficiente para realizar esta compra");}
		}
		catch(ExcedeLimiteDeCompraException e) {
			System.out.println(e.getMessage());
			return false; 
		}
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nroCompra);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(nroCompra, other.nroCompra);
	}

	
}
