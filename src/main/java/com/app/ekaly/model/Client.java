package com.app.ekaly.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", length = 255, nullable = false, unique = true)
    private String username;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    private LocalDate dateInscription;

    public Client() {
    }

    public Client(Long id, String username, String email, String password, LocalDate dateInscription) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateInscription = dateInscription;
    }

    public Client(String username, String email, String password, LocalDate dateInscription) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateInscription = dateInscription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateInscription=" + dateInscription +
                '}';
    }
}

