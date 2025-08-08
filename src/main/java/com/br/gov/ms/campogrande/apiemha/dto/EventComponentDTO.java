package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventComponentDTO {

    private Long id;
    private CommercialModuleDTO commercialModule;
    private Long housingComplexId;
    private Long housingQuantity;
    private String description;
}
