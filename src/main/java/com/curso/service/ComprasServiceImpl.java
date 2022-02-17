package com.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;

@Service
public class ComprasServiceImpl implements ComprasService {

	
    @Autowired
	@Qualifier("JPAProductoRepository")
    private ProductoRepository repositorio;
    
	@Override
	public void comprar(String idProducto, int cantidad) {
		
			// primero valido producto Existe
//		
//		    if ( ! repositorio.existeProducto(idProducto)) {
//		    	throw new RuntimeException("No existe el producto");
//		    }
		    // si existe decremento stock
		    
		    Producto p = repositorio.getProductoPorId(idProducto);
		    p.setUnidadesEnStock(p.getUnidadesEnStock() - cantidad);
		

	}

}
