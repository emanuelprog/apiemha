package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.ContractDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ChartMapper.class, CommercialModuleMapper.class,
        HousingComplexesMapper.class, LotteryNotesMapper.class, PersonMapper.class, IndexMapper.class, OperationMapper.class })
public interface ContractMapper {

    ContractDTO toDTO(Contract model);

    Contract toModel(ContractDTO dto);
}