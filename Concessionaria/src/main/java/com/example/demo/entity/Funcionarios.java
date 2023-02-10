package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Funcionarios
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "O CPF do funcionário deve ser informado.")
    @CPF(message = "CPF inválido")
    private String cpf;
    
    @Column(nullable = false)
    @NotEmpty(message = "O nome do funcionário deve ser informado")
    @Length(min = 5, max = 100, message = "O nome deverá ter entre 5 e 200 caracteres")
    private String nome;
    
    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "A data de nascimento do funcionário deve ser informado")
    private Date data_nasc;
    
    @Column(nullable = false)
    @NotNull(message = "O cargo do funcionário deve ser informado.")
    private String cargo;
    
    @Column(nullable = false)
    @NotEmpty(message = "O cep do funcionário deve ser informado")
    @Length(min = 9, max = 9, message = "Deve seguir o seguinte formato XXXX-XXX")
    private String cep;
    
    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "A data de contratação do funcionário deve ser informado")
    private Date data_contratacao;
    
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_demissao;
    
    @Column(nullable = false)
    @Length(min = 14 , max = 14, message = "Deve seguir o formato (XX)XXXXX-XXXX")
    private String telefone;
    
    @Column(nullable = false)
    @NotNull(message = "O nome do supervisor deve ser informado.")
    private String supervisor;
    
    @Column(nullable = false)
    @NotNull(message = "O salário do funcionário deve ser informado.")
    private Double salario;
    
    public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Column(nullable = false)
    private String sexo;
    
    @Column(nullable = false)
    private String pis;
    
    @Column
    private String email;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getData_contratacao() {
		return data_contratacao;
	}

	public void setData_contratacao(Date data_contratacao) {
		this.data_contratacao = data_contratacao;
	}

	public Date getData_demissao() {
		return data_demissao;
	}

	public void setData_demissao(Date data_demissao) {
		this.data_demissao = data_demissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public Double getSalario() {
		return salario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}