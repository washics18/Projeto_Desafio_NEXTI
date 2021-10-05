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
import com.washics_18.NEXTI_Projeto.repositores.ClienteRepository;
import com.washics_18.NEXTI_Projeto.repositores.ItemPedidoRepository;
import com.washics_18.NEXTI_Projeto.repositores.PedidoRepository;
import com.washics_18.NEXTI_Projeto.repositores.ProdutoRepository;


@SpringBootApplication
public class NextiProjetoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository  clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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
		
		Cliente cli1 = new Cliente(null , "João Pedro" , "768634221" , "30/09/1996");
		Cliente cli2 = new Cliente(null , "Elisa Souza" , "39876325" , "13/02/1990");
		Cliente cli3 = new Cliente(null , "Maria Lima" , "26459720" , "21/12/1988");
		
		clienteRepository.saveAll(Arrays.asList(cli1 , cli2 , cli3));
		
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("23/04/2021 10:32"), cli1, 1500.00 , prod1 );
		Pedido ped2 = new Pedido(null, sdf.parse("11/02/2021 18:24"), cli2, 80.00 , prod3 );
		Pedido ped3 = new Pedido(null, sdf.parse("06/07/2021 15:45"), cli3, 2000.00 , prod2 );
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli2.getPedidos().addAll(Arrays.asList(ped3));
		cli2.getPedidos().addAll(Arrays.asList(ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2 , ped3));
		
		ItemPedido itemPed1 = new ItemPedido(ped1, prod1, 1, 1500.00);
		ItemPedido itemPed2 = new ItemPedido(ped2, prod3, 1, 80.00);
		ItemPedido itemPed3 = new ItemPedido(ped3, prod2, 1, 2000.00);
		
		ped1.getItens().addAll(Arrays.asList(itemPed1));
		ped2.getItens().addAll(Arrays.asList(itemPed2));
		ped3.getItens().addAll(Arrays.asList(itemPed3));
		
		prod1.getItens().addAll(Arrays.asList(itemPed1));
		prod2.getItens().addAll(Arrays.asList(itemPed3));
		prod3.getItens().addAll(Arrays.asList(itemPed2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPed1,itemPed2,itemPed3));
		
		
		
	}

}
