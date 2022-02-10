package com.curso.excepciones;

public class ProductosException extends Exception {

	private String idProducto;
	private String claveMensaje; // mensaje está en un properties (multiidioma)
	
	public ProductosException(String message, 
			String idProducto, 
			String claveMensaje) {
		super(message);
		this.claveMensaje = claveMensaje;
		this.idProducto = idProducto;
	}
	
   public String getClaveMensaje() {
	return claveMensaje;
   }
	
	public String getIdProducto() {
		return idProducto;
	}

}
