package com.araleo02.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araleo02.cursomc.domain.Categoria;
import com.araleo02.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		return obj;
	}
	
	
	
}