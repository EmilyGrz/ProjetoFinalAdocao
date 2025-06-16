package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdotanteRequestDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public AdotanteRequestDTO(String nome, String email, String telefone, String cpf, String endereco){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
