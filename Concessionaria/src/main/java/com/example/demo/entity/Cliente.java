package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente
/*Os campos não obrigatórios são cnh e email*/
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "O CPF do cliente deve ser informado")
    @CPF(message = "CPF inválido")
    private String cpf;
    
    @Column(nullable = false)
    @NotEmpty(message = "O nome do cliente deve ser informado")
    @Length(min = 5, max = 100, message = "O nome deverá ter entre 5 e 100 caracteres")
    private String nome;
    
    @Column(nullable = false)
    @NotNull(message = "A data de nascimento do cliente deve ser informado")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_nasc;
     
    
    @Column(nullable = false)
    @NotEmpty(message = "O cep do cliente deve ser informado")
    @Length(min = 9, max = 9, message = "Deve seguir o seguinte formato XXXX-XXX")
    private String cep;
   
    
    @Column(nullable = false)
    @NotEmpty(message = "O telefone do cliente deve ser informado")
    @Length(min = 14 , max = 14, message = "Deve seguir o formato (XX)XXXXX-XXXX")
    private String telefone;

    
	@Column
    private char sexo;
	
	@Column
	private String cnh;
	  
    @Column
    @Email(message = "E-mail inválido")
    private String email;
    /* Métodos GET e SET*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
    
	
}