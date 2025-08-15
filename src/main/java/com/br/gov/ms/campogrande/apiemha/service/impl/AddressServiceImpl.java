package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.AddressDTO;
import com.br.gov.ms.campogrande.apiemha.exception.NotFoundException;
import com.br.gov.ms.campogrande.apiemha.mapper.AddressMapper;
import com.br.gov.ms.campogrande.apiemha.repository.emha.AddressRepository;
import com.br.gov.ms.campogrande.apiemha.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressDTO findByZipCode(String zipCode) {
        return addressRepository.findByZipCode(zipCode)
                .stream()
                .findFirst()
                .map(addressMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
    }
}
