package com.jalautopecas.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jalautopecas.models.OrcamentoConcorrencia;
import com.jalautopecas.models.Produto;
import com.jalautopecas.models.Veiculo;
import com.jalautopecas.models.Vendedor;

import lombok.Setter;

@Setter
public class OrcamentoConcorrenciaForm {

	private String concorrente;
	private String observacao;
	private String produtoDescricao;
	private String produtoCodigoJal;
	private String produtoReferencia;
	private String veiculoNome;
	private String vendedorNome;
	private float produtoPreco;

	public OrcamentoConcorrencia converter() {
		List<Produto> produtos = new ArrayList<>();
		produtos.add(
				new Produto(this.produtoDescricao, this.produtoReferencia, this.produtoCodigoJal, this.produtoPreco));
		Vendedor vendedor = new Vendedor(this.vendedorNome);
		return new OrcamentoConcorrencia(produtos, this.observacao, new Veiculo(this.veiculoNome, null, null, null),
				this.concorrente, vendedor);
	}

}
