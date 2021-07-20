package br.com.thelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TheListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheListServiceApplication.class, args);
	}

}
