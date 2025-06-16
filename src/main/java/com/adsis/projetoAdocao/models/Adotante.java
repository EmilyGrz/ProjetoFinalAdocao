package com.adsis.projetoAdocao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adotante extends Pessoa {

    public Adotante(){
    }

    public Adotante(String nome, String email , String telefone, String cpf, String endereco){
        super(nome, email, telefone, cpf, endereco);
    }
}
