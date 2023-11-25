package com.example.dadpagamento.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity

public class Pagamento  implements Serializable {
	Random randomGenerator = new Random();
	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long id_fatura;
	int random = randomGenerator.nextInt(1000000000);
	private String codigo="CPDS"+random+"HUHASSA-44"+random;
	private float saldo;
	private String empresa="@payment-dad";
	private Instant dataTransacao=Instant.now();
	private String data;
	private Status status;
	private float precoFatura;
	private float saldoAtualizado;
}
