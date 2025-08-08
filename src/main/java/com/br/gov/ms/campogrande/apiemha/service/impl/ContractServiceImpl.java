package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.ContractDTO;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.ContractMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.ContractRepository;
import com.br.gov.ms.campogrande.apiemha.service.BatchService;
import com.br.gov.ms.campogrande.apiemha.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    private final BatchService batchService;

    @Override
    public List<ContractDTO> findAll() {
        return Optional.of(contractRepository.findAll(Sort.by("id")))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException("Nenhum contrato encontrado."))
                .stream()
                .map(contractMapper::toDTO)
                .toList();
    }

    @Override
    public ContractDTO findContractByFilters(Long number, Long housingComplexesId, Long commercialModuleId) {
        return contractRepository
                .findLastContract(number, housingComplexesId, commercialModuleId)
                .map(contract -> {
                    ContractDTO dto = contractMapper.toDTO(contract);
                    dto.setBatch(batchService.findBatchByIdAndHousingComplexesId(contract.getBatchId(), housingComplexesId));
                    return dto;
                })
                .orElseThrow(() -> new NotFoundException("Nenhum contrato encontrado."));
    }

    @Override
    public List<ContractDTO> findContractsByPerson(Long personId) {
        return contractRepository.findAllByPerson_Id(personId)
                .stream()
                .map(contractMapper::toDTO)
                .toList();
    }
}
