package com.api.helpr.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Cliente;
import com.api.helpr.domain.Pessoa;
import com.api.helpr.domain.dtos.ClienteDTO;
import com.api.helpr.repositories.ClienteRepository;
import com.api.helpr.repositories.PessoaRepository;
import com.api.helpr.services.exceptions.DataIntegrityViolationException;
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
		
		//Metodo que fará a criação de novo cliente
		public Cliente create(ClienteDTO objDto) {
			objDto.setId(null);
			validaCpfEEmail(objDto);
			Cliente newObj = new Cliente(objDto);
			return repository.save(newObj);
		}
		
		
		//Metodo para modificar clientes existentes.
		public Cliente update (Integer id, ClienteDTO objDto) {
			objDto.setId(id);
			Cliente oldObj = findById(id);
			validaCpfEEmail(objDto);
			oldObj = new Cliente(objDto);
			return repository.save(oldObj);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Validará os CPFS E Emails para update e create
		private void validaCpfEEmail(ClienteDTO objDto) {
			Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
			if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
				throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
			}
			obj = pessoaRepository.findByEmail(objDto.getEmail());
			if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
				throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
			}
		}
		
		
		
	


	
	
	}

	

	


	


