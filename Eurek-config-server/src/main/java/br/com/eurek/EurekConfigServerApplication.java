package br.com.eurek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekConfigServerApplication.class, args);
	}

}
