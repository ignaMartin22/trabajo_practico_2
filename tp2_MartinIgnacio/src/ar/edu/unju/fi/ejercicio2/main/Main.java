package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Meses;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.model.Producto;

public class Main {

	public static void main(String[] args) {
		int opc;
		Scanner scanner = new Scanner(System.in);
		List <Efemeride> efemerides =  new ArrayList();
		do {
			menu();
			opc = scanner.nextInt();
			switch(opc) {
			case 1:
				try {
					boolean verif1 = true;
					int codigo;
					do {
						verif1 = true;
				System.out.println("Ingrese codigo de efemeride: ");
			     codigo = scanner.nextInt();
			     for(Efemeride e: efemerides) {
			    	 if(e.getCodigo() == codigo) {
			    		 System.out.println("Codigo existente");
			    		 verif1 = false;
			    	 }
			     }
					}while(verif1 == false);
				int indice;
				do {
				System.out.println("Ingrese Número del mes: ");
				indice = scanner.nextInt()-1;
				if(indice < 1 || indice >12) System.out.println("Mes inexistente");
				}while(indice < 1 || indice>12); 
				Meses mes = Meses.values()[indice];
				
				boolean verif = false;
				int dia;
				indice += 1;
				do {
				System.out.println("Ingrese día: ");
				dia = scanner.nextInt();
				System.out.println(indice);
					
				if(dia <1) {
					System.out.println("INVALIDO");
				}else {
				if(dia > 28 && indice == 2) {
						System.out.println("El mes elegido tiene solo 28 dias");
					}else {
						if(dia > 30 && indice == 4 || indice == 6 || indice == 9 || indice == 11) {
							System.out.println("El mes elegido tiene solo 30 dias");
						}else {
							 if(dia > 31) {
							System.out.println("fecha inválida");
							 }else {	
							       verif = true;
							 }
					            }
					   
					}
				}
					}while(verif == false);
				
				scanner.nextLine();
				System.out.println("Ingrese detalle: ");
				String detalles = scanner.nextLine();
				
				Efemeride efemeride = new Efemeride();
			efemeride.setCodigo(codigo);
			efemeride.setDetalle(detalles);
			efemeride.setDia(dia);
			efemeride.setMes(mes);
			efemerides.add(efemeride);
				}catch(Exception e) {
					System.out.println("Error inesperado");
					scanner.nextLine();
				}
				
				break;
			case 2:
				for(Efemeride e : efemerides) {
					System.out.println(e.toString());
					System.out.println("-----------------------------");
				}
				break;
				
			case 3:
				try {
				System.out.println("Ingrese codigo de efemerides: ");
				int codigoEliminar = scanner.nextInt();
				efemerides.removeIf(efemeride -> efemeride.getCodigo()==codigoEliminar);
				}catch(Exception e) {
					System.out.println("ERROR INESPERADO");
					scanner.nextLine();
				}
				break;
				
			case  4:
				try {
				System.out.println("Ingrese codigo de efemerides: ");
				int codigoModificar = scanner.nextInt();
				for(Efemeride e: efemerides) {
					if(e.getCodigo() == codigoModificar) {
						System.out.println("Seleccione dato a modificar: ");
						System.out.println("1- DIA");
						System.out.println("2- MES");
						System.out.println("3- DETALLES");
						int datoModificar = scanner.nextInt();
						
						switch(datoModificar) {
						case 1:
							Meses m = e.getMes();
							boolean verif = false;
							int dia3;
							do {
							System.out.println("Ingrese día: ");
							dia3 = scanner.nextInt();
							
							
								
							if(dia3 <1) {
								System.out.println("INVALIDO");
							}else {
							if(dia3 > 28 && m == Meses.FEBRERO) {
									System.out.println("El mes elegido tiene solo 28 dias");
								}else {
									if(dia3 > 30 && (m == Meses.ABRIL || m == Meses.JUNIO || m == Meses.SEPTIEMBRE  || m == Meses.NOVIEMBRE)) {
										System.out.println("El mes elegido tiene solo 30 dias");
									}else {
										 if(dia3 > 31) {
										System.out.println("fecha inválida");
										 }else {	
										       verif = true;
										 }
								            }
								}
							}
								}while(verif == false);
							
							e.setDia(dia3);
							break;
							
						case 2:
							int indice;
							boolean verif2 = false;
							int dia2 = e.getDia();
							do {
							System.out.println("Ingrese Número del mes: ");
							indice = scanner.nextInt()-1;
							if(indice < 1 || indice >12) {
								System.out.println("Mes inexistente");
							}else {
							if(dia2 > 28 && indice == 2) {
								System.out.println("Mes y dias incompatible");
							}else {
								if(dia2 > 30 && indice == 4 || indice == 6 || indice == 9 || indice == 11) {
									System.out.println("Mes y dia incompatible");
								}else {
									 if(dia2 > 31) {
											System.out.println("fecha inválida");
									 }else {
										 verif2 = true;
									 }
								}
							}
							}
							}while(verif2 == false); 
							Meses mes = Meses.values()[indice];
							e.setMes(mes);
							break;
							
						case 3:
							scanner.nextLine();
							System.out.println("Ingrese detalle nuevo: ");
							String detallesNuevos = scanner.nextLine();
							e.setDetalle(detallesNuevos);
							break;
						}
					}
				}
				break;
				}catch(Exception e) {
					System.out.println("ERROR INESPERADO");
				    scanner.nextLine();
				}
			case 5: 
				System.out.println("FIN DEL PROGRAMA");
				break;
	
			}
			
			
		}while(opc != 5);

	}
	public static void menu() {
		System.out.println("***MENU***");
		System.out.println("1- CREAR EFEMÉRIDE");
		System.out.println("2- MOSTRAR EFEMÉRIDE");
		System.out.println("3- ELIMINAR EFEMÉRIDE");
		System.out.println("4- MODIFICAR EFEMÉRIDE");
		System.out.println("5- SALIR");
		System.out.println("SELECCIONE UNA: ");
	}

}
