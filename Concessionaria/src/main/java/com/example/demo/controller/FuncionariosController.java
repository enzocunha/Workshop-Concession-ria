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

import com.example.demo.entity.Carro;
import com.example.demo.entity.Funcionarios;
import com.example.demo.reponses.Response;
import com.example.demo.repository.FuncionariosRepository;

@RestController
public class FuncionariosController {
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
    public List<Funcionarios> Get() {
        return funcionariosRepository.findAll();
    }
    
    @RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionarios> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Funcionarios> Funcionarios = funcionariosRepository.findById(id);
        if(Funcionarios.isPresent())
            return new ResponseEntity<Funcionarios>(Funcionarios.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @RequestMapping(value = "/funcionarios", method =  RequestMethod.POST)
    public ResponseEntity<Response<Funcionarios>> Post(@Valid @RequestBody Funcionarios funcionarios, BindingResult result)
    {
    	Response<Funcionarios> response = new Response<Funcionarios>();
    	
    	if(result.hasErrors())
    	{
    		result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
    		return ResponseEntity.badRequest().body(response);
    	}
    	funcionariosRepository.save(funcionarios);
    	response.setData(funcionarios);
    	return ResponseEntity.ok(response);
    }    

    @RequestMapping(value = "/funcionarios/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Response<Funcionarios>> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Funcionarios newFuncionarios, BindingResult result)
    {
        Optional<Funcionarios> oldFuncionarios = funcionariosRepository.findById(id);
        Response<Funcionarios> response = new Response<Funcionarios>();
        
        if(result.hasErrors())
        {
        	result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
        	return ResponseEntity.badRequest().body(response);
        }
        
        if(oldFuncionarios.isPresent()){
            Funcionarios Funcionarios = oldFuncionarios.get();
            Funcionarios.setCpf(newFuncionarios.getCpf());
            Funcionarios.setNome(newFuncionarios.getNome());
            Funcionarios.setData_nasc(newFuncionarios.getData_nasc());
            Funcionarios.setCargo(newFuncionarios.getCargo());
            Funcionarios.setCep(newFuncionarios.getCep());
            Funcionarios.setData_contratacao(newFuncionarios.getData_contratacao());
            Funcionarios.setData_demissao(newFuncionarios.getData_demissao());
            Funcionarios.setTelefone(newFuncionarios.getTelefone());
            Funcionarios.setSupervisor(newFuncionarios.getSupervisor());
            Funcionarios.setSalario(newFuncionarios.getSalario());
            Funcionarios.setSexo(newFuncionarios.getSexo());
            Funcionarios.setPis(newFuncionarios.getPis());
            Funcionarios.setEmail(newFuncionarios.getEmail());
            funcionariosRepository.save(Funcionarios);
            return ResponseEntity.ok(response);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}	