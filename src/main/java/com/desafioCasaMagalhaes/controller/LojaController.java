package com.desafioCasaMagalhaes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafioCasaMagalhaes.model.Loja;
import com.desafioCasaMagalhaes.service.LojaService;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;
  
    @GetMapping("/{idLoja}")
    public ResponseEntity<Loja> findById(@PathVariable Integer idLoja) {
        return ResponseEntity.ok(lojaService.findById(idLoja));
    }

    @GetMapping("")
    public ResponseEntity<List<Loja>> findAll() {
        return ResponseEntity.ok(lojaService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Loja> create(@RequestBody Loja loja){
        return ResponseEntity.ok(lojaService.save(loja));
    }

    @DeleteMapping("/{idLoja}")
    public ResponseEntity<Void> delete(@PathVariable Integer idLoja){
        lojaService.delete(idLoja);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idLoja}")
    public ResponseEntity<Loja> update(@RequestBody Loja loja){
        return ResponseEntity.ok(lojaService.save(loja));
    }

}
