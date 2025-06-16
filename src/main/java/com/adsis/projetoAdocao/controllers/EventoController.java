package com.adsis.projetoAdocao.controllers;

import com.adsis.projetoAdocao.dtos.AdocaoRequestDTO;
import com.adsis.projetoAdocao.dtos.AdocaoResponseDTO;
import com.adsis.projetoAdocao.dtos.EventoRequestDTO;
import com.adsis.projetoAdocao.dtos.EventoResponseDTO;
import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.models.Adocao;
import com.adsis.projetoAdocao.models.Evento;
import com.adsis.projetoAdocao.services.AdocaoService;
import com.adsis.projetoAdocao.services.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> listar(){
        return ResponseEntity.ok(eventoService.listar());
    }
    
    @PostMapping
    public ResponseEntity<Evento> cadastrar(@RequestBody EventoRequestDTO request){
        Evento eventoSalvo = eventoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Evento> alterar(@PathVariable Long id, @RequestBody EventoRequestDTO request){
        Evento eventoSalvo = eventoService.alterar(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        eventoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
