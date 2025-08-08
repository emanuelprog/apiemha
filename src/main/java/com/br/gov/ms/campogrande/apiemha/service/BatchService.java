package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.BatchDTO;

public interface BatchService {

    BatchDTO findBatchByIdAndHousingComplexesId(Long batchId, Long housingComplexesId);
}
