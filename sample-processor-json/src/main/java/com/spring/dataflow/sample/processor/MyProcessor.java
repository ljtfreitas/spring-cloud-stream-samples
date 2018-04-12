package com.spring.dataflow.sample.processor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

import com.fasterxml.jackson.annotation.JsonProperty;

import reactor.core.publisher.Flux;

@EnableBinding(Processor.class)
public class MyProcessor {

	@StreamListener
	@Output(Processor.OUTPUT)
	public Flux<String> receive(@Input(Processor.INPUT) Flux<Person> input) {
		return input.map(Person::toString).log();
	}
	
	private static class Person {
		
		@JsonProperty
		String name;
		
		@JsonProperty
		int age;

		@Override
		public String toString() {
			return "Person is " + name + " and your age is " + age;
		}
	}
}
