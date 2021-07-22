package br.com.thelist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Test endpoint")
//@Api(tags = "est - swagger")
@RestController
@RequestMapping("est-service")
public class EstController {

	private Logger logger = LoggerFactory.getLogger(EstController.class);
	
	//@Retry(name="default", fallbackMethod = "fallbackMethod")
	//@CircuitBreaker(name="default", fallbackMethod = "fallbackMethod")
	//@RateLimiter(name="default")
	@Bulkhead(name="default")
	@Operation(summary = "est - openapi")
	//@ApiOperation(value = "just a test", nickname = "test")
	@GetMapping("/est")
	public String est() {
		logger.info("Requisição para '/est' recebida!");
		
	//	ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/est", String.class);
	//	return response.getBody();
		return "Est Controller !";
	}
	
	public String fallbackMethod(Exception ex) {
		return "Erro! :(";
	}
}
