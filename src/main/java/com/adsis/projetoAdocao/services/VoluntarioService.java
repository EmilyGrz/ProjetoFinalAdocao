package com.adsis.projetoAdocao.services;

import com.adsis.projetoAdocao.dtos.VoluntarioRequestDTO;
import com.adsis.projetoAdocao.dtos.VoluntarioResponseDTO;
import com.adsis.projetoAdocao.exceptions.NaoEncontradoException;
import com.adsis.projetoAdocao.models.Voluntario;
import com.adsis.projetoAdocao.repositories.VoluntarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository adotanteRepository) {
        this.voluntarioRepository = adotanteRepository;
    }

    public Voluntario cadastrar(VoluntarioRequestDTO dto){
        Voluntario voluntario = new Voluntario(dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getCpf(), dto.getEndereco(), dto.getDataEntrada());
        return voluntarioRepository.save(voluntario);
    }

    public Voluntario alterar(Long id, VoluntarioRequestDTO dto) {
        Voluntario voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("voluntario ainda não encontrado com o Id:"+ id));
        voluntario.setNome(dto.getNome());
        voluntario.setEmail(dto.getEmail());
        voluntario.setTelefone(dto.getTelefone());
        voluntario.setCpf(dto.getCpf());
        voluntario.setEndereco(dto.getEndereco());
        return voluntarioRepository.save(voluntario);
    }

    public List<VoluntarioResponseDTO> listar(){
        return voluntarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void excluir(Long id){
        voluntarioRepository.deleteById(id);
    }

    private VoluntarioResponseDTO toDTO(Voluntario voluntario){
        VoluntarioResponseDTO dto = new VoluntarioResponseDTO();

        dto.setId(voluntario.getId());
        dto.setNome(voluntario.getNome());
        dto.setEmail(voluntario.getEmail());
        dto.setTelefone(voluntario.getTelefone());
        dto.setCpf(voluntario.getCpf());
        dto.setEndereco(voluntario.getEndereco());

        return dto;
    }
}