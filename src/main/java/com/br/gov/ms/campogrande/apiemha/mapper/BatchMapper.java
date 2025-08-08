package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.BatchDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Batch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BatchMapper {

    BatchDTO toDTO(Batch model);

    Batch toModel(BatchDTO dto);
}