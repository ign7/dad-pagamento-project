package com.example.dadpagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dadpagamento.entidades.Pagamento;
import com.example.dadpagamento.repository.PagamentoRepository;
import com.example.dadpagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService service;
	@Autowired
	PagamentoRepository repository;

	@PostMapping("/realizarpagamento/saldo={saldo}/valorfatura={valor}/data={datafatura}/status={status}")
	public ResponseEntity insert(@PathVariable float saldo, @PathVariable float valor,
			@PathVariable String datafatura, @PathVariable String status) {
		Pagamento payment = new Pagamento();
		payment.setStatus(status);
		if(saldo > valor) {
			float saldoatualizado=saldo-valor;
			payment.setData(datafatura);
			payment.setPrecoFatura(valor);
			payment.setSaldo(saldo);						
			payment.setSaldoAtualizado(saldoatualizado);
			payment=service.insert(payment);
			payment.setStatus("Pago");
			return ResponseEntity.ok().body(payment);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Saldo Indisponivel");
		
	}

}
