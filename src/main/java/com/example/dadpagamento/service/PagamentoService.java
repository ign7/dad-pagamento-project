package com.example.dadpagamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dadpagamento.entidades.Pagamento;
import com.example.dadpagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	
	@Autowired
	PagamentoRepository repository;
	
	
	public  List<Pagamento> findall(){
		return repository.findAll();
	}
	
	
	public Pagamento insert(Pagamento payment) {
		
		return repository.save(payment);
	}
	
	public Optional<Pagamento> findbyid(Long id) {
		Optional<Pagamento> obj= repository.findById(id);
		return obj;
	}

}
