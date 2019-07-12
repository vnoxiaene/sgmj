package com.jalautopecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalautopecas.services.OrcamentoConcorrenciaService;

@RequestMapping("/concorrentes")
@RestController
public class OrcamentoConcorrenciaController {

	@Autowired
	private OrcamentoConcorrenciaService service;

}
