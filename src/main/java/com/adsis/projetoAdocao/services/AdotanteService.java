package com.adsis.projetoAdocao.services;

import com.adsis.projetoAdocao.dtos.*;
import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.exceptions.NaoEncontradoException;
import com.adsis.projetoAdocao.models.Adocao;
import com.adsis.projetoAdocao.models.Adotante;
import com.adsis.projetoAdocao.models.Animal;
import com.adsis.projetoAdocao.repositories.AdocaoRepository;
import com.adsis.projetoAdocao.repositories.AdotanteRepository;
import com.adsis.projetoAdocao.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdotanteService {

    private final AdotanteRepository adotanteRepository;

    public AdotanteService(AdotanteRepository adotanteRepository) {
        this.adotanteRepository = adotanteRepository;
    }

    public Adotante cadastrar(AdotanteRequestDTO dto){
        Adotante adotante = new Adotante(dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getCpf(), dto.getEndereco());
        return adotanteRepository.save(adotante);
    }

    public Adotante alterar(Long id, AdotanteRequestDTO dto) {
        Adotante adotante = adotanteRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("o id do adotante e invalido id:"+id));
        adotante.setNome(dto.getNome());
        adotante.setEmail(dto.getEmail());
        adotante.setTelefone(dto.getTelefone());
        adotante.setCpf(dto.getCpf());
        adotante.setEndereco(dto.getEndereco());
        return adotanteRepository.save(adotante);
    }

    public List<AdotanteResponseDTO> listar(){
        return adotanteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void excluir(Long id){
        adotanteRepository.deleteById(id);
    }

    private AdotanteResponseDTO toDTO(Adotante adotante){
        AdotanteResponseDTO dto = new AdotanteResponseDTO();

        dto.setId(adotante.getId());
        dto.setNome(adotante.getNome());
        dto.setEmail(adotante.getEmail());
        dto.setTelefone(adotante.getTelefone());
        dto.setCpf(adotante.getCpf());
        dto.setEndereco(adotante.getEndereco());

        return dto;
    }
}
