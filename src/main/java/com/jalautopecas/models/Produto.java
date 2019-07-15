package com.jalautopecas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String referencia;
	private String codigojal;
	private float preco;

	public Produto(String descricao, String referencia) {
		this.descricao = descricao;
		this.referencia = referencia;
	}

	public Produto(String descricao, String referencia, String codigojal, float preco) {
		this.descricao = descricao;
		this.referencia = referencia;
		this.codigojal = codigojal;
		this.preco = preco;
	}

}
