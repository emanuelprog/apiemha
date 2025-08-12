package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.EventComponentDTO;

import java.util.List;

public interface EventComponentService {

    List<EventComponentDTO> findAllByEvent(Long eventId);
}
