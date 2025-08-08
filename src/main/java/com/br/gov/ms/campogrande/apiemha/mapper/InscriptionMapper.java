package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.InscriptionDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Inscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { PersonOnlineMapper.class, EventComponentMapper.class })
public interface InscriptionMapper {

    InscriptionDTO toDTO(Inscription model);

    Inscription toModel(InscriptionDTO dto);
}