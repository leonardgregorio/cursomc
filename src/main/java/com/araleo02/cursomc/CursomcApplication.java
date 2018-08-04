package com.araleo02.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.araleo02.cursomc.domain.Categoria;
import com.araleo02.cursomc.domain.Cidade;
import com.araleo02.cursomc.domain.Cliente;
import com.araleo02.cursomc.domain.Endereco;
import com.araleo02.cursomc.domain.Estado;
import com.araleo02.cursomc.domain.Produto;
import com.araleo02.cursomc.domain.enums.TipoCliente;
import com.araleo02.cursomc.repositories.CategoriaRepository;
import com.araleo02.cursomc.repositories.CidadeRepository;
import com.araleo02.cursomc.repositories.ClienteRepository;
import com.araleo02.cursomc.repositories.EnderecoRepository;
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

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
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

		Cliente cr1 = new Cliente(null, "Maria Jeus", "mariamaria@gmail.com", "3919191919-09", TipoCliente.PESSOAFISICA);
		cr1.getTelefones().addAll(Arrays.asList("16 97191919","19 238374732"));
		
		Endereco ed1 = new Endereco(null, "Rua Flores", "178", "", "jardim Silva", "14808022", cr1, c1);
		Endereco ed2 = new Endereco(null, "Rua nao sei", "111", "", "jardim maria", "232323232", cr1, c2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2));
		e3.getCidades().addAll(Arrays.asList(c3));

		cr1.getEnderecos().addAll(Arrays.asList(ed1,ed2));
		
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		estadoRepository.save(Arrays.asList(e1, e2, e3));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		clienteRepository.save(Arrays.asList(cr1));
		enderecoRepository.save(Arrays.asList(ed1,ed2));
		
	}
}
