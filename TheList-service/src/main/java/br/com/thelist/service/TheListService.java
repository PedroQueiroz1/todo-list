package br.com.thelist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thelist.entity.TheList;
import br.com.thelist.repository.TheListRepository;

@Service
public class TheListService {

	@Autowired
	private TheListRepository theListRepository;
	
	public List<TheList> toFindAll(){
		return theListRepository.findAll();
	}
	
	public Optional<TheList> toFindById( Long id) {
	return theListRepository.findById(id);
	}
	
}
