package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jalautopecas.models.Cotacao;

public class CotacaoDto {

	private LocalDateTime dataCriacao;
	private Long id;
	private String observacao;
	private String vendedorNome;

	public CotacaoDto(Cotacao cotacao) {
		this.dataCriacao = cotacao.getDataCriacao();
		this.id = cotacao.getId();
		this.observacao = cotacao.getObservacao();
		this.vendedorNome = cotacao.getVendedor().getNome();
	}

	public static List<CotacaoDto> converter(List<Cotacao> listar) {
		return listar.stream().map(CotacaoDto::new).collect(Collectors.toList());
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public Long getId() {
		return id;
	}

	public String getObservacao() {
		return observacao;
	}

	public String getVendedorNome() {
		return vendedorNome;
	}

}
