package com.jalautopecas.dtos;

import com.jalautopecas.models.Sugestao;

import lombok.Getter;

@Getter
public class SugestaoForm {

	private String sugestao;

	public Sugestao converter() {
		return new Sugestao(this.sugestao);
	}
}
