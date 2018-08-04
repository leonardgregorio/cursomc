package com.araleo02.cursomc;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.araleo02.cursomc.domain.Categoria;
import com.araleo02.cursomc.domain.Cidade;
import com.araleo02.cursomc.domain.Estado;
import com.araleo02.cursomc.domain.Produto;
import com.araleo02.cursomc.repositories.CategoriaRepository;
import com.araleo02.cursomc.repositories.CidadeRepository;
import com.araleo02.cursomc.repositories.EstadoRepository;
import com.araleo02.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Mouse", 100.00);
		Produto p2 = new Produto(null, "teclado", 200.00);
		Produto p3 = new Produto(null, "cadeira", 300.00);

		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		Estado e3 = new Estado(null, "Rio Janeiro");

		Cidade c1 = new Cidade(null, "Uberlandia", e1);
		Cidade c2 = new Cidade(null, "Sao Carlos", e2);
		Cidade c3 = new Cidade(null, "Niteroi", e3);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2));
		e3.getCidades().addAll(Arrays.asList(c3));

		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		estadoRepository.save(Arrays.asList(e1, e2, e3));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));

	}
}
