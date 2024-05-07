package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.*;

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.Categ;
import ar.edu.unju.fi.model.Producto.Origen;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List <Producto> productos = new ArrayList();
		Consumer <Producto> printList = c ->  System.out.println(c);
		cargaProductos(productos);
		int op;
		do {
			  menu();
			 op = scanner.nextInt();
			switch(op) {
			case 1:
				Consumer <Producto> printConsumer = c -> {
					if(c.getStock()  == true) {
					System.out.println(c);
					}
				};
				productos.forEach(printConsumer);
				break;
			case 2:
				
				Predicate <Producto> filtroDeNoStock = n -> n.getStock() == false;
				List <Producto> productosNoStock = new ArrayList();
				productosNoStock = productos.stream().filter(filtroDeNoStock).collect(Collectors.toList());
			
				productosNoStock.forEach(printList);
				break;
			case 3:
				List <Producto> productosIncrementados = new ArrayList();
				Function<Producto, Producto> incrementaPrecio  = (p) -> {
					Float resultado = p.getPrecio() + p.getPrecio() * 0.2f;
					p.setPrecio(resultado);
					return p;
					};
				productosIncrementados = productos.stream().map(incrementaPrecio).collect(Collectors.toList());
				
				System.out.println("PRECIOS INCREMENTADOS 20%");
				productosIncrementados.forEach(printList);
				
				break;
			case 4:
				Predicate<Producto> productosElectrohogar = p -> p.getCategoria().equals(Categ.ELECTROHOGAR) && p.getStock() ==  true;
				List<Producto> productosDeElectroHogar = new ArrayList();
				
				productosDeElectroHogar = productos.stream().filter(productosElectrohogar).collect(Collectors.toList());
				productosDeElectroHogar.forEach(printList);
				break;
			case 5:
				
				productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
				System.out.println("Ordenado con éxito!");
				System.out.println("=========================");
				System.out.println("Lista ordenada por precio descnedente");
				productos.forEach(printList);
				System.out.println("=========================");
				
				break;
			case 6:
				List <Producto> productosMayus = new ArrayList();
				Function<Producto, Producto> productoAMayus  = (p) -> {
					p.setDescripcion(p.getDescripcion().toUpperCase());
					return p;
					};
				productosMayus = productos.stream().map(productoAMayus).collect(Collectors.toList());
				
				productosMayus.forEach(printList);
				break;
			case 7:
				System.out.println("Fin del programa");
				break;
			}

		}while(op != 7);
		

	}

	public static void menu() {
		System.out.println("*** MENU ***");
		System.out.println("============================================");
		System.out.println("1- Mostrar productos con stock");
		System.out.println("2- Mostrar productos sin stock");
		System.out.println("3- Incrementar precios 20%");
		System.out.println("4- Mostrar productos de Electrohogar en stock");
		System.out.println("5- Ordenar producto por precio");
		System.out.println("6- Mostrar productos con nombre en mayuscula");
		System.out.println("============================================");
		System.out.println("Seleccione una opción: ");
	}
	 public static void cargaProductos(List<Producto> productos) {
		 Producto p1 = new Producto(0, "Licuadora", 2300f, Origen.BRASIL, Categ.ELECTROHOGAR, true);
		 productos.add(p1);
		 Producto p2 = new Producto(1, "Lavarropas", 5000f, Origen.CHINA, Categ.ELECTROHOGAR, true);
		 productos.add(p2);
		 Producto p3 = new Producto(2, "Heladera", 1988f, Origen.CHINA, Categ.ELECTROHOGAR, true);
		 productos.add(p3);
		 Producto p4 = new Producto(3, "iPhone 12",2000f , Origen.URUGUAY, Categ.TELEFONIA, true);
		 productos.add(p4); 
		 Producto p5 = new Producto(4, "iPhone 13", 2500f, Origen.URUGUAY, Categ.TELEFONIA, false);
		 productos.add(p5); 
		 Producto p6 = new Producto(5, "Teléfono fijo", 200f, Origen.CHINA,Categ.TELEFONIA, true);
		 productos.add(p6); 
		 Producto p7 = new Producto(6, "Router WIFI", 500f,  Origen.URUGUAY, Categ.INFORMATICA, false);
		 productos.add(p7);
		 Producto p8 = new Producto(7, "Martillo", 50f, Origen.CHINA, Categ.HERRAMIENTAS, true);
		 productos.add(p8);
		 Producto p9 = new Producto(8, "Taladro", 800f, Origen.CHINA, Categ.HERRAMIENTAS, false);
		 productos.add(p9);
		 Producto p10 = new Producto(9, "Destornillador", 50f, Origen.CHINA, Categ.HERRAMIENTAS, true);
		 productos.add(p10);
		 Producto p11 = new Producto(10, "Placa de video", 700f, Origen.BRASIL, Categ.INFORMATICA, false);
		 productos.add(p11);
		 Producto p12 = new Producto(11, "Netbook Gateway", 500f, Origen.BRASIL, Categ.INFORMATICA, true);
		 productos.add(p12);
		 Producto p13 = new Producto(12, "Auriculares inalámbricos", 120f, Origen.BRASIL, Categ.INFORMATICA, true);
		 productos.add(p13);
		 Producto p14 = new Producto(13, "Televisor Samsung", 500f, Origen.CHINA, Categ.ELECTROHOGAR, true);
		 productos.add(p14);
		 Producto p15 = new Producto(14, "Televisor LG", 450f, Origen.BRASIL, Categ.ELECTROHOGAR, true);
		 productos.add(p15);
	 }

}
