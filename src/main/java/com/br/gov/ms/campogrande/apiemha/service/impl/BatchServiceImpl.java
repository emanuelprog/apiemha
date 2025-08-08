package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.BatchDTO;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.BatchMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.BatchRepository;
import com.br.gov.ms.campogrande.apiemha.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;
    private final BatchMapper batchMapper;

    @Override
    public BatchDTO findBatchByIdAndHousingComplexesId(Long batchId, Long housingComplexesId) {
        return batchRepository.findBatchByIdAndHousingComplexes_Id(batchId, housingComplexesId)
                .map(batchMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Nenhum lote encontrado."));
    }
}
