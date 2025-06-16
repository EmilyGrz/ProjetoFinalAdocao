package com.adsis.projetoAdocao.services;

import com.adsis.projetoAdocao.dtos.AnimalRequestDTO;
import com.adsis.projetoAdocao.dtos.AnimalResponseDTO;
import com.adsis.projetoAdocao.enums.StatusAnimal;
import com.adsis.projetoAdocao.exceptions.NaoEncontradoException;
import com.adsis.projetoAdocao.models.Animal;
import com.adsis.projetoAdocao.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    public List<AnimalResponseDTO> listar() {
        return animalRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AnimalResponseDTO> listarPorStatus(StatusAnimal status) {
        return animalRepository.findByStatusAnimal(status).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Animal cadastrar(AnimalRequestDTO dto){
        Animal animal = new Animal(dto.getNome(),
                dto.getEspecie(),
                dto.getRaca(),
                dto.getIdade(),
                dto.getPorte(),
                dto.getSexo(),
                dto.isVacinado(), dto.isCastrado(),
                dto.getStatus());
       return animalRepository.save(animal);
    }

    public Animal alterar(Long id, AnimalRequestDTO dto) {

        Animal animal = animalRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("o id do animal e invalido id:"+id));

        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setRaca(dto.getRaca());
        animal.setIdade(dto.getIdade());
        animal.setPorte(dto.getPorte());
        animal.setSexo(dto.getSexo());
        animal.setVacinado(dto.isVacinado());
        animal.setCastrado(dto.isCastrado());
        animal.setStatusAnimal(dto.getStatus());

        return animalRepository.save(animal);
    }

    public void excluir(Long id){
        animalRepository.deleteById(id);
    }

    public AnimalResponseDTO toDTO(Animal animal){
        AnimalResponseDTO dto = new AnimalResponseDTO();
        dto.setId(animal.getId());
        dto.setNome(animal.getNome());
        dto.setEspecie(animal.getEspecie().getValor());
        dto.setRaca(animal.getRaca());
        dto.setIdade(animal.getIdade());
        dto.setPorte(animal.getPorte());
        dto.setSexo(animal.getSexo().getValor());
        dto.setVacinado(animal.isVacinado() ? "Sim" : "Não");
        dto.setCastrado(animal.isCastrado() ? "Sim" : "Não");
        dto.setStatusAninal(animal.getStatusAnimal().getValor());
        return dto;
    }
}
