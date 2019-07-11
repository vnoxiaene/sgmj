package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.jalautopecas.models.Cadastro;
import com.jalautopecas.models.Produto;
import com.jalautopecas.models.Veiculo;

public class DetalhesCadastroDto {
	private Long id;
	private String vendedor;
	private LocalDateTime dataAbertura;
	private Veiculo veiculo;
	private List<Produto> produtos;
	private String observacao;

	public DetalhesCadastroDto(Cadastro cadastro) {
		this.id = cadastro.getId();
		this.vendedor = cadastro.getVendedor().getNome();
		this.dataAbertura = cadastro.getDataCriacao();
		this.observacao = cadastro.getObservacao();
		this.produtos = cadastro.getProdutos();
		this.veiculo = cadastro.getVeiculo();
	}

	public Long getId() {
		return id;
	}

	public String getVendedor() {
		return vendedor;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String getObservacao() {
		return observacao;
	}

}
