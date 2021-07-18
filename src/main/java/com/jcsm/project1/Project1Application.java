package com.jcsm.project1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux<String> names = Flux.just("Juan", "Maria", "Pedro", "Paula")
				.doOnNext(System.out::println);

		names.subscribe();
	}
}
