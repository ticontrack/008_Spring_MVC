package com.curso.controller;
import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.service.ComprasService;
import com.curso.service.ProductoService;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductoController {
	
	 @Autowired
	 private ProductoService productoService;
	 
	 @Autowired
	 private ComprasService comprasService;
	    
    //   /producto?id=P1234
     @RequestMapping("/producto")
     public String producto(
    		 @RequestParam("id") String idProducto,
    		 Model model) {
        
        Producto p = null;
        model.addAttribute("producto", p);

        return "producto";
    }
     
     
     //  lista de categorias por categoría 
     //   /productos/{categoria}
     //  /productos/Smart+Phone
     @RequestMapping("/productos/{categoria}")
     public String productosPorCategoria(
             @PathVariable("categoria") String categoriaProducto,
    		 Model model) {
    	 
    	 Collection<Producto> lista = null;
    	 model.addAttribute("productos", lista);
    	 return "productos";
     }
     
     
     
     @RequestMapping("/productos")
     public String list(Model model) {

        model.addAttribute("productos", 
                productoService.getTodosProductos());

        return "productos";
    }

     // comprar?id=P1234
     @RequestMapping("/comprar")
     public String comprar(
    		 @RequestParam("id") String  productId,
    		 Model model) {
    	 // leer parametro id
    	 System.out.println("id es .... " + productId);
    	 comprasService.comprar(productId, 1);
    	 model.addAttribute("productos", 
                 productoService.getTodosProductos());
    	 return "productos";
     }
     
     
     
    public ProductoController() {
        System.out.println("... iniciando ProductController");
    }
  
    
}
