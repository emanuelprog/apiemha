package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.DeficiencyDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.DeficiencyMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.DeficiencyRepository;
import com.br.gov.ms.campogrande.apiemha.service.DeficiencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeficiencyServiceImpl implements DeficiencyService {

    private final DeficiencyRepository deficiencyRepository;
    private final DeficiencyMapper deficiencyMapper;

    @Override
    public List<DeficiencyDTO> findAll() {
        return deficiencyRepository.findAll()
                .stream()
                .map(deficiencyMapper::toDTO)
                .toList();
    }
}
