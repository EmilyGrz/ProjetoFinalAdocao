package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalResponseDTO {
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String sexo;
    private String vacinado;
    private String castrado;
    private String statusAninal;
}
