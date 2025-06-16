package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VoluntarioRequestDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private Date dataEntrada;

    public VoluntarioRequestDTO(String nome, String email, String telefone, String cpf, String endereco, Date dataEntrada){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataEntrada = dataEntrada;
    }
}
