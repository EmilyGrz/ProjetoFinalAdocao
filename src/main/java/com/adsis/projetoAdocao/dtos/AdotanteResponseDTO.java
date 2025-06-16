package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdotanteResponseDTO {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
}
