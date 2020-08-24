package com.desafioCasaMagalhaes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafioCasaMagalhaes.model.ProdutoLoja;

@Repository
public interface ProdutoLojaRepository extends JpaRepository<ProdutoLoja, Integer> {

	ProdutoLoja findByProduto_IdAndLoja_Id(Integer idProduto, Integer idLoja);
	
	List<ProdutoLoja> findByLoja_Id(Integer idLoja);
	
	void deleteByProduto_IdAndLoja_Id(Integer idProduto, Integer idLoja);
}
