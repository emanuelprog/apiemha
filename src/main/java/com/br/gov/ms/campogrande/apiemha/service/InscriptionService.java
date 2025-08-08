package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.InscriptionDTO;

import java.util.List;

public interface InscriptionService {

    List<InscriptionDTO> findAllByPersonOnline(Long personOnlineId);

    InscriptionDTO create(InscriptionDTO inscriptionDTO);

    InscriptionDTO update(Long id, InscriptionDTO inscriptionDTO);
}
