package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago  {
private double montoPagado;
private LocalDate fechaDePago;


public PagoEfectivo() {
	// TODO Auto-generated constructor stub
}



public double getMontoPagado() {
	return montoPagado;
}



public void setMontoPagado(double montoPagado) {
	this.montoPagado = montoPagado;
}



public LocalDate getFechaDePago() {
	return fechaDePago;
}



public void setFechaDePago(LocalDate fechaDePago) {
	this.fechaDePago = fechaDePago;
}



@Override
public void realizarPago(double monto) {
this.montoPagado = this.montoPagado-monto*0.10;
}
@Override
public void imprimirRecibo() {
System.out.println("***RECIBO***");
System.out.println("Fecha de pago: "+this.fechaDePago);
System.out.println("Monto pagado: "+this.montoPagado);
}
}
