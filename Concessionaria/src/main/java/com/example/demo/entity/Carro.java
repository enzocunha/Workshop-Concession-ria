package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Carro
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message="Informe a marca.")
    private String marca;
    
    @Column(nullable = false) 
    @NotEmpty(message="Informe o modelo.")
    private String modelo;
    
    @Column(nullable = false)
    @Min(value=1900, message="Informe um ano válido")
    private long ano;
    
    @Column(nullable = false)
    @NotEmpty(message="Informe a cor.")
    private String cor;

    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}