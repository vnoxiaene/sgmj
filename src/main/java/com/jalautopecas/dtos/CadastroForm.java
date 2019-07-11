package com.jalautopecas.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jalautopecas.models.Cadastro;
import com.jalautopecas.models.Produto;
import com.jalautopecas.models.Veiculo;
import com.jalautopecas.models.Vendedor;

public class CadastroForm {

	private String vendedorNome;
	private String observacao;
	private String veiculoChassi;
	private String produtoDescricao;
	private String produtoReferencia;
	private String veiculoModelo;
	private String veiculoNome;
	private String veiculoAno;

	public String getVendedorNome() {
		return vendedorNome;
	}

	public void setVendedorNome(String vendedorNome) {
		this.vendedorNome = vendedorNome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getVeiculoChassi() {
		return veiculoChassi;
	}

	public void setVeiculoChassi(String veiculoChassi) {
		this.veiculoChassi = veiculoChassi;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public String getProdutoReferencia() {
		return produtoReferencia;
	}

	public void setProdutoReferencia(String produtoReferencia) {
		this.produtoReferencia = produtoReferencia;
	}

	public String getVeiculoModelo() {
		return veiculoModelo;
	}

	public void setVeiculoModelo(String veiculoModelo) {
		this.veiculoModelo = veiculoModelo;
	}

	public String getVeiculoNome() {
		return veiculoNome;
	}

	public void setVeiculoNome(String veiculoNome) {
		this.veiculoNome = veiculoNome;
	}

	public String getVeiculoAno() {
		return veiculoAno;
	}

	public void setVeiculoAno(String veiculoAno) {
		this.veiculoAno = veiculoAno;
	}

	public Cadastro converter() {
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(this.produtoDescricao, this.produtoReferencia));
		Vendedor vendedor = new Vendedor(this.vendedorNome);
		return new Cadastro(produtos, observacao, vendedor,
				new Veiculo(this.veiculoNome, this.veiculoChassi, this.veiculoModelo, this.veiculoAno));
	}
}
