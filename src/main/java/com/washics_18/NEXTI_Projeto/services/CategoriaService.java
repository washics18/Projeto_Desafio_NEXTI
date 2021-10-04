package com.washics_18.NEXTI_Projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washics_18.NEXTI_Projeto.domain.Categoria;
import com.washics_18.NEXTI_Projeto.exception.ObjectNotFoundException;
import com.washics_18.NEXTI_Projeto.repositores.CategoriaRepository;



@Service
public class CategoriaService {
	
	@Autowired
	public CategoriaRepository repo; 
	
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado : id: " + id + " , Tipo: " + Categoria.class.getName()));
		
		
		
	}

}
