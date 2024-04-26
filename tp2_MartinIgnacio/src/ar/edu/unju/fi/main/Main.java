package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.Origen;
import ar.edu.unju.fi.model.Producto.Categ;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List <Producto> productos =  new ArrayList();
		int opc;
		do {
			menu();
			System.out.println("Ingresar opción: ");
			opc = scanner.nextInt();
			switch(opc) {
			case 1:
				try {
				System.out.println("Ingrese codigo de producto: ");
				int cod = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Ingrese descripción: ");
				String desc = scanner.nextLine();
				System.out.println("Ingrese precio: ");
				Float precio = scanner.nextFloat();
				System.out.println("--- Seleccione origen de fabricación ---");
				System.out.println("0- ARGENTINA");
				System.out.println("1- CHINA");
				System.out.println("2- BRASIL");
				System.out.println("3- URUGUAY");
				int indice = scanner.nextInt();
				Origen origenProducto = Origen.values()[indice];
				System.out.println("--- Seleccione categoria del producto ---");
				System.out.println("0- TELEFONIA");
				System.out.println("1- INFORMATICA");
				System.out.println("2- ELECTROHOGAR");
				System.out.println("3- HERRAMIENTAS");
				int indiceDos =  scanner.nextInt();
				Categ categoria = Categ.values()[indiceDos];
				Producto producto = new Producto(cod, desc, precio, origenProducto, categoria);
				productos.add(producto);
				}catch(InputMismatchException e) {
					System.out.println("Opción incorrecta, redireccionando a menú principal");
					scanner.nextLine();
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Opción incorrecta, redireccionando a menú principal");
					scanner.nextLine();
				}
				break;
			case 2:
				for(Producto p: productos) {
					System.out.println(p.toString());
					System.out.println("- - - - - - - - -");
				}
				break;
				
			case 3:
				try {
				System.out.println("Ingrese codigo de producto a modificar: ");
				int codigoModificador = scanner.nextInt();
				for(Producto p: productos) {
					if(codigoModificador == p.getCodigo()) {
						System.out.println(p.toString());
					
				System.out.println("Elija dato a modificar: ");
				System.out.println("1-Descripcion");
				System.out.println("2-Precio");
				System.out.println("3-Origen");
				System.out.println("4-Categoria");
				int opcion = scanner.nextInt();
				scanner.nextLine();
				switch(opcion) {
				case 1:
					System.out.println("Ingrese nueva descripción: ");
					String nuevaDesc = scanner.nextLine();
					p.setDescripcion(nuevaDesc);
					break;
				case 2:
					System.out.println("Ingrese nuevo precio: ");
					Float nuevoPrecio = scanner.nextFloat();
					p.setPrecio(nuevoPrecio);
					break;
				case 3:
					System.out.println("--- Seleccione origen de fabricación ---");
					System.out.println("0- ARGENTINA");
					System.out.println("1- CHINA");
					System.out.println("2- BRASIL");
					System.out.println("3- URUGUAY");
					int indiceNuevo = scanner.nextInt();
					Origen origenProductoNuevo = Origen.values()[indiceNuevo];
					p.setOrigenFabricacion(origenProductoNuevo);
					break;
				case 4:
					System.out.println("--- Seleccione categoria del producto ---");
					System.out.println("0- TELEFONIA");
					System.out.println("1- INFORMATICA");
					System.out.println("2- ELECTROHOGAR");
					System.out.println("3- HERRAMIENTAS");
					int indiceDosNuevo =  scanner.nextInt();
					Categ categoriaNueva = Categ.values()[indiceDosNuevo];
					p.setCategoria(categoriaNueva);					
					break;
				}
					}
				}

				}catch(InputMismatchException e) {
					System.out.println("Valor ingresado no válido");
					scanner.nextLine();
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Opción seleccionada no válida");
					scanner.nextLine();
				}catch(Exception e) {
					System.out.println("ERROR INESPERADO");
					
				}
				break;
				
			case 4:
				System.out.println("FIN DEL PROGRAMA");
				break;
				
			}
			
			
		}while(opc != 4);
	}
	
	public static void menu() {
		System.out.println("***MENU****");
		System.out.println("1- Crear Producto");
		System.out.println("2- Mostrar Productos");
		System.out.println("3- Modificar Producto");
		System.out.println("4- Salir");
	}

}
