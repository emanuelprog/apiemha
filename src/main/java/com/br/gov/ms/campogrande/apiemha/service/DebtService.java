package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.DebtDTO;

import java.util.List;

public interface DebtService {

    List<DebtDTO> getDebtByContract(Long contractId);

    String generateSecondCopy(List<DebtDTO> debtsDTO);

    String generateSlip(List<DebtDTO> debtsDTO);

    String generateExtract(Long contractId);
}
