package com.br.gov.ms.campogrande.apiemha.filter;

import lombok.Data;

@Data
public class PersonOnlineFilter {
    private String cpf;
    private String name;
    private Long registrationPassword;
}
