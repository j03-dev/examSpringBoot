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
    private Client id_client;

    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id")
    private Produit id_produit;

    private LocalDate date;

    public Command() {

    }

    public Command(Client client, Produit produit, LocalDate date) {
        this.id_client = client;
        this.id_produit = produit;
        this.date = date;
    }

    public Command(Long id, Client client, Produit produit, LocalDate date) {
        this.id = id;
        this.id_client = client;
        this.id_produit = produit;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public Produit getId_produit() {
        return id_produit;
    }

    public void setId_produit(Produit id_produit) {
        this.id_produit = id_produit;
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
                ", client=" + id_client +
                ", produit=" + id_produit +
                ", date=" + date +
                '}';
    }
}
