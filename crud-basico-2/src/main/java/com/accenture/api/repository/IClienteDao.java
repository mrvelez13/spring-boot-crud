package com.accenture.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.accenture.api.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
