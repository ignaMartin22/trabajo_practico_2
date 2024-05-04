package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		FelinoSalvaje leon = new FelinoSalvaje("Tanner", (byte) 20, 186f);
		
		boolean comprobacion =  Converter.isNotNull(leon);
		
		if(comprobacion == true) {
		Converter<FelinoSalvaje,FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),x.getEdad(), x.getPeso());
		FelinoDomestico gato = converter.convert(leon);
		converter.mostrarObjeto(gato);
		}else {
			System.out.println("El objeto a convertir es nulo");
		}
		
	}

}
