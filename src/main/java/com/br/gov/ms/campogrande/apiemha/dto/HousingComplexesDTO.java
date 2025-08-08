package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HousingComplexesDTO {

    private Long id;
    private CommercialModuleDTO commercialModule;
    private String description;
}
