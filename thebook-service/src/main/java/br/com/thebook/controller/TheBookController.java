package br.com.thebook.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thebook.entity.TheBook;
import br.com.thebook.service.TheBookService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

//@Api(tags = "thebook-service API")
@Tag(name = "Book endpoint")
@RestController
@RequestMapping("thebook-service")
public class TheBookController {
	
//	@Autowired
//	private Environment environment;
	
	@Autowired
	private TheBookService theBookService;
	
	private Logger logger = LoggerFactory.getLogger(TheBookController.class);

	
	//@ApiOperation(value="Find By Id", nickname= "toFindById")
	//@Retry(name="default", fallbackMethod = "fallbackMethod")
	@GetMapping(value="/{id}")
	@Operation(summary = "Find a specific 'message' by id")
	@Bulkhead(name="default")
	public ResponseEntity<Optional<TheBook>> toFindById(
			@PathVariable("id") Long id) {
		logger.info("Requisição para '/thebook-service/{id}' recebida!!");
		Optional<TheBook> book = theBookService.toFindById(id);
		
		return book.isPresent()?ResponseEntity.ok(book):
			ResponseEntity.notFound().build();
	}
	
	public String fallbackMethod(Exception ex) {
		return "Erro!! :(";
	}
}
