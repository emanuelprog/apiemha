package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.PersonDTO;
import com.br.gov.ms.campogrande.apiemha.mapper.PersonMapper;
import com.br.gov.ms.campogrande.apiemha.model.emha.Person;
import com.br.gov.ms.campogrande.apiemha.repository.emha.PersonRepository;
import com.br.gov.ms.campogrande.apiemha.service.CommercialModuleService;
import com.br.gov.ms.campogrande.apiemha.service.HousingComplexesService;
import com.br.gov.ms.campogrande.apiemha.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    private final CommercialModuleService commercialModuleService;
    private final HousingComplexesService housingComplexesService;

    @Override
    public Page<PersonDTO.Summary> findBenefitedSummary(String cpf, String name, Pageable pageable) {
        int limit = pageable.getPageSize();
        int offset = (int) pageable.getOffset();

        List<Person> people = personRepository.findAllWithFilters(cpf, name, limit, offset);
        long total = personRepository.countAllSummaryWithFilters(cpf, name);

        List<PersonDTO.Summary> summaries = people.stream().map(person -> {
            PersonDTO.Summary summary = personMapper.toSummary(person);
            Long personId = person.getId();

            summary.setCommercialModule(commercialModuleService.findByPerson(personId));
            summary.setHousingComplexesList(housingComplexesService.findAllByPerson(personId));

            return summary;
        }).toList();

        return new PageImpl<>(summaries, pageable, total);
    }

    @Override
    public PersonDTO findByCpf(String cpf) {
        return personRepository.findByCpf(cpf).map(personMapper::toDTO).orElse(null);
    }
}