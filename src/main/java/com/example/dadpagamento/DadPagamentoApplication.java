package com.example.dadpagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DadPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DadPagamentoApplication.class, args);
	}

}
