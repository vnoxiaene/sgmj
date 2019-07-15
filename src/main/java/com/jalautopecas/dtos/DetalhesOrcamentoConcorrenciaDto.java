package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.jalautopecas.models.OrcamentoConcorrencia;
import com.jalautopecas.models.Produto;
import com.jalautopecas.models.Resposta;
import com.jalautopecas.models.Veiculo;
import com.jalautopecas.models.Vendedor;

import lombok.Getter;

@Getter
public class DetalhesOrcamentoConcorrenciaDto {

	private Long id;
	private List<Produto> produtos;
	private Veiculo veiculo;
	private Vendedor vendedor;
	private String observacao;
	private LocalDateTime dataAbertura;
	private String concorrente;
	private List<Resposta> respostas;

	public DetalhesOrcamentoConcorrenciaDto(OrcamentoConcorrencia orcamento) {
		this.id = orcamento.getId();
		this.produtos = orcamento.getProdutos();
		this.veiculo = orcamento.getVeiculo();
		this.vendedor = orcamento.getVendedor();
		this.observacao = orcamento.getObservacao();
		this.dataAbertura = orcamento.getDataCriacao();
		this.concorrente = orcamento.getConcorrente();
		this.respostas = orcamento.getRespostas();
	}

}
