package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.InscriptionDTO;
import com.br.gov.ms.campogrande.apiemha.dto.PersonOnlineDTO;
import com.br.gov.ms.campogrande.apiemha.exception.AlreadyExistsException;
import com.br.gov.ms.campogrande.apiemha.exception.BadRequestException;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.InscriptionMapper;
import com.br.gov.ms.campogrande.apiemha.model.emha.Inscription;
import com.br.gov.ms.campogrande.apiemha.model.emha.PersonOnline;
import com.br.gov.ms.campogrande.apiemha.repository.emha.InscriptionRepository;
import com.br.gov.ms.campogrande.apiemha.repository.emha.PersonOnlineRepository;
import com.br.gov.ms.campogrande.apiemha.service.InscriptionService;
import com.br.gov.ms.campogrande.apiemha.service.PersonOnlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final InscriptionMapper inscriptionMapper;

    private final PersonOnlineService personOnlineService;
    private final PersonOnlineRepository personOnlineRepository;

    @Override
    public List<InscriptionDTO> findAllByPersonOnline(Long personOnlineId) {
        return Optional.of(inscriptionRepository.findAllByPersonOnline_Id(personOnlineId))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException("Nenhuma inscrição encontrada!"))
                .stream()
                .map(inscriptionMapper::toDTO)
                .toList();
    }

    @Override
    public List<InscriptionDTO> findAllBySpouseAndEventComponent(String cpf, Long eventComponentId) {
        Optional<PersonOnline> personOnline = personOnlineRepository.findPersonOnlineByCpfOrRegistrationPassword(cpf, null);

        if (personOnline.isEmpty()) {
            return null;
        } else {
            Optional<PersonOnline> spouse = personOnlineRepository.findPersonOnlineByCpfOrRegistrationPassword(personOnline.get().getSpouseCpf(), null);

            if (spouse.isEmpty()) {
                return null;
            }

            List<Inscription> inscriptions = inscriptionRepository.findAllByPersonOnline_IdAndEventComponent_Id(spouse.get().getId(), eventComponentId);

            if (!inscriptions.isEmpty()) {
                throw new AlreadyExistsException("Não é possível realizar a inscrição. CPF já cadastrado como cônjuge de um inscrito!");
            }
        }

        return null;
    }

    @Override
    public InscriptionDTO create(InscriptionDTO dto) {
        dto.setPersonOnline(resolvePersonOnline(dto.getPersonOnline()));

        Inscription entity = inscriptionMapper.toModel(dto);

        return inscriptionMapper.toDTO(inscriptionRepository.save(entity));
    }

    @Override
    public InscriptionDTO update(Long id, InscriptionDTO dto) {
        return inscriptionRepository.findById(id)
                .map(existing -> {
                    dto.setPersonOnline(resolvePersonOnline(dto.getPersonOnline()));

                    Inscription entity = inscriptionMapper.toModel(dto);
                    entity.setId(id);

                    return inscriptionMapper.toDTO(inscriptionRepository.save(entity));
                })
                .orElseThrow(() -> new NotFoundException("Ocorreu algo inesperado, por gentileza tente novamente mais tarde."));
    }

    private PersonOnlineDTO resolvePersonOnline(PersonOnlineDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Ocorreu algo inesperado, por gentileza tente novamente mais tarde.");
        }

        return (dto.getId() == null)
                ? personOnlineService.create(dto)
                : personOnlineService.update(dto.getId(), dto);
    }
}
