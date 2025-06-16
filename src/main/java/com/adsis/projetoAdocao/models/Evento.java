package com.adsis.projetoAdocao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false)
    private Date data;

    @Column(nullable=false)
    private String local;

    @Column(nullable=false)
    private String descricao;

    public Evento(){
    }

    public Evento(String nome, Date data, String local, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
    }
}
