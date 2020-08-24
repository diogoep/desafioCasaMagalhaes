package com.desafioCasaMagalhaes.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioCasaMagalhaes.model.Produto;
import com.desafioCasaMagalhaes.repository.ProdutoRepository;
import com.desafioCasaMagalhaes.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
    @Override
    public Produto findById(Integer id) {
		return produtoRepository.getOne(id);
	}
    @Override
    public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
    @Override
    public void delete(Integer id) {
    	produtoRepository.deleteById(id);
	}
}
