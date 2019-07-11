package com.jalautopecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jalautopecas.dtos.SugestaoDto;
import com.jalautopecas.dtos.SugestaoForm;
import com.jalautopecas.models.Sugestao;
import com.jalautopecas.services.SugestaoService;

@RestController
@RequestMapping("/sugestao")
public class SugestaoController {

	@Autowired
	private SugestaoService sugestaoService;

	@GetMapping
	public List<SugestaoDto> listar() {
		return SugestaoDto.converter(sugestaoService.listar());
	}

	@PostMapping
	public ResponseEntity<SugestaoDto> cadastrar(@RequestBody SugestaoForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Sugestao sugestao = sugestaoService.save(form.converter());
		return new ResponseEntity<>(new SugestaoDto(sugestao), HttpStatus.ACCEPTED);
	}
}
