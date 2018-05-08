package com.example.selecao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("entidades")
@ComponentScan("controller")
@EnableJpaRepositories("dao")
public class SelecaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelecaoApplication.class, args);
	}
}
