package com.api.helpr.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Cliente;

import com.api.helpr.repositories.ClienteRepository;
import com.api.helpr.repositories.PessoaRepository;
import com.api.helpr.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	//Vinculo com repositório.
	@Autowired 
	private ClienteRepository repository;
	
	//Vinculo com repositorio de pessoa.
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	//Metodo de busca por um Id no banco
		public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
	}
		
		//Metodo de busca por todos os clientes
		public List<Cliente> findAllClientes(){
			return repository.findAll();
		}
	


	
	
	}

	

	


	


