package br.com.thelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thelist.entity.TheTask;

public interface TheTaskRepository extends JpaRepository<TheTask, Long>{

}
