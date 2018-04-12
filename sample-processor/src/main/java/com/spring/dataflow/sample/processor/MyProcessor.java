package com.spring.dataflow.sample.processor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

import reactor.core.publisher.Flux;

@EnableBinding(Processor.class)
public class MyProcessor {

	@StreamListener
	@Output(Processor.OUTPUT)
	public Flux<String> receive(@Input(Processor.INPUT) Flux<String> input) {
		return input.map(s -> s.toUpperCase())
				.map(s -> "Olha, mãe! Estou em maiúsculo: " + s);
	}
}
