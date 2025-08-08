package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.ChartDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Chart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChartMapper {

    ChartDTO toDTO(Chart model);

    Chart toModel(ChartDTO dto);
}