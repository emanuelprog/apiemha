package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.BenefitedDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.BenefitedMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.BenefitedRepository;
import com.br.gov.ms.campogrande.apiemha.service.BenefitedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitedServiceImpl implements BenefitedService {

    private final BenefitedRepository benefitedRepository;
    private final BenefitedMapper benefitedMapper;

    @Override
    public List<BenefitedDTO> findAllByPerson(Long personId) {
        return benefitedRepository.findAllByPerson_Id(personId)
                .stream()
                .map(benefitedMapper::toDTO)
                .toList();
    }
}
