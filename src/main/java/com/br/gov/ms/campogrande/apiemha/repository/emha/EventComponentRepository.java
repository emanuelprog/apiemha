package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.EventComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventComponentRepository extends JpaRepository<EventComponent, Long> {

    List<EventComponent> findAllByEvent_Id(Long eventId);
}
