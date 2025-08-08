package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitDTO {

    private Long benefitId;
    private Long programId;
    private HousingComplexesDTO housingComplexes;
    private Date benefitDate;
    private String description;
    private LocalDate responseDate;
    private CommercialModuleDTO commercialModule;
}
