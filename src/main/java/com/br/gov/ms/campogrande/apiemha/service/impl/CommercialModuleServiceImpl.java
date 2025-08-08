package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.CommercialModuleDTO;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.CommercialModuleMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.CommercialModuleRepository;
import com.br.gov.ms.campogrande.apiemha.repository.emha.SpouseRepository;
import com.br.gov.ms.campogrande.apiemha.service.CommercialModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommercialModuleServiceImpl implements CommercialModuleService {

    private final CommercialModuleRepository commercialModuleRepository;
    private final CommercialModuleMapper commercialModuleMapper;

    private final SpouseRepository spouseRepository;

    @Override
    public List<CommercialModuleDTO> findAll() {
        return Optional.of(commercialModuleRepository.findAll(Sort.by("id")))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException("Nenhum módulo comercial encontrado."))
                .stream()
                .map(commercialModuleMapper::toDTO)
                .toList();
    }

    @Override
    public CommercialModuleDTO findByPerson(Long personId) {
        return commercialModuleRepository.findFirstCommercialModuleByPersonId(personId)
                .map(commercialModuleMapper::toDTO)
                .orElseGet(() ->
                        spouseRepository.findBySpouseId(personId)
                                .map(spouse -> spouse.getPerson().getId())
                                .flatMap(commercialModuleRepository::findFirstCommercialModuleByPersonId)
                                .map(commercialModuleMapper::toDTO)
                                .orElse(null)
                );
    }
}
