package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.EventComponentDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.EventComponentMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.EventComponentRepository;
import com.br.gov.ms.campogrande.apiemha.service.EventComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventComponentServiceImpl implements EventComponentService {

    private final EventComponentRepository eventComponentRepository;
    private final EventComponentMapper eventComponentMapper;

    @Override
    public List<EventComponentDTO> findAllByEvent(Long eventId) {
        return eventComponentRepository.findAllByEvent_Id(eventId)
                .stream()
                .map(eventComponentMapper::toDTO)
                .toList();
    }
}
