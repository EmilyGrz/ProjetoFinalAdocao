package com.adsis.projetoAdocao.models;

import com.adsis.projetoAdocao.enums.StatusAdocao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adotante_id", nullable = false)
    private Adotante adotante;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    private Date dataSolicitacao;

    @Column(nullable=false)
    private StatusAdocao statusAdocao;

    public Adocao(){
    }

    public Adocao(Animal animal, Adotante adotante, Date dataSolicitacao, StatusAdocao statusAdocao){
        this.animal = animal;
        this.adotante = adotante;
        this.dataSolicitacao = dataSolicitacao;
        this.statusAdocao = statusAdocao;
    }
}
