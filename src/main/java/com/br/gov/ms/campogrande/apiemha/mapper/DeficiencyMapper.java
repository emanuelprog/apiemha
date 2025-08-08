package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.DeficiencyDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Deficiency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeficiencyMapper {

    DeficiencyDTO toDTO(Deficiency model);

    Deficiency toModel(DeficiencyDTO dto);
}