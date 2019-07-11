package com.jalautopecas.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@OneToMany
	private List<Produto> produtos;
	private String observacao;
	@ManyToOne
	private Vendedor vendedor;
	@ManyToOne
	private Veiculo veiculo;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@OneToMany
	private List<Resposta> respostas;

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cadastro(List<Produto> produtos, String observacao, Vendedor vendedor, Veiculo veiculo) {
		this.produtos = produtos;
		this.observacao = observacao;
		this.vendedor = vendedor;
		this.veiculo = veiculo;
	}

	public void adicionaProduto(Produto produto) {
		if (this.produtos.isEmpty())
			produtos = new ArrayList<>();
		produtos.add(produto);
	}

}
