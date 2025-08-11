package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.ProfessionDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.ProfessionMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.ProfessionRepository;
import com.br.gov.ms.campogrande.apiemha.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {

    private final ProfessionRepository professionRepository;
    private final ProfessionMapper professionMapper;

    @Override
    public List<ProfessionDTO> findAll() {
        return professionRepository.findAll()
                .stream()
                .map(professionMapper::toDTO)
                .toList();
    }
}
