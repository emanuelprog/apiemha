package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO {

    private Long id;
    private HousingComplexesDTO housingComplexes;
    private String block;
    private String description;
    private String address;
    private Long addressNumber;
}
