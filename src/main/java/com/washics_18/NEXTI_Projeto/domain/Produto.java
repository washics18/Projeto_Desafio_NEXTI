package com.washics_18.NEXTI_Projeto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double price;
	
	
	@JsonIgnore
	@ManyToMany 
	@JoinTable(name = "PRODUTO_CATEGORIA" , // a tabela que vai ficar entre categoria e produto ,faz a relaçao entre categoria e produto de muitos pra muitos , //mapeamento da List<Categoria>
	joinColumns = @JoinColumn(name = "produto_id") , // chave estrangeira da tabela produto
	inverseJoinColumns = @JoinColumn(name = "categoria_id")) // chave estrangeira da tabela categoria
	private List<Categoria> categorias = new ArrayList<>();//relação um produto pode ter varias categorias.
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {
		
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		
		List<Pedido> lista = new ArrayList<>();
		
		for(ItemPedido itensPedido : itens){
			
			lista.add(itensPedido.getPedido());
		}
		
		return lista;
		
		
	}

	public Produto(Integer id, String nome, Double price) {
		super();
		this.id = id;
		this.nome = nome;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
