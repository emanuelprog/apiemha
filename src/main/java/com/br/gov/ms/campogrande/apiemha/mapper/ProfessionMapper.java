package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.ProfessionDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Profession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessionMapper {

    ProfessionDTO toDTO(Profession model);

    Profession toModel(ProfessionDTO dto);
}