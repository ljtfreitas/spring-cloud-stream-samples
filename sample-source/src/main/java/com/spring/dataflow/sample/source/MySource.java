package com.spring.dataflow.sample.source;

import java.time.Duration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import reactor.core.publisher.Flux;

@EnableBinding(Source.class)
public class MySource {

	@StreamEmitter
	@Output(Source.OUTPUT)
	public Flux<String> send() {
		return Flux.interval(Duration.ofMillis(1000))
			.map(value -> "The value is " + value);
	}
}
