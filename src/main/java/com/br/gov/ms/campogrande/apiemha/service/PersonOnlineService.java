package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.PersonOnlineDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PersonOnlineService {

    Page<PersonOnlineDTO.Summary> findRegisteredSummary(String cpf, String name, Pageable pageable);

    PersonOnlineDTO findPersonOnlineByFilters(String cpf, Long registrationPassword);

    PersonOnlineDTO findPersonOnlineBySpouse(String cpf);

    PersonOnlineDTO create(PersonOnlineDTO personOnlineDTO);

    PersonOnlineDTO update(Long id, PersonOnlineDTO personOnlineDTO);
}
