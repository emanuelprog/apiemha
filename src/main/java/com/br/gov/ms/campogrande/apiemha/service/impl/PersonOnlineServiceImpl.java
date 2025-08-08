package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.PersonOnlineDTO;
import com.br.gov.ms.campogrande.apiemha.exception.BadRequestException;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.PersonOnlineMapper;
import com.br.gov.ms.campogrande.apiemha.model.emha.Person;
import com.br.gov.ms.campogrande.apiemha.model.emha.PersonOnline;
import com.br.gov.ms.campogrande.apiemha.repository.emha.PersonOnlineRepository;
import com.br.gov.ms.campogrande.apiemha.repository.emha.PersonRepository;
import com.br.gov.ms.campogrande.apiemha.service.PersonOnlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonOnlineServiceImpl implements PersonOnlineService {

    private final PersonOnlineRepository personOnlineRepository;
    private final PersonOnlineMapper personOnlineMapper;

    private final PersonRepository personRepository;

    @Override
    public Page<PersonOnlineDTO.Summary> findRegisteredSummary(String cpf, String name, Pageable pageable) {
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;

        List<PersonOnline> results = personOnlineRepository.findAllPaginatedWithFilters(name, cpf, limit, offset);
        long total = personOnlineRepository.countAllWithFilters(name.isBlank() ? null : name, cpf.isBlank() ? null : cpf);

        List<PersonOnlineDTO.Summary> summaries = results.stream()
                .map(personOnlineMapper::toDTO)
                .map(personOnlineMapper::toSummary)
                .collect(Collectors.toList());

        return new PageImpl<>(summaries, pageable, total);
    }

    @Override
    public PersonOnlineDTO findPersonOnlineByFilters(String cpf, Long registrationPassword) {
        return personOnlineRepository.findPersonOnlineByCpfOrRegistrationPassword(cpf, registrationPassword)
                .map(personOnlineMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Nenhum cadastro encontrado"));
    }

    @Override
    public PersonOnlineDTO create(PersonOnlineDTO dto) {
        return Optional.of(dto)
                .map(personOnlineMapper::toModel)
                .map(this::linkAddressesToPersonOnline)
                .map(this::linkDependentsToPersonOnline)
                .map(this::saveInitial)
                .map(this::applyRegistrationPassword)
                .map(this::applyLegacySystemCode)
                .map(personOnlineRepository::save)
                .map(personOnlineMapper::toDTO)
                .orElseThrow(() -> new BadRequestException("Ocorreu algo inesperado, por gentileza tente novamente mais tarde."));
    }

    @Override
    public PersonOnlineDTO update(Long id, PersonOnlineDTO dto) {
        return personOnlineRepository.findById(id)
                .map(existing -> {
                    PersonOnline entity = personOnlineMapper.toModel(dto);

                    entity.setId(existing.getId());

                    linkAddressesToPersonOnline(entity);
                    linkDependentsToPersonOnline(entity);

                    return personOnlineMapper.toDTO(personOnlineRepository.save(entity));
                })
                .orElseThrow(() ->
                        new NotFoundException("Ocorreu algo inesperado, por gentileza tente novamente mais tarde.")
                );
    }

    private PersonOnline linkAddressesToPersonOnline(PersonOnline personOnline) {
        if (personOnline.getAddresses() != null) {
            personOnline.getAddresses().forEach(address -> address.setPersonOnline(personOnline));
        }
        return personOnline;
    }

    private PersonOnline linkDependentsToPersonOnline(PersonOnline personOnline) {
        if (personOnline.getDependents() != null) {
            personOnline.getDependents().forEach(dependent -> dependent.setPersonOnline(personOnline));
        }
        return personOnline;
    }

    private PersonOnline saveInitial(PersonOnline personOnline) {
        return personOnlineRepository.save(personOnline);
    }

    private PersonOnline applyRegistrationPassword(PersonOnline personOnline) {
        Long generated = generateProtocolPassword(personOnline.getId(), LocalDate.now());
        personOnline.setRegistrationPassword(generated);
        return personOnline;
    }

    private PersonOnline applyLegacySystemCode(PersonOnline personOnline) {
        Optional.ofNullable(personRepository.findByCpf(personOnline.getCpf()))
                .map(Person::getId)
                .ifPresent(personOnline::setLegacySystemCode);

        return personOnline;
    }

    private Long generateProtocolPassword(Long id, LocalDate date) {
        String prefix = date.format(DateTimeFormatter.ofPattern("yyyyMM"));
        return Long.valueOf("%s%06d".formatted(prefix, id));
    }
}