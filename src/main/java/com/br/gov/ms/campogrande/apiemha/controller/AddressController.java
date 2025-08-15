package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.AddressService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Tag(name = "Endereços", description = "Operações relacionadas à listagem de endereços no sistema EMHA.")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/zipCode")
    @Operation(summary = "Busca endereço por cep", description = "Retorna o endereço vinculado ao cep informado.")
    public ResponseEntity<Object> findByZipCode(
            @RequestParam
            @Parameter(description = "Cep") String zipCode) {
        return ResponseUtil.generateResponse(addressService.findByZipCode(zipCode), HttpStatus.OK);
    }
}

