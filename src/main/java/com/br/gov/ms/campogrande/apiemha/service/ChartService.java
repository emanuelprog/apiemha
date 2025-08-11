package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.ChartDTO;

import java.util.List;

public interface ChartService {

    List<ChartDTO> findAllByChartType(String chartType);
}
