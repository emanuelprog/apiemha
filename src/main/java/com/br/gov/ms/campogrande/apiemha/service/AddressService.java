package com.br.gov.ms.campogrande.apiemha.service;

import com.br.gov.ms.campogrande.apiemha.dto.AddressDTO;

public interface AddressService {

    AddressDTO findByZipCode(String zipCode);
}
