package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String saludar(Model model) {
		model.addAttribute("saludo", "Bienvenido a nuestra tienda online!");
	    model.addAttribute("linea1", "Los mejores productos ");
		return "inicio";  // WEB-INF/jsp/inicio.jsp
	}
	
	
	@RequestMapping("/adios")
	public String otro() {
		return "adios";
	}
}
