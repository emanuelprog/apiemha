package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependentDTO {

    private Long id;
    private Long totalDependents;
    private Long under14;
    private Long over60;
    private Long totalWithDisability;
    private Boolean hasWheelchairDependent;
    private Boolean hasMotorDisability;
    private Boolean hasPhysicalDisability;
    private Boolean hasHearingDisability;
    private Boolean hasVisualDisability;
    private Boolean hasMultipleDisabilities;
    private Boolean hasOtherDisabilities;
    private String descriptionOfDisabilities;
    private String dependentsWithDisabilitiesNames;
    private Long totalChronicDiseases;
    private Boolean hasMentalDisability;
    private Boolean hasMicrocephaly;
    private Boolean hasDisablingChronicDisease;
    private Boolean hasCancer;
    private Boolean hasDegenerativeDisease;
    private LocalDateTime updatedAt;
}
