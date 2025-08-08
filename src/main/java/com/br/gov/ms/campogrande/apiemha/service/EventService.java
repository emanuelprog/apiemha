package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.EventDTO;

import java.time.LocalDate;
import java.util.List;

public interface EventService {

    List<EventDTO> findAllByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
