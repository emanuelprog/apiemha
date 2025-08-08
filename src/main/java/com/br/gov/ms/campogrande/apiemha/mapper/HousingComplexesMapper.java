package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.HousingComplexesDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.HousingComplexes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CommercialModuleMapper.class })
public interface HousingComplexesMapper {

    HousingComplexesDTO toDTO(HousingComplexes model);

    HousingComplexes toModel(HousingComplexesDTO dto);
}