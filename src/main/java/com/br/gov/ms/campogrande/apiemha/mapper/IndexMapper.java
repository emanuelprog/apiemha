package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.IndexDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Index;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ChartMapper.class)
public interface IndexMapper {

    IndexDTO toDTO(Index model);

    Index toModel(IndexDTO dto);
}