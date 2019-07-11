package com.jalautopecas.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jalautopecas.models.Cadastro;
import com.jalautopecas.models.Veiculo;
import com.jalautopecas.models.Vendedor;

public class CadastroDto {

	private Long id;
	private Vendedor vendedor;
	private LocalDateTime dataAbertura;
	private Veiculo veiculo;

	public String getVeiculo() {
		return veiculo.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getVendedor() {
		return vendedor.getNome();
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public CadastroDto(Cadastro cadastro) {
		this.id = cadastro.getId();
		this.vendedor = cadastro.getVendedor();
		this.dataAbertura = cadastro.getDataCriacao();
		this.veiculo = cadastro.getVeiculo();
	}

	public static List<CadastroDto> converter(List<Cadastro> cadastros) {
		return cadastros.stream().map(CadastroDto::new).collect(Collectors.toList());
	}

}
