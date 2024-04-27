package ar.edu.unju.fi.ejercicio2.model;
import ar.edu.unju.fi.ejercicio2.constantes.*;
public class Efemeride {
private int codigo;
private Meses mes;
private int dia;
private String detalle;


public Efemeride() {
	// TODO Auto-generated constructor stub
}


public int getCodigo() {
	return codigo;
}


public void setCodigo(int codigo) {
	this.codigo = codigo;
}


public Meses getMes() {
	return mes;
}


public void setMes(Meses mes) {
	this.mes = mes;
}


public int getDia() {
	return dia;
}


public void setDia(int dia) {
	this.dia = dia;
}


public String getDetalle() {
	return detalle;
}


public void setDetalle(String detalle) {
	this.detalle = detalle;
}
 
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Codigo: "+codigo+", Dia: "+dia+", Mes: "+mes+", Detalle: "+detalle;
	}

}


