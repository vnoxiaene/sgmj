package com.jalautopecas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalautopecas.models.Cotacao;
import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.CotacaoRepository;
import com.jalautopecas.repositories.ProdutoRepository;
import com.jalautopecas.repositories.VeiculoRepository;
import com.jalautopecas.repositories.VendedorRepository;

@Service
public class CotacaoService {

	private final CotacaoRepository cotacaoRepository;
	private final VendedorRepository vendedorRepository;
	private final ProdutoRepository produtoRepository;
	private final VeiculoRepository veiculoRepository;

	@Autowired
	public CotacaoService(CotacaoRepository cotacaoRepository, VendedorRepository vendedorRepository,
			ProdutoRepository produtoRepository, VeiculoRepository veiculoRepository) {
		this.cotacaoRepository = cotacaoRepository;
		this.vendedorRepository = vendedorRepository;
		this.produtoRepository = produtoRepository;
		this.veiculoRepository = veiculoRepository;
	}

	public Cotacao save(Cotacao cotacao) {
		if (vendedorRepository.findByNome(cotacao.getVendedor().getNome()) == null)
			vendedorRepository.save(cotacao.getVendedor());
		else {
			Vendedor vendedor = vendedorRepository.findByNome(cotacao.getVendedor().getNome());
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

}
