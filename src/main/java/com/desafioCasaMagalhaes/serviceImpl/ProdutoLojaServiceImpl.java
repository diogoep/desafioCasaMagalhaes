package com.desafioCasaMagalhaes.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioCasaMagalhaes.model.ProdutoLoja;
import com.desafioCasaMagalhaes.repository.ProdutoLojaRepository;
import com.desafioCasaMagalhaes.service.ProdutoLojaService;

@Service
public class ProdutoLojaServiceImpl implements ProdutoLojaService {
	
	@Autowired
	private ProdutoLojaRepository produtoLojaRepository;

	@Override
	public ProdutoLoja save(ProdutoLoja produtoLoja) {
		return produtoLojaRepository.save(produtoLoja);
	}
	
    @Override
    public ProdutoLoja findById(Integer idProduto, Integer idLoja) {
		return produtoLojaRepository.findByProduto_IdAndLoja_Id(idProduto, idLoja);
	}
    
    @Override
    public List<ProdutoLoja> findByIdLoja(Integer idLoja) {
		return produtoLojaRepository.findByLoja_Id(idLoja);
	}
    
    @Override
    public List<ProdutoLoja> findAll() {
		return produtoLojaRepository.findAll();
	}
    
    @Override
    public void delete(Integer idProduto, Integer idLoja) {
    	produtoLojaRepository.deleteByProduto_IdAndLoja_Id(idProduto, idLoja);
	}
}
