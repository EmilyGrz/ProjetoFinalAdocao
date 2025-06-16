package com.adsis.projetoAdocao.controllers;

import com.adsis.projetoAdocao.dtos.VoluntarioRequestDTO;
import com.adsis.projetoAdocao.dtos.VoluntarioResponseDTO;
import com.adsis.projetoAdocao.models.Voluntario;
import com.adsis.projetoAdocao.services.VoluntarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioResponseDTO>> listar(){
        return ResponseEntity.ok(voluntarioService.listar());
    }

    @PostMapping
    public ResponseEntity<Voluntario> cadastrar(@RequestBody VoluntarioRequestDTO request){
        Voluntario voluntarioSalvo = voluntarioService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(voluntarioSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Voluntario> alterar(@PathVariable Long id, @RequestBody VoluntarioRequestDTO request){
        Voluntario voluntarioSalvo = voluntarioService.alterar(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(voluntarioSalvo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        voluntarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}