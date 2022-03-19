package com.desafiocartas.Desafio.Cartas;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioCartasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCartasApplication.class, args);
	}

}
