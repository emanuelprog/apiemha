package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.CommercialModuleDTO;

import java.util.List;

public interface CommercialModuleService {

    List<CommercialModuleDTO> findAll();

    CommercialModuleDTO findByPerson(Long personId);
}
