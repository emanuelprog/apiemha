package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.BenefitedDTO;

import java.util.List;

public interface BenefitedService {

    List<BenefitedDTO> findAllByPersonOnline(String cpf);
}
