package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String numeroDeTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}



	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}



	public LocalDate getFechaDePago() {
		return fechaDePago;
	}



	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}



	public double getMontoPagado() {
		return montoPagado;
	}



	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}



	@Override
	public void realizarPago(double monto) {
		this.montoPagado = this.montoPagado+monto*0.15;
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("***RECIBO***");
		System.out.println("Número de Tarjeta: "+this.numeroDeTarjeta);
		System.out.println("Fecha de Pago: "+this.fechaDePago);
		System.out.println("Monto Pagado: "+ this.montoPagado);
		
	}
}
