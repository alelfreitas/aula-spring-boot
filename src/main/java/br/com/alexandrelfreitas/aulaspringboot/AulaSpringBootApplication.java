package br.com.alexandrelfreitas.aulaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AulaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaSpringBootApplication.class, args);
	}

}
