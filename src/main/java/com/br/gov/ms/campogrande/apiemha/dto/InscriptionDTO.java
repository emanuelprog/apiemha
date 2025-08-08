package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionDTO {

    private Long id;
    private PersonOnlineDTO personOnline;
    private EventComponentDTO eventComponent;
    private String registrationProtocol;
    private String changeUser;
    private Boolean active;
    private LocalDateTime updatedAt;
}
