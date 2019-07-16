package com.jalautopecas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalautopecas.models.Cadastro;
import com.jalautopecas.models.Resposta;
import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.CadastroRepository;
import com.jalautopecas.repositories.ProdutoRepository;
import com.jalautopecas.repositories.RespostaRepository;
import com.jalautopecas.repositories.VeiculoRepository;
import com.jalautopecas.repositories.VendedorRepository;

@Service
public class CadastroService {

	private final CadastroRepository cadastroRepository;
	private final VendedorRepository vendedorRepository;
	private final ProdutoRepository produtoRepository;
	private final VeiculoRepository veiculoRepository;
	private final RespostaRepository respostaRepository;

	@Autowired
	public CadastroService(CadastroRepository cadastroRepository, VendedorRepository vendedorRepository,
			ProdutoRepository produtoRepository, VeiculoRepository veiculoRepository,
			RespostaRepository respostaRepository) {
		this.cadastroRepository = cadastroRepository;
		this.vendedorRepository = vendedorRepository;
		this.produtoRepository = produtoRepository;
		this.veiculoRepository = veiculoRepository;
		this.respostaRepository = respostaRepository;
	}

	public List<Cadastro> listar() {
		List<Cadastro> cadastros = cadastroRepository.findAll();
		return cadastros;
	}

	public void save(Cadastro cadastro) {
		if (vendedorRepository.findByNomeContainingIgnoreCase(cadastro.getVendedor().getNome()) == null)
			vendedorRepository.save(cadastro.getVendedor());
		else {
			Vendedor vendedor = vendedorRepository.findByNomeContainingIgnoreCase(cadastro.getVendedor().getNome());
			cadastro.setVendedor(vendedor);
		}
		produtoRepository.saveAll(cadastro.getProdutos());
		veiculoRepository.save(cadastro.getVeiculo());
		cadastroRepository.save(cadastro);
	}

	public Cadastro getOne(Long id) {
		// TODO Auto-generated method stub
		return cadastroRepository.getOne(id);
	}

	public Cadastro adicionaResposta(Cadastro cadastro, Resposta resposta) {
		cadastro.adicionaResposta(resposta);
		respostaRepository.save(resposta);
		return cadastroRepository.save(cadastro);
	}

}
