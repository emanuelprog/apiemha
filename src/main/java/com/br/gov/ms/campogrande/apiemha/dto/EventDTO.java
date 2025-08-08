package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String descriptionText;
    private String schedule;
    private String location;
    private LocalDateTime eventDateTime;
    private String observations;
    private Boolean nisRequired;
    private List<EventComponentDTO> eventComponents;
}
