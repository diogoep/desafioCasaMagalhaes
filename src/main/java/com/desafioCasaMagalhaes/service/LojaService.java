package com.desafioCasaMagalhaes.service;

import java.util.List;
import com.desafioCasaMagalhaes.model.Loja;

public interface LojaService {
	Loja save(Loja loja);
    Loja findById(Integer id);
    List<Loja> findAll();
    void delete(Integer id);
}
