package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdocaoRequestDTO {
    private Long idAnimal;
    private Long idAdotante;
    private Date dataSolicitacao;

    public AdocaoRequestDTO(Long idAnimal, Long idAdotante, Date dataSolicitacao){
        this.idAnimal = idAnimal;
        this.idAdotante = idAdotante;
        this.dataSolicitacao = dataSolicitacao;
    }
}
