package com.jcsm.project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;



@SpringBootApplication
public class Project1Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Project1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux<String> names = Flux.just("Juan", "Maria", "Pedro", "", "Paula")
				.doOnNext(element -> {
					if(element.isEmpty()){
						throw new RuntimeException("EMPTY_ELEMENT");
					}
					else{
						System.out.println(element);
					}
				});

		names.subscribe(element -> log.info(element), error -> log.error(error.getMessage()));
	}
}
