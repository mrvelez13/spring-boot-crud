package com.accenture.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.api.entity.Cliente;
import com.accenture.api.service.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PutMapping("/clientes")
	@ResponseStatus( code = HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente) {
		Cliente clienteToUpdate = clienteService.findById(cliente.getId());
		clienteToUpdate.setNombre( cliente.getNombre() );
		clienteToUpdate.setApellido( cliente.getApellido() );
		clienteToUpdate.setEmail( cliente.getEmail() );
		
		return clienteService.save(clienteToUpdate);		
	}
	
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);		
	}

}
