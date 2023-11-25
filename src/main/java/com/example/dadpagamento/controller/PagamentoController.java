package com.example.dadpagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dadpagamento.repository.PagamentoRepository;
import com.example.dadpagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService service;
	@Autowired
	PagamentoRepository repository;

}
