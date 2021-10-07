package com.washics_18.NEXTI_Projeto.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.washics_18.NEXTI_Projeto.domain.Pedido;
import com.washics_18.NEXTI_Projeto.services.PedidoService;



@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service; //acessa a camada serviços
	
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { //ResponseEntity<?> armazena varias informações de uma resposta http para serviço rest
		
		Pedido obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
		
		
	}

}
