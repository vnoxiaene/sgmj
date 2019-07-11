package com.jalautopecas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalautopecas.models.Sugestao;
import com.jalautopecas.repositories.SugestaoRepository;

@Service
public class SugestaoService {

	private final SugestaoRepository repository;

	@Autowired
	public SugestaoService(SugestaoRepository repository) {
		this.repository = repository;
	}

	public List<Sugestao> listar() {
		return repository.findAll();
	}

	public Sugestao save(Sugestao sugestao) {
		return repository.save(sugestao);
	}

	public Sugestao getOne(Long id) {
		return repository.getOne(id);
	}

}
