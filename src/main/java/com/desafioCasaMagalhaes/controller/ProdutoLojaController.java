package com.desafioCasaMagalhaes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.desafioCasaMagalhaes.model.Loja;
import com.desafioCasaMagalhaes.model.Produto;
import com.desafioCasaMagalhaes.model.ProdutoLoja;
import com.desafioCasaMagalhaes.service.LojaService;
import com.desafioCasaMagalhaes.service.ProdutoLojaService;
import com.desafioCasaMagalhaes.service.ProdutoService;

import java.util.List;

@RestController
@CrossOrigin
public class ProdutoLojaController {

    @Autowired
    private ProdutoLojaService produtoLojaService;
    
    @Autowired
    private LojaService lojaService;
    
    @Autowired
    private ProdutoService produtoService;
  
    @GetMapping("/lojas/{idLoja}/produtos/{idProduto}")
    public ResponseEntity<ProdutoLoja> findById(@PathVariable Integer idLoja, @PathVariable Integer idProduto) {
        return ResponseEntity.ok(produtoLojaService.findById(idProduto, idLoja));
    }

    @GetMapping("/lojas/{idLoja}/produtos")
    public ResponseEntity<List<ProdutoLoja>> findAll(@PathVariable Integer idLoja) {
        return ResponseEntity.ok(produtoLojaService.findByIdLoja(idLoja));
    }

    @PostMapping("/lojas/{idLoja}/produtos")
    public ResponseEntity<ProdutoLoja> create(@PathVariable Integer idLoja, @RequestBody ProdutoLoja produtoLoja){
    	Loja loja = lojaService.findById(idLoja);
    	Produto produto = produtoService.findById(produtoLoja.getProduto().getId());
    	produtoLoja.setProduto(produto);
    	produtoLoja.setLoja(loja);
        return ResponseEntity.ok(produtoLojaService.save(produtoLoja));
    }
    @Transactional
    @DeleteMapping("/lojas/{idLoja}/produtos/{idProduto}")
    public ResponseEntity<Void> delete(@PathVariable Integer idLoja, @PathVariable Integer idProduto ){
        produtoLojaService.delete(idProduto, idLoja);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/lojas/{idLoja}/produtos/{idProduto}")
    public ResponseEntity<ProdutoLoja> update(@PathVariable Integer idLoja, @RequestBody ProdutoLoja produtoLoja){
    	Loja loja = lojaService.findById(idLoja);
    	produtoLoja.setLoja(loja);
        return ResponseEntity.ok(produtoLojaService.save(produtoLoja));
    }

}
