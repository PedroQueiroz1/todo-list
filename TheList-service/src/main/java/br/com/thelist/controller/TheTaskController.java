package br.com.thelist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thelist.entity.TheTask;
import br.com.thelist.service.TheTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Task")
@RestController
@RequestMapping("thetask-service")
public class TheTaskController {

	@Autowired
	TheTaskService theTaskService;
	
	@ApiOperation(value="To Find All")
	@GetMapping
	public List<TheTask> toFindAll(){
		return theTaskService.toFindAll();
	}
	
	@ApiOperation(value="To Find By Id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TheTask>> toFindById(@PathVariable Long id){
		Optional<TheTask> optionalContent = theTaskService.toFindById(id);
		return optionalContent.isPresent()?ResponseEntity.ok(optionalContent):
			ResponseEntity.notFound().build();
	}
	
}
