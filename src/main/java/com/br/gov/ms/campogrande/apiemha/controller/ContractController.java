package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.ContractService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
@Tag(name = "Contratos", description = "Gerencia e consulta contratos vinculados a pessoas, módulos comerciais e conjuntos habitacionais.")
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    @Operation(summary = "Listar todos os contratos", description = "Retorna todos os contratos cadastrados no sistema.")
    public ResponseEntity<Object> findAll() {
        return ResponseUtil.generateResponse(contractService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    @Operation(summary = "Buscar contrato por filtros", description = "Retorna um contrato com base no número, ID do conjunto habitacional e ID do módulo comercial informados.")
    public ResponseEntity<Object> findContractByFilters(
            @RequestParam
            @Parameter(description = "Número do contrato") Long number,

            @RequestParam
            @Parameter(description = "ID do conjunto habitacional") Long housingComplexesId,

            @RequestParam
            @Parameter(description = "ID do módulo comercial") Long commercialModuleId
    ) {
        return ResponseUtil.generateResponse(contractService.findContractByFilters(number, housingComplexesId, commercialModuleId), HttpStatus.OK);
    }

    @GetMapping("/person")
    @Operation(summary = "Listar contratos por pessoa", description = "Retorna todos os contratos associados à pessoa informada por meio do seu ID.")
    public ResponseEntity<Object> findContractByPerson(
            @RequestParam
            @Parameter(description = "ID da pessoa") Long personId) {
        return ResponseUtil.generateResponse(contractService.findContractsByPerson(personId), HttpStatus.OK);
    }
}