package com.washics_18.NEXTI_Projeto.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washics_18.NEXTI_Projeto.domain.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	 //JpaRepository acessar os dados do tipo que for passado ex: Categoria
	 // CategoriaRepository realizar operações acessos a dados buscar , deletar , salvar , alterar. Objeto Categoria mapeado pela tabela categoria 

}