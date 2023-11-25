package com.example.dadpagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dadpagamento.entidades.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
