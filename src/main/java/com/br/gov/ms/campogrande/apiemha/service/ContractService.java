package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.ContractDTO;

import java.util.List;

public interface ContractService {

    List<ContractDTO> findAll();

    ContractDTO findContractByFilters(Long number, Long housingComplexesId, Long commercialModuleId);

    List<ContractDTO> findContractsByPerson(Long personId);
}
