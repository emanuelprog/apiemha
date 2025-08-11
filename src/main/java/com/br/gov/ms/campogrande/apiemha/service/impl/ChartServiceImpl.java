package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.ChartDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.ChartMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.ChartRepository;
import com.br.gov.ms.campogrande.apiemha.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService {

    private final ChartRepository chartRepository;
    private final ChartMapper chartMapper;

    @Override
    public List<ChartDTO> findAllByChartType(String chartType) {
        return chartRepository.findAllByChartType(chartType)
                .stream()
                .map(chartMapper::toDTO)
                .toList();
    }
}
