package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.BenefitDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Benefit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { HousingComplexesMapper.class, CommercialModuleMapper.class })
public interface BenefitMapper {

    BenefitDTO toDTO(Benefit model);

    Benefit toModel(BenefitDTO dto);
}