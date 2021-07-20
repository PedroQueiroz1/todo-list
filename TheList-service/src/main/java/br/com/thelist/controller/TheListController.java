package br.com.thelist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thelist.entity.TheList;
import br.com.thelist.service.TheListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "List")
@RestController
@RequestMapping("thelist-service")
public class TheListController {

	@Autowired
	private TheListService theListService;
	
	@ApiOperation(value= "To Find All")
	@GetMapping
	public List<TheList> toFindAll(){
		return theListService.toFindAll();
	}
	
	@ApiOperation(value= "To Find By Id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TheList>> toFindById(@PathVariable Long id){
		Optional<TheList> optionalContent = theListService.toFindById(id);
		return optionalContent.isPresent()?
				ResponseEntity.ok(optionalContent):ResponseEntity.notFound().build();
	}
	
	
}
