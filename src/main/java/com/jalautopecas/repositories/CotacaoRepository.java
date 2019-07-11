package com.jalautopecas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalautopecas.models.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

}
