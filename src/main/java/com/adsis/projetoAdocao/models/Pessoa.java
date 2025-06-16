package com.adsis.projetoAdocao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String telefone;

    @Column(nullable=false)
    private String cpf;

    @Column(nullable=false)
    private String endereco;

    public Pessoa(){
    }

    public Pessoa(String nome, String email, String telefone, String cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }
}
