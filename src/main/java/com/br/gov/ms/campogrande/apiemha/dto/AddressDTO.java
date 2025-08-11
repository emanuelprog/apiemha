package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String zipCode;
    private String street;
    private String city;
    private String region;
    private String neighborhood;
    private String number;
    private String complement;
}
