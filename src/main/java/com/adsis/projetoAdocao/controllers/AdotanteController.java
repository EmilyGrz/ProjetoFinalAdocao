package com.adsis.projetoAdocao.controllers;

import com.adsis.projetoAdocao.dtos.AdocaoRequestDTO;
import com.adsis.projetoAdocao.dtos.AdocaoResponseDTO;
import com.adsis.projetoAdocao.dtos.AdotanteRequestDTO;
import com.adsis.projetoAdocao.dtos.AdotanteResponseDTO;
import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.models.Adocao;
import com.adsis.projetoAdocao.models.Adotante;
import com.adsis.projetoAdocao.services.AdocaoService;
import com.adsis.projetoAdocao.services.AdotanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adotante")
public class AdotanteController {

    private final AdotanteService adotanteService;

    public AdotanteController(AdotanteService adotanteService) {
        this.adotanteService = adotanteService;
    }


    @GetMapping
    public ResponseEntity<List<AdotanteResponseDTO>> listar(){
        return ResponseEntity.ok(adotanteService.listar());
    }

    @PostMapping
    public ResponseEntity<Adotante> cadastrar(@RequestBody AdotanteRequestDTO request){
        Adotante adotanteSalvo = adotanteService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(adotanteSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Adotante> alterar(@PathVariable Long id, @RequestBody AdotanteRequestDTO request){
        Adotante adotanteSalvo = adotanteService.alterar(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(adotanteSalvo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        adotanteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
