package com.adsis.projetoAdocao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Voluntario extends  Pessoa{
    @Column(nullable = false)
    private Date dataEntrada;

    public Voluntario(){
    }

    public Voluntario(String nome, String email , String telefone, String cpf, String endereco, Date dataEntrada){
        super(nome, email, telefone, cpf, endereco);
        this.dataEntrada = dataEntrada;
    }
}
