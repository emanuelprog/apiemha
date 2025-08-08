package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.BenefitedDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Benefited;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { PersonMapper.class, BenefitMapper.class })
public interface BenefitedMapper {

    BenefitedDTO toDTO(Benefited model);

    Benefited toModel(BenefitedDTO dto);
}