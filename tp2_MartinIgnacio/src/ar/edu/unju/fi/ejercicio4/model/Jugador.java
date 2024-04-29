package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
private String nombre;
private String apellido;
private LocalDate fechaNacimiento;
private String nacionalidad;
private float estatura;
private float peso;
private Posicion posicion;


@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+nombre+", Apellido: "+apellido+", Fecha de Nacimiento: "+fechaNacimiento+", Nacionalidad: "+nacionalidad+", Estatura: "+estatura+", Peso: "+peso+", Posicion: "+posicion+", Edad: "+calcularEdad();
	}

public Jugador() {
	// TODO Auto-generated constructor stub
}
public String getNombre() {
	return nombre;
}






public void setNombre(String nombre) {
	this.nombre = nombre;
}






public String getApellido() {
	return apellido;
}






public void setApellido(String apellido) {
	this.apellido = apellido;
}






public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}






public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}






public String getNacionalidad() {
	return nacionalidad;
}






public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}






public float getEstatura() {
	return estatura;
}






public void setEstatura(float estatura) {
	this.estatura = estatura;
}






public float getPeso() {
	return peso;
}






public void setPeso(float peso) {
	this.peso = peso;
}






public Posicion getPosicion() {
	return posicion;
}






public void setPosicion(Posicion posicion) {
	this.posicion = posicion;
}






public int calcularEdad() {
	LocalDate hoy = LocalDate.now();
	Period periodo = Period.between(fechaNacimiento, hoy);
	int edad = periodo.getYears();
	return edad;
}
}
