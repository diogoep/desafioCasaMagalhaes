package com.desafioCasaMagalhaes.service;

import java.util.List;
import com.desafioCasaMagalhaes.model.ProdutoLoja;

public interface ProdutoLojaService {
	ProdutoLoja save(ProdutoLoja produtoLoja);
	ProdutoLoja findById(Integer idProduto, Integer idLoja);
	List<ProdutoLoja> findByIdLoja(Integer idLoja);
    List<ProdutoLoja> findAll();
    void delete(Integer idProduto, Integer idLoja);
}
