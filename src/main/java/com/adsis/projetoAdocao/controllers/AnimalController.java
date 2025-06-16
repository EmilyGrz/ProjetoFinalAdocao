package com.adsis.projetoAdocao.controllers;

import com.adsis.projetoAdocao.dtos.AdocaoResponseDTO;
import com.adsis.projetoAdocao.dtos.AnimalRequestDTO;
import com.adsis.projetoAdocao.dtos.AnimalResponseDTO;
import com.adsis.projetoAdocao.enums.StatusAnimal;
import com.adsis.projetoAdocao.models.Animal;
import com.adsis.projetoAdocao.services.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> listar(){
        return ResponseEntity.ok(animalService.listar());
    }

    @GetMapping("{status}")
    public ResponseEntity<List<AnimalResponseDTO>> listar(@PathVariable StatusAnimal status){
        return ResponseEntity.ok(animalService.listarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody AnimalRequestDTO request){
        Animal animalSalvo = animalService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(animalSalvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> alterar(@PathVariable Long id, @RequestBody AnimalRequestDTO request){
        Animal animalAlterado = animalService.alterar(id, request);
        return ResponseEntity.ok(animalAlterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        animalService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
