package com.adsis.projetoAdocao.repositories;

import com.adsis.projetoAdocao.models.Adotante;
import com.adsis.projetoAdocao.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdotanteRepository extends JpaRepository<Adotante, Long>{
}
