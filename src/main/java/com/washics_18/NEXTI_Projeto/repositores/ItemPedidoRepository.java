package com.washics_18.NEXTI_Projeto.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washics_18.NEXTI_Projeto.domain.ItemPedido;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
