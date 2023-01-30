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

@RestController
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;

    @RequestMapping(value = "/carro", method = RequestMethod.GET)
    public List<Carro> Get() {
        return carroRepository.findAll();
    }
    
    @RequestMapping(value = "/carro/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carro> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent())
            return new ResponseEntity<Carro>(carro.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @RequestMapping(value = "/carro", method =  RequestMethod.POST)
    public Carro Post(@RequestBody Carro carro)
    {
        return carroRepository.save(carro);
    }    
    
//    @RequestMapping(value = "/carro/{id}", method =  RequestMethod.PUT)
//    public ResponseEntity<Carro> Put(@PathVariable(value = "id") long id, @RequestBody Carro newCarro)
//    {
//        Optional<Carro> oldCarro = carroRepository.findById(id);
//        if(oldCarro.isPresent()){
//            Carro carro = oldCarro.get();
//            carro.setAno(newCarro.getAno());
//            carro.setCor(newCarro.getCor());
//            carro.setMarca(newCarro.getMarca());
//            carro.setModelo(newCarro.getModelo());
//            carroRepository.save(carro);
//            return new ResponseEntity<Carro>(carro, HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    } 
    
    @RequestMapping(value = "/carro/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Carro> Put(@PathVariable(value = "id") long id, @RequestBody Carro newCarro)
    {
        Optional<Carro> oldCarro = carroRepository.findById(id);
        if(oldCarro.isPresent()){
            Carro carro = oldCarro.get();
            carro.setAno(newCarro.getAno());
            carro.setCor(newCarro.getCor());
            carro.setMarca(newCarro.getMarca());
            carro.setModelo(newCarro.getModelo());
            carroRepository.save(carro);
            return new ResponseEntity<Carro>(carro, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/carro/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            carroRepository.delete(carro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }    
    
}	