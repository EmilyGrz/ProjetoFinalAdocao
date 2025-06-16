package com.adsis.projetoAdocao.repositories;

import com.adsis.projetoAdocao.enums.StatusAnimal;
import com.adsis.projetoAdocao.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    List<Animal> findByStatusAnimal(StatusAnimal status);
}
