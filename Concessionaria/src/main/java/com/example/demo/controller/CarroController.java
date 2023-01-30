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

import com.example.demo.entity.Carro;
import com.example.demo.repository.CarroRepository;

// A anotação @RestController permite definir um controller com características API REST;
@RestController
public class CarroController {
	// A anotação @Autowired delega ao Spring Boot a inicialização do objeto;
    @Autowired
    private CarroRepository carroRepository;
    // A anotação @RequestMapping permite definir uma rota
    @RequestMapping(value = "/carro", method = RequestMethod.GET)
    public List<Carro> Get() {
        return carroRepository.findAll();
    }
    
    // @PathVariable indica que o valor da variável virá de uma informação da rota;
    @RequestMapping(value = "/carro/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carro> GetById(@PathVariable(value = "id") long id)
    {
    	// https://docs.oracle.com/javase/9/docs/api/java/util/Optional.html (desde v 1.8)
    	// findById espera um retorno do tipo Optional<Pessoa>
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent())
            return new ResponseEntity<Carro>(carro.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    // @RequestBody indica que o valor do objeto virá do corpo da requisição e 
    //              consegue mapear os dados vindos em Json para os atributos da classe;
    @RequestMapping(value = "/carro", method =  RequestMethod.POST)
    public Carro Post(@RequestBody Carro carro)
    {
        return carroRepository.save(carro);
    }    
//    
//    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
//    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @RequestBody Pessoa newPessoa)
//    {
//        Optional<Pessoa> oldPessoa = carroRepository.findById(id);
//        if(oldPessoa.isPresent()){
//            Pessoa pessoa = oldPessoa.get();
//            pessoa.setNome(newPessoa.getNome());
//            carroRepository.save(pessoa);
//            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }    
//    
//    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
//    {
//        Optional<Pessoa> pessoa = carroRepository.findById(id);
//        if(pessoa.isPresent()){
//            carroRepository.delete(pessoa.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }    
    
}	