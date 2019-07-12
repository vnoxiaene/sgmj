package com.jalautopecas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalautopecas.models.OrcamentoConcorrencia;
import com.jalautopecas.repositories.OrcamentoConcorrenciaRepository;
import com.jalautopecas.repositories.ProdutoRepository;
import com.jalautopecas.repositories.VeiculoRepository;
import com.jalautopecas.repositories.VendedorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrcamentoConcorrenciaService {

	private final OrcamentoConcorrenciaRepository orcamentoConcorrenciaRepository;
	private final ProdutoRepository produtoRepository;
	private final VendedorRepository vendedorRepository;
	private final VeiculoRepository veiculoRepository;

	public List<OrcamentoConcorrencia> listar() {
		return orcamentoConcorrenciaRepository.findAll();
	}

	public OrcamentoConcorrencia save(OrcamentoConcorrencia concorrencia) {
		if (vendedorRepository.findByNome(concorrencia.getVendedor().getNome()) == null)
			vendedorRepository.save(concorrencia.getVendedor());
		else {
			concorrencia.setVendedor(vendedorRepository.findByNome(concorrencia.getVendedor().getNome()));
		}
		produtoRepository.saveAll(concorrencia.getProdutos());
		veiculoRepository.save(concorrencia.getVeiculo());
		return orcamentoConcorrenciaRepository.save(concorrencia);
	}

}
