package com.api.helpr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.Chamado;
import com.api.helpr.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

}