package com.app.ekaly.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id")
    private Produit produit;

    private LocalDate date;

    public Command() {

    }

    public Command(Client client, Produit produit, LocalDate date) {
        this.client = client;
        this.produit = produit;
        this.date = date;
    }

    public Command(Long id, Client client, Produit produit, LocalDate date) {
        this.id = id;
        this.client = client;
        this.produit = produit;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", client=" + client +
                ", produit=" + produit +
                ", date=" + date +
                '}';
    }
}
