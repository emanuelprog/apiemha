package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.HousingComplexesDTO;

import java.util.List;

public interface HousingComplexesService {

    List<HousingComplexesDTO> findAll();

    List<HousingComplexesDTO> findAllByCommercialModule(Long commercialModuleId);

    List<HousingComplexesDTO> findAllByPerson(Long personId);
}
