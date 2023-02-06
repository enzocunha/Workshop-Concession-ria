package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

@RestController
public class ClienteController {
	@Autowired
	private ClienteRepository ClienteRepository;
	
	/*GET*/
	
	@RequestMapping(value = "/Cliente", method = RequestMethod.GET)
	public List<Cliente> Get() {
		return ClienteRepository.findAll();
	}

	@RequestMapping(value = "/Cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") long id) {
		Optional<Cliente> Cliente = ClienteRepository.findById(id);
		if (Cliente.isPresent())
			return new ResponseEntity<Cliente>(Cliente.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*POST*/
	
	@RequestMapping(value = "/Cliente", method = RequestMethod.POST)
	public Cliente Post(@RequestBody Cliente Cliente) {
		return ClienteRepository.save(Cliente);
	}
	
	/*PUT*/
	
	@RequestMapping(value = "/Cliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @RequestBody Cliente newCliente) {
		Optional<Cliente> oldCliente = ClienteRepository.findById(id);
		if (oldCliente.isPresent()) {
			Cliente Cliente = oldCliente.get();
			Cliente.setCpf(newCliente.getCpf());
			Cliente.setNome(newCliente.getNome());
			Cliente.setData_nasc(newCliente.getData_nasc());
			Cliente.setCep(newCliente.getCep());
			Cliente.setTelefone(newCliente.getTelefone());
			Cliente.setSexo(newCliente.getSexo());
			Cliente.setEmail(newCliente.getEmail());
			Cliente.setCnh(newCliente.getCnh());
			ClienteRepository.save(Cliente);
			return new ResponseEntity<Cliente>(Cliente, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}