package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
JUJUY(811611,53129), SALTA(1440672,155488), TUCUMAN(1703186,22524), CATAMARCA(367828,102602), LA_RIOJA(324446,89680), SANTIAGO_DEL_ESTERO(874006, 136351);
private long cantidadHabitantes;
private long superficie;


private Provincia(long cantidadHabitantes, long superficie) {
	this.cantidadHabitantes = cantidadHabitantes;
	this.superficie = superficie;
}

public long getCantidadHabitantes() {
	return cantidadHabitantes;
}
public void setCantidadHabitantes(long cantidadHabitantes) {
	this.cantidadHabitantes = cantidadHabitantes;
}
public long getSuperficie() {
	return superficie;
}
public void setSuperficie(long superficie) {
	this.superficie = superficie;
}

public double calcularDensidad() {
	return cantidadHabitantes/superficie;
	
		}

}
