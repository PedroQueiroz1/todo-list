package br.com.thelist.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thelist.entity.TheList;
import br.com.thelist.service.TheListService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="List endpoint")
//@Api(tags = "TheList - swagger")
@RestController
@RequestMapping("thelist-service")
public class TheListController {

	@Autowired
	private TheListService theListService;
	
	//esse logger é pra identificar que a requisição foi recebida ao ocorrer uma falha
	private Logger logger = LoggerFactory.getLogger(TheListController.class);
	
	@Operation(summary = "Find all lists")
	//@ApiOperation(value= "To Find All", nickname="toFindAll")
	@GetMapping(value="/findAll")
	//@Retry(name="default", fallbackMethod = "fallbackMethod")
	@Bulkhead(name="default")
	public List<TheList> toFindAll(){
		logger.info("Requisição para 'thelist-service/findAll' recebida!");
		return theListService.toFindAll();
	}
	
	@Operation(summary = "Find a specific list by id")
	//@ApiOperation(value= "To Find By Id", nickname="toFindById")
	@GetMapping("/{id}")
	//@Retry(name="default", fallbackMethod = "fallbackMethod")
	@Bulkhead(name="default")
	public ResponseEntity<Optional<TheList>> toFindById(@PathVariable Long id){
		logger.info("Requisição para 'thelist-service/{id}' recebida!");
		Optional<TheList> optionalContent = theListService.toFindById(id);
		return optionalContent.isPresent()?
				ResponseEntity.ok(optionalContent):ResponseEntity.notFound().build();
	}
	
	//mensagem que vai aparecer caso ocorra falha ao encontrar a página identificada com
	//o 'fallbackMethod'
	public String fallbackMethod(Exception ex) {
		return "Erro! :(";
	}
	
	
}
