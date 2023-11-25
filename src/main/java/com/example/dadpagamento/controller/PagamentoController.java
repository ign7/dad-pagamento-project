package com.example.dadpagamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dadpagamento.entidades.Pagamento;
import com.example.dadpagamento.entidades.Status;
import com.example.dadpagamento.repository.PagamentoRepository;
import com.example.dadpagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoService service;
	@Autowired
	PagamentoRepository repository;
	
	
	@GetMapping("/todos")
	public ResponseEntity<List<Pagamento>> findAll() {
		List<Pagamento> itens = service.findall();
		return ResponseEntity.ok().body(itens);
	}

	@PostMapping("/realizarpagamento/saldo={saldo}/valorfatura={valor}/data={datafatura}/status={status}/idfatura={id_fatura}")
	public ResponseEntity insert(@PathVariable Long id_fatura,@PathVariable float saldo, @PathVariable float valor,
			@PathVariable String datafatura, @PathVariable String status) {
		
		if(saldo > valor) {
			Pagamento payment = new Pagamento();
			payment.setStatus(Status.PAGO);
			float saldoatualizado=saldo-valor;
			payment.setData(datafatura);
			payment.setId_fatura(id_fatura);
			payment.setPrecoFatura(valor);
			payment.setSaldo(saldo);						
			payment.setSaldoAtualizado(saldoatualizado);
			payment=service.insert(payment);                      
			
			return ResponseEntity.ok().body(payment);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Saldo Indisponivel");
		
	}

}
