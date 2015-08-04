package br.com.peedromiranda.exemploJDBC.entity;

import java.util.Date;

public class Contato {
	
	private Integer idContato;
	private String nome;
	private String telefone;
	private String email;
	private Date dataCadastro;
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", nome=" + nome
				+ ", telefone=" + telefone + ", email=" + email
				+ ", dataCadastro=" + dataCadastro + "]";
	}
	
	

}
