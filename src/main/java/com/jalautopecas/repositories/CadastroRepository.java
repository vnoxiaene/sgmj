package com.jalautopecas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalautopecas.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	List<Cadastro> findByVendedorNome(String nomeVendedor);
}
