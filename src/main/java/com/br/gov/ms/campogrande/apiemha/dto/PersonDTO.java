package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String cpf;
    private String name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Summary {
        private Long id;
        private String name;
        private String formattedCpf;
        private String isBenefited;
        private String status;
        private CommercialModuleDTO commercialModule;
        private List<HousingComplexesDTO> housingComplexesList;
    }
}
