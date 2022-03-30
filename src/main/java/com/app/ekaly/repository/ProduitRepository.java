package com.app.ekaly.repository;

import com.app.ekaly.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
