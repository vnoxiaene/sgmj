package com.jalautopecas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalautopecas.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
