package com.adsis.projetoAdocao.services;

import com.adsis.projetoAdocao.dtos.VoluntarioRequestDTO;
import com.adsis.projetoAdocao.dtos.VoluntarioResponseDTO;
import com.adsis.projetoAdocao.exceptions.NaoEncontradoException;
import com.adsis.projetoAdocao.models.Voluntario;
import com.adsis.projetoAdocao.repositories.VoluntarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    // Cadastro de voluntário
    public Voluntario cadastrar(VoluntarioRequestDTO dto) {
        // Usa a data atual se não fornecida
        Date dataEntrada = (dto.getDataEntrada() != null) ? dto.getDataEntrada() : new Date();
        Voluntario voluntario = new Voluntario(
                dto.getNome(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getCpf(),
                dto.getEndereco(),
                dataEntrada
        );
        return voluntarioRepository.save(voluntario);
    }

    // Alteração de voluntário
    public Voluntario alterar(Long id, VoluntarioRequestDTO dto) {
        Voluntario voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Voluntário não encontrado com o Id: " + id));
        voluntario.setNome(dto.getNome());
        voluntario.setEmail(dto.getEmail());
        voluntario.setTelefone(dto.getTelefone());
        voluntario.setCpf(dto.getCpf());
        voluntario.setEndereco(dto.getEndereco());
        return voluntarioRepository.save(voluntario);
    }

    // Listagem de voluntários
    public List<VoluntarioResponseDTO> listar() {
        return voluntarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Exclusão de voluntário
    public void excluir(Long id) {
        if (!voluntarioRepository.existsById(id)) {
            throw new NaoEncontradoException("Voluntário não encontrado com o Id: " + id);
        }
        voluntarioRepository.deleteById(id);
    }

    // Conversão para DTO
    private VoluntarioResponseDTO toDTO(Voluntario voluntario) {
        VoluntarioResponseDTO dto = new VoluntarioResponseDTO();
        dto.setId(voluntario.getId());
        dto.setNome(voluntario.getNome());
        dto.setEmail(voluntario.getEmail());
        dto.setTelefone(voluntario.getTelefone());
        dto.setCpf(voluntario.getCpf());
        dto.setEndereco(voluntario.getEndereco());
        dto.setDataEntrada(voluntario.getDataEntrada());
        return dto;
    }
}
