package br.upf.agendamento.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters e setters
}
