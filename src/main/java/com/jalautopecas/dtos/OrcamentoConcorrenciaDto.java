package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jalautopecas.models.OrcamentoConcorrencia;

import lombok.Getter;

@Getter
public class OrcamentoConcorrenciaDto {

	private String concorrente;
	private LocalDateTime dataCriacao;
	private Long id;
	private String veiculoNome;
	private String vendedorNome;
	private String observacao;

	public OrcamentoConcorrenciaDto(OrcamentoConcorrencia orcamentoConcorrencia) {
		this.concorrente = orcamentoConcorrencia.getConcorrente();
		this.dataCriacao = orcamentoConcorrencia.getDataCriacao();
		this.id = orcamentoConcorrencia.getId();
		this.veiculoNome = orcamentoConcorrencia.getVeiculo().getNome();
		this.vendedorNome = orcamentoConcorrencia.getVendedor().getNome();
		this.observacao = orcamentoConcorrencia.getObservacao();
	}

	public static List<OrcamentoConcorrenciaDto> converter(List<OrcamentoConcorrencia> orcamentos) {
		return orcamentos.stream().map(OrcamentoConcorrenciaDto::new).collect(Collectors.toList());
	}
}
