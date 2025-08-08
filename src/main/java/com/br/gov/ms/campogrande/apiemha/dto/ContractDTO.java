package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {

    private Long id;
    private Long number;
    private Long sequence;
    private LocalDate contractDate;
    private CommercialModuleDTO commercialModule;
    private HousingComplexesDTO housingComplexes;
    private BatchDTO batch;
    private PersonDTO person;
    private Character socialGuarantee;
    private Character charge;
    private String nonChargeReason;
    private LotteryNotesDTO lotteryNotes;
    private BigDecimal squareMeterValue;
    private BigDecimal propertyValue;
    private BigDecimal compensationValue;
    private BigDecimal financedValue;
    private ChartDTO chart;
    private IndexDTO index;
    private OperationDTO operation;
    private BigDecimal installmentValue;
    private BigDecimal entryValue;
    private Long chosenInstallmentDueDay;
    private String term;
}
