package com.desafioCasaMagalhaes.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioCasaMagalhaes.model.Loja;
import com.desafioCasaMagalhaes.repository.LojaRepository;
import com.desafioCasaMagalhaes.service.LojaService;

@Service
public class LojaServiceImpl implements LojaService {
	@Autowired
	private LojaRepository lojaRepository;

	@Override
	public Loja save(Loja loja) {
		return lojaRepository.save(loja);
	}
    @Override
    public Loja findById(Integer id) {
		return lojaRepository.getOne(id);
	}
    @Override
    public List<Loja> findAll() {
		return lojaRepository.findAll();
	}
    @Override
    public void delete(Integer id) {
    	lojaRepository.deleteById(id);
	}
}
