package com.example.dadpagamento.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.dadpagamento.entidades.Pagamento;


@Configuration
public class KafkaConfig {
	
	
	
	@Bean
    public KafkaTemplate<String, Pagamento> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
	
	
	@Bean
    public ConcurrentKafkaListenerContainerFactory<String,Pagamento> kafkaListenerContainerFactory() {
	     
        ConcurrentKafkaListenerContainerFactory<String, Pagamento> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        
        return factory;
    }

	@Bean
	public ConsumerFactory<String, Pagamento> consumerFactory() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "payment-groupid");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.dadpagamento.entidades");
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
	    
	    return new DefaultKafkaConsumerFactory<>(props);
	}
	
	
	
	
	
	
	@Bean
	public ProducerFactory<String, Pagamento> producerFactory() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
	    return new DefaultKafkaProducerFactory<>(props);
	}
	

}
