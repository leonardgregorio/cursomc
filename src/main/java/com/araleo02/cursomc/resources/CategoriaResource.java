package com.araleo02.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.araleo02.cursomc.domain.Categoria;

@RestController // anotacao para indicar uma classe rest
@RequestMapping(value = "/categorias") // o rest vai responder por esse nome
public class CategoriaResource { // classe rest - fica em resource

	@RequestMapping(method = RequestMethod.GET) // para obter um dado, usa GET
	public List<Categoria> listar() {

		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");

		List<Categoria> lista = new ArrayList<>();

		lista.add(cat1);
		lista.add(cat2);

		return lista;
	}

}
