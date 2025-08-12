package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    List<Inscription> findAllByPersonOnline_Id(Long personOnlineId);

    List<Inscription> findAllByPersonOnline_IdAndEventComponent_Id(Long personOnlineId, Long eventComponentId);
}
