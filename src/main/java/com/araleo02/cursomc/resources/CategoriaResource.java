package com.araleo02.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // anotacao para indicar uma classe rest
@RequestMapping(value = "/categorias") // o rest vai responder por esse nome
public class CategoriaResource { // classe rest - fica em resource

	@RequestMapping(method = RequestMethod.GET) // para obter um dado, usa GET
	public String listar() {
		return "Rest está funcionando";
	}

}
