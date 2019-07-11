package com.jalautopecas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalautopecas.repositories.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	VendedorRepository vendedorRepository;

}
