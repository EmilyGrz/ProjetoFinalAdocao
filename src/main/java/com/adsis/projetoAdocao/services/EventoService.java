package com.adsis.projetoAdocao.services;

import com.adsis.projetoAdocao.dtos.*;
import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.exceptions.NaoEncontradoException;
import com.adsis.projetoAdocao.models.Adocao;
import com.adsis.projetoAdocao.models.Adotante;
import com.adsis.projetoAdocao.models.Animal;
import com.adsis.projetoAdocao.models.Evento;
import com.adsis.projetoAdocao.repositories.AdocaoRepository;
import com.adsis.projetoAdocao.repositories.AdotanteRepository;
import com.adsis.projetoAdocao.repositories.AnimalRepository;
import com.adsis.projetoAdocao.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criar(EventoRequestDTO dto){
        Evento evento = new Evento(dto.getNome(), dto.getData(), dto.getLocal(), dto.getDescricao());
        return eventoRepository.save(evento);
    }

    public Evento alterar(Long id, EventoRequestDTO dto) {
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("o id do evento e invalido id:"+id));
        evento.setNome(dto.getNome());
        evento.setData(dto.getData());
        evento.setLocal(dto.getLocal());
        evento.setDescricao(dto.getDescricao());

        return eventoRepository.save(evento);
    }

    public List<EventoResponseDTO> listar(){
        return eventoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void excluir(Long id){
        eventoRepository.deleteById(id);
    }

    private EventoResponseDTO toDTO(Evento evento){
        EventoResponseDTO dto = new EventoResponseDTO();
        dto.setId(evento.getId());
        dto.setNome(evento.getNome());
        dto.setData(evento.getData());
        dto.setLocal(evento.getLocal());
        dto.setDescricao(evento.getDescricao());
        return dto;
    }
}
