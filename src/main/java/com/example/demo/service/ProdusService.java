package com.example.demo.service;

import com.example.demo.model.Produs;
import com.example.demo.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    public Optional<Produs> getProdusById(Long id) {
        return produsRepository.findById(id);
    }

    public Produs createProdus(Produs produs) {
        return produsRepository.save(produs);
    }

    public Produs updateProdus(Long id, Produs produsDetails) {
        Produs produs = produsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produsul nu a fost găsit"));

        produs.setNume(produsDetails.getNume());
        produs.setPret(produsDetails.getPret());
        produs.setDescriere(produsDetails.getDescriere());

        return produsRepository.save(produs);
    }

    public void deleteProdus(Long id) {
        produsRepository.deleteById(id);
    }
}
