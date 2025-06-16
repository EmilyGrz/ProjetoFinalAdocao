package com.adsis.projetoAdocao.models;

import com.adsis.projetoAdocao.enums.EspecieAnimal;
import com.adsis.projetoAdocao.enums.SexoAnimal;
import com.adsis.projetoAdocao.enums.StatusAnimal;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "adocao")
@EqualsAndHashCode(exclude = "adocao")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nome;

    @Column(nullable = false)
    private EspecieAnimal especie;

    @Column(nullable=false)
    private String raca;

    @Column(nullable=false)
    private int idade;

    @Column(nullable=false)
    private String porte;

    @Column(nullable=false)
    private SexoAnimal sexo;

    private boolean vacinado;

    private boolean castrado;

    @Column(nullable=false)
    private StatusAnimal statusAnimal;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "animal", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private Adocao adocao;

    public Animal(){
    }

    public Animal(String nome, EspecieAnimal especie, String raca, int idade, String porte, SexoAnimal sexo, boolean vacinado, boolean castrado, StatusAnimal status){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.sexo = sexo;
        this.vacinado = vacinado;
        this.castrado = castrado;
        this.statusAnimal = status;
    }
}
