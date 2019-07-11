package com.jalautopecas.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jalautopecas.models.Cotacao;
import com.jalautopecas.models.Produto;
import com.jalautopecas.models.Veiculo;
import com.jalautopecas.models.Vendedor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CotacaoForm {

	private String vendedorNome;
	private String observacao;
	private String veiculoChassi;
	private String produtoDescricao;
	private String produtoReferencia;
	private String veiculoModelo;
	private String veiculoNome;
	private String veiculoAno;

	public Cotacao converter() {
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(this.produtoDescricao, this.produtoReferencia));
		Vendedor vendedor = new Vendedor(this.vendedorNome);
		return new Cotacao(produtos, observacao, vendedor,
				new Veiculo(this.veiculoNome, this.veiculoChassi, this.veiculoModelo, this.veiculoAno));
	}

}
