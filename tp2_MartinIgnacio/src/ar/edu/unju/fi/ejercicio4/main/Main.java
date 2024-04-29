package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opc;
		List <Jugador> jugadores = new ArrayList();
		do {
			menu();
			System.out.println("Ingrese opción: ");
			opc = scanner.nextInt();
			switch(opc) {
			case 1:
				try {
				Jugador jugador = new Jugador();
				System.out.println("Nuevo Jugador");
				System.out.println("Ingrese nombre: ");
				String nombre = scanner.next();
				System.out.println("Ingrese Apellido: ");
				String apellido = scanner.next();
				System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
				String fecha = scanner.next();
				LocalDate fechaNacimiento;
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fechaNacimiento = LocalDate.parse(fecha, formato);

				scanner.nextLine();
				System.out.println("Ingrese Nacionalidad: ");
				String nacionalidad = scanner.next();
				System.out.println("Ingrese estatura: ");
				float estatura = scanner.nextFloat();
				System.out.println("Ingrese peso: ");
				float peso = scanner.nextFloat();
				System.out.println("Seleccione posicion: ");
				System.out.println("0- Delantero");
				System.out.println("1- Medio");
				System.out.println("2- Defensa");
				System.out.println("3- Arquero");
				int posicion = scanner.nextInt();
				Posicion pos = Posicion.values()[posicion];
				
				jugador.setApellido(apellido);
				jugador.setNombre(nombre);
				jugador.setEstatura(estatura);
				jugador.setPeso(peso);
				jugador.setFechaNacimiento(fechaNacimiento);
				jugador.setNacionalidad(nacionalidad);
				jugador.setPosicion(pos);
				
				jugadores.add(jugador);
				}catch(Exception e) {
					System.out.println("Error inesperado");
					scanner.nextLine();
				}
				break;
				
			case 2:
				for(Jugador j: jugadores) {
					System.out.println(j.toString());
					System.out.println("---------------------------------");
				}
				break;
				
			case 3:
				try {
				System.out.println("Ingrese nombre del jugador: ");
				String nombreModificar = scanner.next();
				System.out.println("Ingrese apellido del jugador: ");
				String apellidoModificar = scanner.next();
				
				for(Jugador j: jugadores) {
					if(j.getNombre().equals(nombreModificar) && j.getApellido().equals(apellidoModificar)) {
						System.out.println("Seleccione nueva posicion: ");
						System.out.println("0- Delantero");
						System.out.println("1- Medio");
						System.out.println("2- Defensa");
						System.out.println("3- Arquero");
						int posicion = scanner.nextInt();
						Posicion pos = Posicion.values()[posicion];
						j.setPosicion(pos);
					}
				}
				
				
				}catch(Exception e) {
					System.out.println("ERROR INESPERADO");
					scanner.nextLine();
				}
				break;
			case 4:
				System.out.println("FIN DEL PROGRAMA");
				break;
			}
		}while(opc != 4);
	}

	public static void menu() {
		System.out.println("***  MENU ***");
		System.out.println("1- Alta de jugador");
		System.out.println("2- Mostrar todos los jugadores");
		System.out.println("3- Modificar posicion de un jugador");
		System.out.println("4- Salir");
	}
}
