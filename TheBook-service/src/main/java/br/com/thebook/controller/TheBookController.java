package br.com.thebook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thebook.entity.TheBook;
import br.com.thebook.service.TheBookService;

@RestController
@RequestMapping("thebook-service")
public class TheBookController {
	
//	@Autowired
//	private Environment environment;
	
	@Autowired
	private TheBookService theBookService;

	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<TheBook>> toFindById(
			@PathVariable("id") Long id,
			String justAMessage) {
		
		Optional<TheBook> book = theBookService.toFindById(id);
		
		return book.isPresent()?ResponseEntity.ok(book):
			ResponseEntity.notFound().build();
	}
	
}
