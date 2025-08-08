package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.HousingComplexesDTO;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.HousingComplexesMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.HousingComplexesRepository;
import com.br.gov.ms.campogrande.apiemha.repository.emha.SpouseRepository;
import com.br.gov.ms.campogrande.apiemha.service.HousingComplexesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HousingComplexesServiceImpl implements HousingComplexesService {

    private final HousingComplexesRepository housingComplexesRepository;
    private final HousingComplexesMapper housingComplexesMapper;

    private final SpouseRepository spouseRepository;

    @Override
    public List<HousingComplexesDTO> findAll() {
        return Optional.of(housingComplexesRepository.findAll(Sort.by("id")))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException("Nenhum conjunto habitacional encontrado."))
                .stream()
                .map(housingComplexesMapper::toDTO)
                .toList();
    }

    @Override
    public List<HousingComplexesDTO> findAllByCommercialModule(Long commercialModuleId) {
        return Optional.of(housingComplexesRepository.findAllByCommercialModuleId(commercialModuleId, Sort.by("id")))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException("Nenhum conjunto habitacional encontrado para o módulo comercial informado."))
                .stream()
                .map(housingComplexesMapper::toDTO)
                .toList();
    }

    @Override
    public List<HousingComplexesDTO> findAllByPerson(Long personId) {
        return Optional.ofNullable(housingComplexesRepository.findHousingComplexesByPersonId(personId))
                .filter(list -> !list.isEmpty())
                .or(() -> spouseRepository.findBySpouseId(personId)
                        .map(spouse -> housingComplexesRepository.findHousingComplexesByPersonId(spouse.getPerson().getId()))
                        .filter(list -> !list.isEmpty()))
                .orElse(List.of())
                .stream()
                .map(housingComplexesMapper::toDTO)
                .toList();
    }
}
