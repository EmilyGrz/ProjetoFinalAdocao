package com.adsis.projetoAdocao.dtos;

import com.adsis.projetoAdocao.enums.EspecieAnimal;
import com.adsis.projetoAdocao.enums.SexoAnimal;
import com.adsis.projetoAdocao.enums.StatusAnimal;
import com.adsis.projetoAdocao.models.Adotante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalRequestDTO {
    private String nome;
    private EspecieAnimal especie;
    private String raca;
    private int idade;
    private String porte;
    private SexoAnimal sexo;
    private boolean vacinado;
    private boolean castrado;
    private StatusAnimal status;

    public AnimalRequestDTO(String nome, EspecieAnimal especie, String raca, int idade, String porte,
                            SexoAnimal sexo, boolean vacinado,
                            boolean castrado, StatusAnimal status) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.sexo = sexo;
        this.vacinado = vacinado;
        this.castrado = castrado;
        this.status = status;
    }
}
