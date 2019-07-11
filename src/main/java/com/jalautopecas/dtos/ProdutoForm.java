package com.jalautopecas.dtos;

import com.jalautopecas.models.Produto;

import lombok.Getter;

@Getter

public class ProdutoForm {

	private String descricao;
	private String referencia;

	public Produto converter() {
		return new Produto(descricao, referencia);
	}

}
