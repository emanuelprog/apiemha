package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexDTO {

    private Long id;
    private LocalDate referenceDate;
    private ChartDTO chart;
    private BigDecimal salaryValue;
    private BigDecimal maxAboveSalary;
    private BigDecimal minAboveSalary;
    private BigDecimal contractEntryRequirement;
    private Long year;
    private BigDecimal discountPercentage;
    private BigDecimal firstInstallmentPeriod;
    private BigDecimal annualAdjustment;
    private BigDecimal funafDiscount;
    private BigDecimal minimumPropertyImplantationDiscount;
    private BigDecimal maximumPropertyImplantationDiscount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
    private BigDecimal minContractValueForDiscount;
    private BigDecimal maxContractValueForDiscount;
}
