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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
	@OneToMany
	private List<Resposta> respostas;

	public Cadastro(List<Produto> produtos, String observacao, Vendedor vendedor, Veiculo veiculo) {
		this.produtos = produtos;
		this.observacao = observacao;
		this.vendedor = vendedor;
		this.veiculo = veiculo;
	}

	public Produto adicionaProduto(Produto produto) {
		if (this.produtos.isEmpty())
			produtos = new ArrayList<>();
		produtos.add(produto);
		return produto;
	}

	public void adicionaResposta(Resposta resposta) {
		if (this.respostas.isEmpty())
			this.respostas = new ArrayList<>();
		this.respostas.add(resposta);
	}

}
