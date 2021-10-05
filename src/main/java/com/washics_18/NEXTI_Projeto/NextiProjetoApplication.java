package com.washics_18.NEXTI_Projeto;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.washics_18.NEXTI_Projeto.domain.Categoria;
import com.washics_18.NEXTI_Projeto.domain.Cliente;
import com.washics_18.NEXTI_Projeto.domain.ItemPedido;
import com.washics_18.NEXTI_Projeto.domain.Pedido;
import com.washics_18.NEXTI_Projeto.domain.Produto;
import com.washics_18.NEXTI_Projeto.repositores.CategoriaRepository;
import com.washics_18.NEXTI_Projeto.repositores.ProdutoRepository;


@SpringBootApplication
public class NextiProjetoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(NextiProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 = new Produto(null , "cadeira" , "Cadeira Tecton" , 1500.00 , 1);
		Produto prod2 = new Produto(null , "NoteBook" , "Lenovo" , 2000.00 , 1);
		Produto prod3 = new Produto(null , "Mouse" , "Mouse Pad" , 80.00 , 1);
		
		cat1.getProdutos().addAll(Arrays.asList(prod2 , prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod1));
		
		prod1.getCategorias().addAll(Arrays.asList(cat2));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1 , cat2));
		produtoRepository.saveAll(Arrays.asList(prod1 , prod2 , prod3));
		
	
		
		
		
		
		
	}

}
