package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.DependentDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Dependent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DependentMapper {

    DependentDTO toDTO(Dependent model);

    Dependent toModel(DependentDTO dto);
}