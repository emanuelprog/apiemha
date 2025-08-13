package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.DependentDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Dependent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface DependentMapper {

    DependentDTO toDTO(Dependent model);

    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    Dependent toModel(DependentDTO dto);
}