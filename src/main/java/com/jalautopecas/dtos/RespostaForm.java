package com.jalautopecas.dtos;

import com.jalautopecas.models.Resposta;

import lombok.Getter;

@Getter
public class RespostaForm {

	private String descricao;

	public Resposta converter() {
		return new Resposta(descricao);
	}
}
