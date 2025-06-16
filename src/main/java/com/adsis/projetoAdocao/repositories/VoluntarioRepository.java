package com.adsis.projetoAdocao.repositories;

import com.adsis.projetoAdocao.models.Adotante;
import com.adsis.projetoAdocao.models.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long>{
}
