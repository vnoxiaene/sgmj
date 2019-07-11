package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.jalautopecas.models.Cotacao;
import com.jalautopecas.models.Produto;
import com.jalautopecas.models.Veiculo;

import lombok.Getter;

@Getter
public class DetalhesCotacaoDto {

	private Long id;
	private String vendedor;
	private LocalDateTime dataAbertura;
	private Veiculo veiculo;
	private List<Produto> produtos;
	private String observacao;

	public DetalhesCotacaoDto(Cotacao cotacao) {
		this.id = cotacao.getId();
		this.vendedor = cotacao.getVendedor().getNome();
		this.dataAbertura = cotacao.getDataCriacao();
		this.veiculo = cotacao.getVeiculo();
		this.produtos = cotacao.getProdutos();
		this.observacao = cotacao.getObservacao();
	}
}
