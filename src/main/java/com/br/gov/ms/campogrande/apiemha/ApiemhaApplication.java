package com.br.gov.ms.campogrande.apiemha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiemhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiemhaApplication.class, args);
	}

}
