package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.LotteryNotesDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.LotteryNotes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LotteryNotesMapper {

    LotteryNotesDTO toDTO(LotteryNotes model);

    LotteryNotes toModel(LotteryNotesDTO dto);
}