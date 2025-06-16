package com.adsis.projetoAdocao.controllers;

import com.adsis.projetoAdocao.dtos.AdocaoRequestDTO;
import com.adsis.projetoAdocao.dtos.AdocaoResponseDTO;
import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.models.Adocao;
import com.adsis.projetoAdocao.services.AdocaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    private final AdocaoService adocaoService;

    public AdocaoController(AdocaoService adocaoService) {
        this.adocaoService = adocaoService;
    }

    @GetMapping
    public ResponseEntity<List<AdocaoResponseDTO>> listar(){
        return ResponseEntity.ok(adocaoService.listar());
    }

    @GetMapping("{status}")
    public ResponseEntity<List<AdocaoResponseDTO>> listarPorStatus(@PathVariable StatusAdocao status){
        return ResponseEntity.ok(adocaoService.listarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<Adocao> cadastrar(@RequestBody AdocaoRequestDTO request){
        Adocao adocaoSalva = adocaoService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(adocaoSalva);
    }

    @PatchMapping("/alterar-status/{id}/{novoStatus}")
    public ResponseEntity alterarStatus(@PathVariable Long id, @PathVariable StatusAdocao novoStatus){
        adocaoService.alterarStatus(id, novoStatus);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        adocaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
