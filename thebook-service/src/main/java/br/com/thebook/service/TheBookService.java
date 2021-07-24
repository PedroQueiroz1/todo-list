package br.com.thebook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thebook.entity.TheBook;
import br.com.thebook.repository.TheBookRepository;

@Service
public class TheBookService {

	@Autowired
	private TheBookRepository theBookRepository;
	
	public Optional<TheBook> toFindById(Long id) {
		return theBookRepository.findById(id);
	}
	
	
}
