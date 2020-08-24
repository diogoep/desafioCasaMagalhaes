package com.desafioCasaMagalhaes.service;

import java.util.List;
import com.desafioCasaMagalhaes.model.Produto;

public interface ProdutoService {
    Produto save(Produto produto);
    Produto findById(Integer id);
    List<Produto> findAll();
    void delete(Integer id);
}
