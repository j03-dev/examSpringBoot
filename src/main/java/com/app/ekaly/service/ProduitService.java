package com.app.ekaly.service;

import com.app.ekaly.model.Produit;
import com.app.ekaly.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> ListAllProduit(){
        return produitRepository.findAll();
    }

    public void saveProduit(Produit produit){
        produitRepository.save(produit);
    }

    public Produit getProduitById(Long id){
       return produitRepository.findById(id).get();
    }

    public void DeleteProduit(Long id){
        produitRepository.deleteById(id);
    }

}
