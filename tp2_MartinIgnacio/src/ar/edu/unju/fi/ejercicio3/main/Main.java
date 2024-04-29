package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
	
		for(Provincia p: Provincia.values()) {
			System.out.println("Provincia: "+p.name());
			System.out.println("Cantidad de habitantes: "+p.getCantidadHabitantes()+"hab");
			System.out.println("Superficie: "+p.getSuperficie()+"km2");
			System.out.println("Densidad poblacional: "+p.calcularDensidad()+"hab/km2");
			System.out.println("------------------------------------------------");
		}
	}

}
