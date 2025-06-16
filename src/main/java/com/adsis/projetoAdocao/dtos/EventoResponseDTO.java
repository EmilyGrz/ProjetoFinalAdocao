package com.adsis.projetoAdocao.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventoResponseDTO {
    private int id;
    private String nome;
    private Date data;
    private String local;
    private String descricao;
}
