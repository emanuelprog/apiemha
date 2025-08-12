package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.filter.PersonOnlineFilter;
import com.br.gov.ms.campogrande.apiemha.service.BenefitedService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/benefited")
@RequiredArgsConstructor
@Tag(name = "Beneficiados", description = "Controlador responsável por consultar se uma pessoa foi beneficiada em programas habitacionais do sistema EMHA.")
public class BenefitedController {

    private final BenefitedService benefitedService;

    @PostMapping("/person-online")
    @Operation(summary = "Verificar se pessoa ou cônjuge foi beneficiada", description = "Retorna uma lista de vínculos de beneficiado para a pessoa ou cônjuge informada.")
    public ResponseEntity<Object> findBenefitedsByPersonOnline(
            @RequestBody
            @Parameter(description = "Filtros de CPF") PersonOnlineFilter filter) {
        return ResponseUtil.generateResponse(benefitedService.findAllByPersonOnline(filter.getCpf()), HttpStatus.OK);
    }
}