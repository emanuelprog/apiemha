package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.EventComponentDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.EventComponent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CommercialModuleMapper.class })
public interface EventComponentMapper {

    EventComponentDTO toDTO(EventComponent model);

    EventComponent toModel(EventComponentDTO dto);
}