
package com.curso.service;

import com.curso.domain.Producto;
import java.util.List;
import java.util.Map;


public interface ProductoService {
    
    List <Producto> getTodosProductos();
    List<Producto> getProductosPorCategoria(String categoria); 
    Producto getProductoPorId(String idProducto);
}
