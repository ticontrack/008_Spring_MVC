package com.curso.controller;
import com.curso.domain.Producto;
import com.curso.excepciones.ProductosException;
import com.curso.service.ComprasService;
import com.curso.service.ProductoService;

import java.util.Collection;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        
        Producto p = productoService.getProductoPorId(idProducto);
        model.addAttribute("producto", p);

        return "producto";
    }
     
     
     //  lista de categorias por categoría 
     //  /productos/{categoria}
     //  /productos/Smart+Phone
     @RequestMapping("/productos/{categoria}")
     public String productosPorCategoria(
             @PathVariable("categoria") String categoriaProducto,
    		 Model model) {
    	 
    	 Collection<Producto> lista = productoService.getProductosPorCategoria(categoriaProducto);
    	 model.addAttribute("productos", lista);
    	 return "productos";
     }
     
     // productos/tablet/Apple
     @GetMapping("/productos/{categoria}/{fabricante}")
     public String getProductosPorCategoriaYColor(
    		 @PathVariable("categoria") String categoriaProducto,
    		 @PathVariable("fabricante") String fabricante,
    		 Model model
    		 ) {
    	 //falta llamar a la capa de negogio y pasar model
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
    
    
    // MOSTAR EL FORMULARIO   - GET
    @GetMapping("/productos/nuevo")
    public String getCrearNuevoProductoFormulario(Model model) {     
    	Producto nuevoProducto = new Producto(); 
    	nuevoProducto.setNombre("Nuevo");
    	model.addAttribute("nuevoProducto", nuevoProducto); 
    	return "crear-producto"; 
    } 
    
    
    // PROCESAR LOS DATOS DEL FORMULARIO  - POST
    @PostMapping("/productos/nuevo")
    public String crearNuevoProductoFormulario(
    		@ModelAttribute("nuevoProducto") @Valid Producto nuevoProducto,
    		Model model,
    		BindingResult bindingResult) throws ProductosException {
    	
    	//falta validar
    	if(bindingResult.hasErrors()) {
    		//vamos otra vez al formulario
    		return "crear-producto";
    	}
    	
    	//try {
			productoService.crearProducto(nuevoProducto);
			return "redirect:/productos"; 
//		} catch (ProductosException e) {
//			
//			model.addAttribute("error", e.getClaveMensaje());
//			model.addAttribute("nuevoProducto", nuevoProducto); 
//	    	return "crear-producto"; 
//			
//		}

    }
    
    
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException( Exception exception) {
        
         ModelAndView mav = new ModelAndView();
        if(exception instanceof ProductosException){
            mav.addObject("arg0","Error Producto");
            mav.addObject("claveMensage",((ProductosException)exception).getClaveMensaje());
        
        }else{
             
             mav.addObject("arg0",exception.getMessage());
             mav.addObject("claveMensage","error.inexperado");
             Logger.getAnonymousLogger().severe(exception.getMessage());
        }
        mav.setViewName("producto-exception");
        return mav;
    }
    
    
    
    
  
    
}
