package com.desafioCasaMagalhaes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafioCasaMagalhaes.model.Produto;
import com.desafioCasaMagalhaes.service.ProdutoService;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
  
    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> findById(@PathVariable Integer idProduto) {
        return ResponseEntity.ok(produtoService.findById(idProduto));
    }

    @GetMapping("")
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> delete(@PathVariable Integer idProduto){
        produtoService.delete(idProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.save(produto));
    }

}
