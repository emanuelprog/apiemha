package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.EventDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { EventComponentMapper.class })
public interface EventMapper {

    EventDTO toDTO(Event model);

    Event toModel(EventDTO dto);
}