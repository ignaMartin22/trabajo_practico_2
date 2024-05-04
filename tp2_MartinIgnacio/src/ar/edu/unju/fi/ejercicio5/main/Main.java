package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.Categ;
import ar.edu.unju.fi.model.Producto.Origen;

public class Main {

	public static void main(String[] args) {
		List <Producto> productos = new ArrayList();
		Scanner scanner = new Scanner(System.in);
		cargaProductos(productos);
		int opc;
		do {

			System.out.println("TIENDA ONLINE");
			System.out.println("1- Mostrar Productos");
			System.out.println("2- Realizar compra");
			System.out.println("3- Salir");
			System.out.println("Seleccione: ");
			opc = scanner.nextInt();

			switch(opc) {
			case 1:
				for(Producto p: productos) {
					System.out.println(p);
				}
				break;
				
			case 2:
				try {
				int opc2;
				int codigo;
				int opc3;
				List <Producto> carrito = new ArrayList();
				do {
					System.out.println("Ingrese código de producto para agregar a su carrito: ");
					codigo = scanner.nextInt();
					for(Producto p: productos) {
						if(codigo == p.getCodigo()) {
							if(p.getStock() == true) {
								carrito.add(p);
							System.out.println(p.getDescripcion()+" agregado al carrito con éxito :)");
							}else {
								System.out.println("El producto seleccionado no tiene stock");
							}
							}
					}
					System.out.println("Para seguir agregando productos presione 1, para finalizar presione 0: ");
					opc2=scanner.nextInt();
				}while(opc2 != 0);
				
				System.out.println("1- Pago efectivo");
				System.out.println("2- Pago con tarjeta");
				opc3 = scanner.nextInt();
				double montoTotal = 0;
				switch(opc3) {
				case 1:
					PagoEfectivo pagoEfectivo = new PagoEfectivo();
					
					for(Producto p: carrito) {
						montoTotal +=p.getPrecio();
					}
					System.out.println("El monto total es: "+ montoTotal);
					pagoEfectivo.setFechaDePago(LocalDate.now());
					pagoEfectivo.setMontoPagado(montoTotal);
					pagoEfectivo.realizarPago(montoTotal);
					pagoEfectivo.imprimirRecibo();
					break;
				case 2:
					PagoTarjeta pagoTarjeta = new PagoTarjeta();
					System.out.println("Ingrese numero de tarjeta: ");
					String nro = scanner.next();
					pagoTarjeta.setNumeroDeTarjeta(nro);
					pagoTarjeta.setFechaDePago(LocalDate.now());
					
					for(Producto p: carrito) {
						montoTotal +=p.getPrecio();
					}
					System.out.println("El  monto total es: "+ montoTotal);
					pagoTarjeta.setMontoPagado(montoTotal);
					pagoTarjeta.realizarPago(montoTotal);
					pagoTarjeta.imprimirRecibo();
					

					break;	
				}
				}catch(Exception e) {
					System.out.println("ERROR");
					scanner.nextLine();
				}
				break;
				
			case 3:
				System.out.println("FIN");
				break;
			}


		}while(opc != 3);

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
