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

import com.jalautopecas.dtos.DetalhesOrcamentoConcorrenciaDto;
import com.jalautopecas.dtos.OrcamentoConcorrenciaDto;
import com.jalautopecas.dtos.OrcamentoConcorrenciaForm;
import com.jalautopecas.models.OrcamentoConcorrencia;
import com.jalautopecas.services.OrcamentoConcorrenciaService;

@RequestMapping("/concorrentes")
@RestController
public class OrcamentoConcorrenciaController {

	@Autowired
	private OrcamentoConcorrenciaService service;

	@GetMapping
	public List<OrcamentoConcorrenciaDto> listar() {
		return OrcamentoConcorrenciaDto.converter(service.listar());
	}

	@PostMapping
	public ResponseEntity<OrcamentoConcorrenciaDto> cadastrar(@RequestBody OrcamentoConcorrenciaForm form,
			UriComponentsBuilder uriComponentsBuilder) {
		OrcamentoConcorrencia concorrencia = service.save(form.converter());
		return new ResponseEntity<>(new OrcamentoConcorrenciaDto(concorrencia), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public DetalhesOrcamentoConcorrenciaDto detalhar(@PathVariable Long id) {
		OrcamentoConcorrencia concorrencia = service.getOne(id);
		return new DetalhesOrcamentoConcorrenciaDto(concorrencia);
	}
}
