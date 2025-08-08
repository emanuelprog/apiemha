package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitedDTO {

    private Long id;
    private PersonDTO person;
    private String benefited;
    private String nonBenefitReason;
    private BenefitDTO benefit;
    private Long companyCode;
}
