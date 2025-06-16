package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventoRequestDTO {
    private String nome;
    private Date data;
    private String local;
    private String descricao;

    public EventoRequestDTO(String nome, Date data, String local, String descricao){
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
    }
}
