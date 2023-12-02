package com.example.dadpagamento.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.dadpagamento.entidades.Pagamento;

@Component
public class KafkaConsumer {

	@KafkaListener(topics="payment",groupId = "payment-groupid")
	public void consume(Pagamento payment) {
		System.out.println(payment.toString());		
	}
	
}
