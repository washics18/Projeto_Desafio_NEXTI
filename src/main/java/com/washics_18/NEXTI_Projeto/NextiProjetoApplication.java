package com.washics_18.NEXTI_Projeto;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.washics_18.NEXTI_Projeto.domain.Categoria;
import com.washics_18.NEXTI_Projeto.domain.Cidade;
import com.washics_18.NEXTI_Projeto.domain.Cliente;
import com.washics_18.NEXTI_Projeto.domain.Endereco;
import com.washics_18.NEXTI_Projeto.domain.Estado;
import com.washics_18.NEXTI_Projeto.domain.ItemPedido;
import com.washics_18.NEXTI_Projeto.domain.Pedido;
import com.washics_18.NEXTI_Projeto.domain.Produto;
import com.washics_18.NEXTI_Projeto.repositores.CategoriaRepository;
import com.washics_18.NEXTI_Projeto.repositores.CidadeRepository;
import com.washics_18.NEXTI_Projeto.repositores.ClienteRepository;
import com.washics_18.NEXTI_Projeto.repositores.EnderecoRepository;
import com.washics_18.NEXTI_Projeto.repositores.EstadoRepository;
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
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository  clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
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
		
		Produto produto1 = new Produto(null, "Computador" , 2000.00);
		Produto produto2 = new Produto(null, "Impressora" , 800.00);
		Produto produto3 = new Produto(null, "Mouse" , 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(cat1));
		produto2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		produto3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
		
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Urberlândia" , estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo" , estado2);
		Cidade cidade3 = new Cidade(null, "Campinas" , estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Cliente cliente1 = new Cliente(null , "Maria Silva" , "07/05/2000" , "345678750-12");
		Cliente cliente2 = new Cliente(null , "João Pedro" , "23/11/2001" , "040872110-45");
		
		cliente1.getTelefones().addAll(Arrays.asList("(41) 27363342" , "(41) 93836785"));
		cliente2.getTelefones().addAll(Arrays.asList("(11) 30224570" , "(11) 92778902"));
		
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "234588-678", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro" , "67845-432" , cliente2 , cidade2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1));
		cliente2.getEnderecos().addAll(Arrays.asList(endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente2, endereco2);
		
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1));
		cliente2.getPedidos().addAll(Arrays.asList(pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		
		ItemPedido iTemPedido1 = new ItemPedido(pedido1, produto1, 0.00, 1, 200.00);
		ItemPedido iTemPedido2 = new ItemPedido(pedido1, produto3, 0.00, 2, 80.00);
		ItemPedido iTemPedido3 = new ItemPedido(pedido2, produto2, 100.00, 1, 800.00);
		
		pedido1.getItens().addAll(Arrays.asList(iTemPedido1,iTemPedido2));
		pedido2.getItens().addAll(Arrays.asList(iTemPedido3));
		
		produto1.getItens().addAll(Arrays.asList(iTemPedido1));
		produto2.getItens().addAll(Arrays.asList(iTemPedido3));
		produto3.getItens().addAll(Arrays.asList(iTemPedido2));
		
		
		itemPedidoRepository.saveAll(Arrays.asList(iTemPedido1,iTemPedido2,iTemPedido3));
		
		
		
		
		
		
	}

}