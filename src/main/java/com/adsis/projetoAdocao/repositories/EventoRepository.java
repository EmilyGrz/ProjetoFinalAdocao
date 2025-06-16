package com.adsis.projetoAdocao.repositories;

import com.adsis.projetoAdocao.models.Adocao;
import com.adsis.projetoAdocao.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long>{
}
