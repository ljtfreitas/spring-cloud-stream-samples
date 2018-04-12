package com.spring.dataflow.sample.sink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import reactor.core.publisher.Flux;

@EnableBinding(Sink.class)
public class MySink {

	private static final Logger log = LoggerFactory.getLogger(MySink.class);

	@StreamListener
	public void sink(@Input(Sink.INPUT) Flux<String> input) {
		input.subscribe(s -> log.info("The message is: {}", s));
	}
}
