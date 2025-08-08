package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.BenefitedService;
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
@RequestMapping("/benefited")
@RequiredArgsConstructor
@Tag(name = "Beneficiados", description = "Controlador responsável por consultar se uma pessoa foi beneficiada em programas habitacionais do sistema EMHA.")
public class BenefitedController {

    private final BenefitedService benefitedService;

    @GetMapping("/person")
    @Operation(summary = "Verificar se pessoa foi beneficiada", description = "Retorna uma lista de vínculos de beneficiado para a pessoa informada, com base no ID da pessoa fornecido como parâmetro.")
    public ResponseEntity<Object> findBenefitedsByPerson(
            @RequestParam
            @Parameter(description = "ID da pessoa") Long personId) {
        return ResponseUtil.generateResponse(benefitedService.findAllByPerson(personId), HttpStatus.OK);
    }
}