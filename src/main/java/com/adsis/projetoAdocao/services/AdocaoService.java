package com.adsis.projetoAdocao.services;

import com.adsis.projetoAdocao.dtos.AdocaoRequestDTO;
import com.adsis.projetoAdocao.dtos.AdocaoResponseDTO;
import com.adsis.projetoAdocao.dtos.AdotanteResponseDTO;
import com.adsis.projetoAdocao.dtos.AnimalResponseDTO;
import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.enums.StatusAnimal;
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
public class AdocaoService {

    private final AdocaoRepository adocaoRepository;
    private final AnimalRepository animalRepository;
    private final AdotanteRepository adotanteRepository;

    public AdocaoService(AdocaoRepository adocaoRepository, AnimalRepository animalRepository,
                         AdotanteRepository adotanteRepository) {
        this.adocaoRepository = adocaoRepository;
        this.animalRepository = animalRepository;
        this.adotanteRepository = adotanteRepository;
    }

    public Adocao cadastrar(AdocaoRequestDTO dto) {
        Animal animal = animalRepository.findById(dto.getIdAnimal())
                .orElseThrow(() -> new NaoEncontradoException("Animal com ID " + dto.getIdAnimal() + " não encontrado"));
        Adotante adotante = adotanteRepository.findById(dto.getIdAdotante())
                .orElseThrow(() -> new NaoEncontradoException("Adotante com ID " + dto.getIdAdotante() + " não encontrado"));

        Adocao adocao = new Adocao(animal, adotante, new Date(), StatusAdocao.PENDENTE);
        return adocaoRepository.save(adocao);
    }

    public List<AdocaoResponseDTO> listar() {
        return adocaoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AdocaoResponseDTO> listarPorStatus(StatusAdocao status) {
        return adocaoRepository.findByStatusAdocao(status).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void excluir(Long id) {
        Adocao adocao = adocaoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Adoção com ID " + id + " não encontrada"));

        adocaoRepository.deleteById(id);

        Animal animal = animalRepository.findById(adocao.getAnimal().getId())
                .orElseThrow(() -> new NaoEncontradoException("Animal não encontrado para atualizar"));

        animal.setStatusAnimal(StatusAnimal.DISPONIVEL);
        animalRepository.save(animal);
    }

    public void alterarStatus(Long id, StatusAdocao novoStatus) {
        Adocao adocao = adocaoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Adoção com ID " + id + " não encontrada"));

        Animal animal = animalRepository.findById(adocao.getAnimal().getId())
                .orElseThrow(() -> new NaoEncontradoException("Animal com ID " + adocao.getAnimal().getId() + " não encontrado"));

        adocao.setStatusAdocao(novoStatus);
        adocaoRepository.save(adocao);

        if (novoStatus.equals(StatusAdocao.APROVADA)) {
            animal.setStatusAnimal(StatusAnimal.ADOTADO);
            animalRepository.save(animal);
        }
    }

    private AdocaoResponseDTO toDTO(Adocao adocao) {
        AdocaoResponseDTO dto = new AdocaoResponseDTO();
        AnimalResponseDTO animalDto = new AnimalResponseDTO();
        AdotanteResponseDTO adotanteDto = new AdotanteResponseDTO();

        animalDto.setId(adocao.getAnimal().getId());
        animalDto.setNome(adocao.getAnimal().getNome());
        animalDto.setEspecie(adocao.getAnimal().getEspecie().getValor());
        animalDto.setIdade(adocao.getAnimal().getIdade());
        animalDto.setSexo(adocao.getAnimal().getSexo().getValor());
        animalDto.setRaca(adocao.getAnimal().getRaca());
        animalDto.setPorte(adocao.getAnimal().getPorte());
        animalDto.setVacinado(adocao.getAnimal().isVacinado() ? "Sim" : "Não");
        animalDto.setCastrado(adocao.getAnimal().isCastrado() ? "Sim" : "Não");
        animalDto.setStatusAninal(adocao.getAnimal().getStatusAnimal().getValor());

        adotanteDto.setId(adocao.getAdotante().getId());
        adotanteDto.setNome(adocao.getAdotante().getNome());
        adotanteDto.setTelefone(adocao.getAdotante().getTelefone());
        adotanteDto.setCpf(adocao.getAdotante().getCpf());
        adotanteDto.setEmail(adocao.getAdotante().getEmail());
        adotanteDto.setEndereco(adocao.getAdotante().getEndereco());

        dto.setAdotante(adotanteDto);
        dto.setAnimal(animalDto);
        return dto;
    }
}
