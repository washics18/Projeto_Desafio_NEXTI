package com.washics_18.NEXTI_Projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washics_18.NEXTI_Projeto.domain.Cliente;
import com.washics_18.NEXTI_Projeto.exception.ObjectNotFoundException;
import com.washics_18.NEXTI_Projeto.repositores.ClienteRepository;



@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository cliente; 
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = cliente.findById(id);
		
				
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado : id: " + id + " , Tipo: " + Cliente.class.getName()));
		
		
		
	}

}
