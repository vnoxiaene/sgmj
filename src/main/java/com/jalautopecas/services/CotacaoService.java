package com.jalautopecas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalautopecas.models.Cotacao;
import com.jalautopecas.models.Resposta;
import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.CotacaoRepository;
import com.jalautopecas.repositories.ProdutoRepository;
import com.jalautopecas.repositories.RespostaRepository;
import com.jalautopecas.repositories.VeiculoRepository;
import com.jalautopecas.repositories.VendedorRepository;

@Service
public class CotacaoService {

	private final CotacaoRepository cotacaoRepository;
	private final VendedorRepository vendedorRepository;
	private final ProdutoRepository produtoRepository;
	private final VeiculoRepository veiculoRepository;
	private final RespostaRepository respostaRepository;

	@Autowired
	public CotacaoService(CotacaoRepository cotacaoRepository, VendedorRepository vendedorRepository,
			ProdutoRepository produtoRepository, VeiculoRepository veiculoRepository,
			RespostaRepository respostaRepository) {
		this.cotacaoRepository = cotacaoRepository;
		this.vendedorRepository = vendedorRepository;
		this.produtoRepository = produtoRepository;
		this.veiculoRepository = veiculoRepository;
		this.respostaRepository = respostaRepository;
	}

	public Cotacao save(Cotacao cotacao) {
		if (vendedorRepository.findByNomeContainingIgnoreCase(cotacao.getVendedor().getNome()) == null)
			vendedorRepository.save(cotacao.getVendedor());
		else {
			Vendedor vendedor = vendedorRepository.findByNomeContainingIgnoreCase(cotacao.getVendedor().getNome());
			cotacao.setVendedor(vendedor);
		}
		produtoRepository.saveAll(cotacao.getProdutos());
		veiculoRepository.save(cotacao.getVeiculo());
		cotacaoRepository.save(cotacao);
		return cotacao;
	}

	public List<Cotacao> listar() {
		return cotacaoRepository.findAll();
	}

	public Cotacao getOne(Long id) {
		return cotacaoRepository.getOne(id);
	}

	public Cotacao adicionaResposta(Cotacao cotacao, Resposta resposta) {
		cotacao.adicionaResposta(resposta);
		respostaRepository.save(resposta);
		return cotacaoRepository.save(cotacao);
	}

}
