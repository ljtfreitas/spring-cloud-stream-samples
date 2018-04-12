package com.spring.dataflow.sample.source;

import java.time.Duration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import com.fasterxml.jackson.annotation.JsonProperty;

import reactor.core.publisher.Flux;

@EnableBinding(Source.class)
public class MySource {

	@StreamEmitter
	@Output(Source.OUTPUT)
	public Flux<Person> send() {
		return Flux.interval(Duration.ofMillis(1000))
			.map(s -> new Person("Fulano " + s, 32));
	}
	
	private class Person {
		
		@JsonProperty
		String name;
		
		@JsonProperty
		int age;

		Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
	}
}
