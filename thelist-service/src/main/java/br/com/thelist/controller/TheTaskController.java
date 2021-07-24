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

import br.com.thelist.entity.TheTask;
import br.com.thelist.service.TheTaskService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Task - endpoint")
//@Api(tags = "TheTask - swagger")
@RestController
@RequestMapping("thetask-service")
public class TheTaskController {

	private Logger logger = LoggerFactory.getLogger(TheTaskController.class);
	
	@Autowired
	TheTaskService theTaskService;
	
	@Operation(summary = "Find all tasks")
	//@ApiOperation(value="To Find All - swagger", nickname="toFindAll")
	@GetMapping(value="/findAll")
	//@Retry(name="default",fallbackMethod = "fallbackMethod")
	@Bulkhead(name="default")
	public List<TheTask> toFindAll(){
		logger.info("Requisição para 'thetask-service/findAll' recebida!");
		return theTaskService.toFindAll();
	}
	
	@Operation(summary = "Find a specific task by id")
	//@ApiOperation(value="To Find By Id - swagger", nickname="toFindById")
	@GetMapping("/{id}")
	//@Retry(name="default",fallbackMethod = "fallbackMethod")
	@Bulkhead(name="default")
	//@CircuitBreaker(name="default", fallbackMethod = "fallbackMethod")
	public ResponseEntity<Optional<TheTask>> toFindById(@PathVariable Long id){
		logger.info("Requisição para 'thetask-service/{id}' recebida!");
		Optional<TheTask> optionalContent = theTaskService.toFindById(id);
		return optionalContent.isPresent()?ResponseEntity.ok(optionalContent):
			ResponseEntity.notFound().build();
	}
	
	public String fallbackMethod(Exception ex) {
		return "Erro! :(";
	}
	
}
