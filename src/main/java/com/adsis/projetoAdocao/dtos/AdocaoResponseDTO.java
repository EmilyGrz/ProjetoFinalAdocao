package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdocaoResponseDTO {
    private AnimalResponseDTO animal;
    private AdotanteResponseDTO adotante;
}
