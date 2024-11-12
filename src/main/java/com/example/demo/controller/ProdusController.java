package com.example.demo.controller;

import com.example.demo.model.Produs;
import com.example.demo.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.getAllProduse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produs> getProdusById(@PathVariable Long id) {
        return produsService.getProdusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produs createProdus(@RequestBody Produs produs) {
        return produsService.createProdus(produs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produs> updateProdus(@PathVariable Long id, @RequestBody Produs produsDetails) {
        try {
            Produs updatedProdus = produsService.updateProdus(id, produsDetails);
            return ResponseEntity.ok(updatedProdus);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        produsService.deleteProdus(id);
        return ResponseEntity.noContent().build();
    }
}
