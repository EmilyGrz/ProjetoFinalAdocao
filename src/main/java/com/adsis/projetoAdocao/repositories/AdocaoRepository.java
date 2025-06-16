package com.adsis.projetoAdocao.repositories;

import com.adsis.projetoAdocao.enums.StatusAdocao;
import com.adsis.projetoAdocao.models.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AdocaoRepository extends JpaRepository<Adocao, Long>{
    List<Adocao> findByStatusAdocao(StatusAdocao status);
}
