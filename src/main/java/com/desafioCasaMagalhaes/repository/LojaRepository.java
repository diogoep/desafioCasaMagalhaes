package com.desafioCasaMagalhaes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafioCasaMagalhaes.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {
	
}
