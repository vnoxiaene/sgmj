package com.jalautopecas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalautopecas.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Veiculo findByChassi(String chassi);

}
