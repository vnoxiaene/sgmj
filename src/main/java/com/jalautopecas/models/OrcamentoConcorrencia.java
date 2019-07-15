package com.jalautopecas.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class OrcamentoConcorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@OneToMany
	private List<Produto> produtos;
	private String observacao;
	@OneToMany
	private List<Resposta> respostas;
	@ManyToOne
	private Veiculo veiculo;
	private String concorrente;
	private Vendedor vendedor;

	public OrcamentoConcorrencia(List<Produto> produtos, String observacao, Veiculo veiculo, String concorrente,
			Vendedor vendedor) {
		this.produtos = produtos;
		this.observacao = observacao;
		this.veiculo = veiculo;
		this.concorrente = concorrente;
		this.vendedor = vendedor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public String getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(String concorrente) {
		this.concorrente = concorrente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
