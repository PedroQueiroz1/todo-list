package br.com.thelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thelist.entity.TheList;

public interface TheListRepository extends JpaRepository<TheList, Long>{

}
