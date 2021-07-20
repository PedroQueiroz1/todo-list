package br.com.thebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thebook.entity.TheBook;

public interface TheBookRepository extends JpaRepository<TheBook, Long>{

}
