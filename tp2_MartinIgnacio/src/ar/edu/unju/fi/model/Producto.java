package ar.edu.unju.fi.model;

public class Producto {
 private int codigo;
 private String descripcion;
 private Float precio;
 private Origen origenFabricacion;
 public enum Origen{
	 ARGENTINA, CHINA, BRASIL, URUGUAY
 }
 private Categ categoria;
 public enum Categ{
	 TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
 }
 private boolean stock;
 
 public Producto() {
	// TODO Auto-generated constructor stub
}
public Producto(int codigo, String descripcion, Float precio, Origen origenFabricacion, Categ categoria, boolean stock) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.precio = precio;
	this.origenFabricacion = origenFabricacion;
	this.categoria = categoria;
	this.stock = stock;
}
public Producto(int codigo, String descripcion, Float precio, Origen origenFabricacion, Categ categoria) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.precio = precio;
	this.origenFabricacion = origenFabricacion;
	this.categoria = categoria;
}

public boolean getStock() {
	return stock;
}
public void setStock(boolean stock) {
	this.stock = stock; 
}
public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Float getPrecio() {
	return precio;
}

public void setPrecio(Float precio) {
	this.precio = precio;
}

public Origen getOrigenFabricacion() {
	return origenFabricacion;
}

public void setOrigenFabricacion(Origen origenFabricacion) {
	this.origenFabricacion = origenFabricacion;
}

public Categ getCategoria() {
	return categoria;
}

public void setCategoria(Categ categoria) {
	this.categoria = categoria;
}
@Override
	public String toString() {
		return "Codigo: "+codigo+", Descripción: "+descripcion+", Precio Unitario: "+precio+", ORIGEN DE FABRICACIÓN: "+origenFabricacion+", CATEGORIA: "+categoria+ ", Stock: "+stock;
	}
 

 
 
 
 
 
}
