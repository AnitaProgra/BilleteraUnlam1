package src.Billetera;

import java.util.Objects;

public class MisMediosDePagos {

	protected TiposDeMediosDePagos tipo;
	protected String nombreDelTitular; 
	protected Consumidor titular;
	protected String numeroTarjeta; 
	protected String cvu;
    protected String cbu;
	protected Double saldo; 
	protected Double limite;
	
	
	public MisMediosDePagos(TiposDeMediosDePagos tipo, Consumidor titular, String numeroTarjeta) {
		this.tipo = tipo;
		this.titular = titular;
		this.numeroTarjeta = numeroTarjeta;

	}
	
	
	public MisMediosDePagos(TiposDeMediosDePagos tipo, Consumidor titular, String numeroTarjeta, String cvu, String cbu) {
		this.tipo = tipo;
		this.titular = titular;
		this.numeroTarjeta = numeroTarjeta;
		this.cvu= cvu; 
		this.cbu= cbu; 

	}

	
	public MisMediosDePagos(TiposDeMediosDePagos tipo,String nombreDelTitular, Consumidor titular) {
		this.tipo = tipo;
		this.nombreDelTitular=nombreDelTitular;  
		this.titular = titular;

	}
	
	public MisMediosDePagos(TiposDeMediosDePagos tipo,String nombreDelTitular, Consumidor titular,Double saldo, Double limite ) {
		this.tipo = tipo;
		this.nombreDelTitular=nombreDelTitular;  
		this.titular = titular;
		this.saldo= saldo; 
		this.limite= limite; 

	}
	
	public String getCvu() {
		return cvu;
	}

	public void setCvu(String cvu) {
		this.cvu = cvu;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public TiposDeMediosDePagos getTipo() {
		return tipo;
	}


	public void setTipo(TiposDeMediosDePagos tipo) {
		this.tipo = tipo;
	}


	public Consumidor getTitular() {
		return titular;
	}


	public void setTitular(Consumidor titular) {
		this.titular = titular;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public Double getLimite() {
		return limite;
	}


	public void setLimite(Double limite) {
		this.limite = limite;
	}


	public String getNombreDelTitular() {
		return nombreDelTitular;
	}

	public void setNombreDelTitular(String nombreDelTitular) {
		this.nombreDelTitular = nombreDelTitular;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroTarjeta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisMediosDePagos other = (MisMediosDePagos) obj;
		return numeroTarjeta == other.numeroTarjeta;
	} 
	
	
	
}
