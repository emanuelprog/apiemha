package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.OperationDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    OperationDTO toDTO(Operation model);

    Operation toModel(OperationDTO dto);
}