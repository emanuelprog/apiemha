package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.CommercialModuleDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.CommercialModule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommercialModuleMapper {

    CommercialModuleDTO toDTO(CommercialModule model);

    CommercialModule toModel(CommercialModuleDTO dto);
}