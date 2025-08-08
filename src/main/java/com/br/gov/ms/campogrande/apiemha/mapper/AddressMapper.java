package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.AddressDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { PersonOnlineMapper.class })
public interface AddressMapper {

    AddressDTO toDTO(Address model);

    Address toModel(AddressDTO dto);
}