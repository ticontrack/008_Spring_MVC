package com.curso.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 5)
    private String idProducto;
    
    @Size(max=200)
    private String nombre;
    private BigDecimal precionUnitario;
    private String descripcion;
    private String fabricante;
    private String categoria;
    private long unidadesEnStock;
    private long unidadesEnPedido;
    private boolean disponible;
    private String condiciones;
    
    //constructores

    public Producto(String idProducto, String nombre, BigDecimal precionUnitario) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precionUnitario = precionUnitario;
    }

    public Producto() {
    }

    //getters y setters
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public BigDecimal getPrecioUnitario() {
        return precionUnitario;
    }

    public void setPrecioUnitario(BigDecimal precionUnitario) {
        this.precionUnitario = precionUnitario;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

  

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public long getUnidadesEnStock() {
        return unidadesEnStock;
    }

    public void setUnidadesEnStock(long unidadesEnStock) {
        this.unidadesEnStock = unidadesEnStock;
    }

    public long getUnidadesEnPedido() {
        return unidadesEnPedido;
    }

    public void setUnidadesEnPedido(long unidadesEnPedido) {
        this.unidadesEnPedido = unidadesEnPedido;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idProducto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + "]";
    }
    
 

}
