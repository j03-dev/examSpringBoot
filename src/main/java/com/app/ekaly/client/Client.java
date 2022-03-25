package com.app.ekaly.client;


import java.time.LocalDate;

public class Client {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate dateInscription;

    public Client() {
    }

    public Client(Long id, String name, String email, String password, LocalDate dateInscription) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateInscription = dateInscription;
    }

    public Client(String name, String email, String password, LocalDate dateInscription) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateInscription=" + dateInscription +
                '}';
    }
}

