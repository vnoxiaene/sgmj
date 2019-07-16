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
	@ManyToOne
	private Vendedor vendedor;

	public OrcamentoConcorrencia(List<Produto> produtos, String observacao, Veiculo veiculo, String concorrente,
			Vendedor vendedor) {
		this.produtos = produtos;
		this.observacao = observacao;
		this.veiculo = veiculo;
		this.concorrente = concorrente;
		this.vendedor = vendedor;
	}

	public void adicionaResposta(Resposta resposta) {
		if (this.respostas.isEmpty())
			this.respostas = new ArrayList<>();
		this.respostas.add(resposta);
	}

}
