package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jalautopecas.models.Sugestao;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SugestaoDto {

	private Long id;
	private LocalDateTime dataAbertura;
	private String sugestao;

	public SugestaoDto(Sugestao sugestao) {
		this.id = sugestao.getId();
		this.dataAbertura = sugestao.getDataCriacao();
		this.sugestao = sugestao.getSugestao();
	}

	public static List<SugestaoDto> converter(List<Sugestao> lista) {
		return lista.stream().map(SugestaoDto::new).collect(Collectors.toList());
	}

}
