package com.adsis.projetoAdocao.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AdocaoRequestDTO {

    private Long idAnimal;
    private Long idAdotante;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dataSolicitacao;

    // Construtor padrão
    public AdocaoRequestDTO() {}

    // Construtor com argumentos
    public AdocaoRequestDTO(Long idAnimal, Long idAdotante, Date dataSolicitacao) {
        this.idAnimal = idAnimal;
        this.idAdotante = idAdotante;
        this.dataSolicitacao = dataSolicitacao;
    }

    // Getters e Setters
    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Long getIdAdotante() {
        return idAdotante;
    }

    public void setIdAdotante(Long idAdotante) {
        this.idAdotante = idAdotante;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
