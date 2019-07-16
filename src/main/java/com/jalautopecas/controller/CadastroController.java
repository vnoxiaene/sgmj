package com.jalautopecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jalautopecas.dtos.CadastroDto;
import com.jalautopecas.dtos.CadastroForm;
import com.jalautopecas.dtos.DetalhesCadastroDto;
import com.jalautopecas.dtos.RespostaForm;
import com.jalautopecas.models.Cadastro;
import com.jalautopecas.models.Resposta;
import com.jalautopecas.services.CadastroService;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

	@Autowired
	private CadastroService cadastroService;

	@GetMapping
	public List<CadastroDto> lista() {
		return CadastroDto.converter(cadastroService.listar());
	}

	@PostMapping
	public ResponseEntity<CadastroDto> cadastrar(@RequestBody CadastroForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Cadastro cadastro = form.converter();
		cadastroService.save(cadastro);
		return new ResponseEntity<>(new CadastroDto(cadastro), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public DetalhesCadastroDto detalhar(@PathVariable Long id) {
		Cadastro cadastro = cadastroService.getOne(id);
		return new DetalhesCadastroDto(cadastro);
	}

	@Secured("ROLE_COMPRAS")
	@PostMapping("/responder/{id}")
	public ResponseEntity<CadastroDto> responder(@PathVariable Long id, @RequestBody RespostaForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		Resposta resposta = form.converter();
		Cadastro cadastro = cadastroService.getOne(id);
		cadastroService.adicionaResposta(cadastro, resposta);
		return new ResponseEntity<>(new CadastroDto(cadastro), HttpStatus.ACCEPTED);
	}

}
