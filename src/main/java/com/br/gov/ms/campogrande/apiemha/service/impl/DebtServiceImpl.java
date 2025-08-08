package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.DebtDTO;
import com.br.gov.ms.campogrande.apiemha.dto.UrlDTO;
import com.br.gov.ms.campogrande.apiemha.feign.DebtClient;
import com.br.gov.ms.campogrande.apiemha.mapper.DebtMapper;
import com.br.gov.ms.campogrande.apiemha.model.emha.Debt;
import com.br.gov.ms.campogrande.apiemha.repository.emha.DebtRepository;
import com.br.gov.ms.campogrande.apiemha.service.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final DebtRepository debtRepository;
    private final DebtMapper debtMapper;

    private final DebtClient debtClient;

    public List<DebtDTO> getDebtByContract(Long contractId) {
        return debtRepository.findByContractIdAndActiveFlagOrderByInstallmentNumberAsc(contractId, 'S').stream()
                .map(debtMapper::toDTO)
                .toList();
    }

    @Override
    public String generateSecondCopy(List<DebtDTO> debtsDTO) {
        List<Debt> debts = debtsDTO.stream()
                .map(dto -> debtRepository.findById(dto.getId())
                        .orElse(null))
                .toList();

        List<DebtDTO.SecondCopy> extracts = debts.stream()
                .map(debtMapper::toSecondCopy)
                .toList();

        UrlDTO response = debtClient.getSecondCopy(extracts);

        return response.getUrl();
    }

    @Override
    public String generateSlip(List<DebtDTO> debtsDTO) {
        List<Debt> debts = debtsDTO.stream()
                .map(dto -> debtRepository.findById(dto.getId())
                        .orElse(null))
                .toList();

        List<DebtDTO.SecondCopy> extracts = debts.stream()
                .map(debtMapper::toSecondCopy)
                .toList();

        UrlDTO response = debtClient.getSlip(extracts);

        return response.getUrl();
    }

    @Override
    public String generateExtract(Long contractId) {
        UrlDTO response = debtClient.getExtract(contractId);

        return response.getUrl();
    }
}
