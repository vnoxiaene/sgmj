package com.jalautopecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jalautopecas.dtos.CotacaoDto;
import com.jalautopecas.dtos.CotacaoForm;
import com.jalautopecas.dtos.DetalhesCotacaoDto;
import com.jalautopecas.dtos.RespostaForm;
import com.jalautopecas.models.Cotacao;
import com.jalautopecas.models.Resposta;
import com.jalautopecas.services.CotacaoService;

@RestController
@RequestMapping("/cotacoes")
public class CotacaoController {

	@Autowired
	private CotacaoService cotacaoService;

	@GetMapping
	public List<CotacaoDto> lista() {
		return CotacaoDto.converter(cotacaoService.listar());
	}

	@PostMapping
	public ResponseEntity<CotacaoDto> cadastrar(@RequestBody CotacaoForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Cotacao cotacao = cotacaoService.save(form.converter());
		return new ResponseEntity<>(new CotacaoDto(cotacao), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public DetalhesCotacaoDto detalhar(@PathVariable Long id) {
		Cotacao cotacao = cotacaoService.getOne(id);
		return new DetalhesCotacaoDto(cotacao);
	}

	@PostMapping("/responder/{id}")
	public ResponseEntity<DetalhesCotacaoDto> responder(@PathVariable Long id, @RequestBody RespostaForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Resposta resposta = form.converter();
		Cotacao cotacao = cotacaoService.getOne(id);
		cotacaoService.adicionaResposta(cotacao, resposta);
		return new ResponseEntity<>(new DetalhesCotacaoDto(cotacao), HttpStatus.ACCEPTED);
	}
}
