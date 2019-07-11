package com.jalautopecas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(orphanRemoval = true)
	private List<Cotacao> cotacoes;
	@OneToMany(orphanRemoval = true)
	private List<Cadastro> cadastros;
	@OneToMany(orphanRemoval = true)
	private List<OrcamentoConcorrencia> orcamentosConcorrencia;

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	public Vendedor(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public List<OrcamentoConcorrencia> getOrcamentosConcorrencia() {
		return orcamentosConcorrencia;
	}

	public void setOrcamentosConcorrencia(List<OrcamentoConcorrencia> orcamentosConcorrencia) {
		this.orcamentosConcorrencia = orcamentosConcorrencia;
	}

}
