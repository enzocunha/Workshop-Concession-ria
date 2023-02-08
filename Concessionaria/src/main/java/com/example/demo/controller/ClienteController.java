package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.reponses.Response;
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
	
	/*POST (no post existe o validation)*/
	
	@RequestMapping(value = "/Cliente", method = RequestMethod.POST)
	public ResponseEntity<Response<Cliente>> Post(@Valid @RequestBody Cliente Cliente, BindingResult result)
    {
    	Response<Cliente> response = new Response<Cliente>();
    	
    	if(result.hasErrors())
    	{
    		result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
    		return ResponseEntity.badRequest().body(response);
    	}
    	
    	ClienteRepository.save(Cliente);
    	response.setData(Cliente);
    	return ResponseEntity.ok(response);
    }  
	
	/*PUT (No put há validation)*/
	
	@RequestMapping(value = "/Cliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Cliente>> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cliente newCliente, BindingResult result)
	{
		Optional<Cliente> oldCliente = ClienteRepository.findById(id);
		Response<Cliente> response = new Response<Cliente>();
        
        if(result.hasErrors())
        {
        	result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
        	return ResponseEntity.badRequest().body(response);
        }
        
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
			return ResponseEntity.ok(response);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	/*DELETE*/
	 @RequestMapping(value = "/Cliente/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Cliente> Cliente = ClienteRepository.findById(id);
	        if(Cliente.isPresent()){
	            ClienteRepository.delete(Cliente.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }    

}