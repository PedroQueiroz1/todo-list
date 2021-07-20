package br.com.thelist.service;
	
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thelist.entity.TheTask;
import br.com.thelist.repository.TheTaskRepository;
	
@Service
public class TheTaskService {
	
	@Autowired
	TheTaskRepository theTaskRepository;
	
	public List<TheTask> toFindAll(){
		return theTaskRepository.findAll();
	}
	
	public Optional<TheTask> toFindById(Long id){
		return theTaskRepository.findById(id);
	}
	
}	
