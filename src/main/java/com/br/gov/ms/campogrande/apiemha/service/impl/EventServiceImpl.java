package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.EventDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.EventMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.EventRepository;
import com.br.gov.ms.campogrande.apiemha.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDTO> findAllByStartDateAndEndDate(LocalDate startDate, LocalDate endDate) {
        return eventRepository
                .findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndActiveIsTrue(
                        Objects.requireNonNullElse(startDate, LocalDate.now()),
                        Objects.requireNonNullElse(endDate, LocalDate.now())
                )
                .stream()
                .map(eventMapper::toDTO)
                .toList();
    }
}
