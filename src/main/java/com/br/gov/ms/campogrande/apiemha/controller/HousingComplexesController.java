package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.HousingComplexesService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/housing-complexes")
@RequiredArgsConstructor
@Tag(name = "Conjuntos Habitacionais", description = "Operações para listagem de conjuntos habitacionais cadastrados no sistema EMHA, com ou sem filtro por módulo comercial.")
public class HousingComplexesController {

    private final HousingComplexesService housingComplexesService;

    @GetMapping
    @Operation(summary = "Listar todos os conjuntos habitacionais", description = "Retorna todos os conjuntos habitacionais cadastrados no sistema, sem filtros.")
    public ResponseEntity<Object> findAll() {
        return ResponseUtil.generateResponse(housingComplexesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/commercial-module")
    @Operation(summary = "Listar conjuntos por módulo comercial", description = "Retorna os conjuntos habitacionais vinculados ao módulo comercial informado pelo ID.")
    public ResponseEntity<Object> findAllByCommercialModule(
            @RequestParam
            @Parameter(description = "ID do módulo comercial") Long commercialModuleId) {
        return ResponseUtil.generateResponse(
                housingComplexesService.findAllByCommercialModule(commercialModuleId),
                HttpStatus.OK
        );
    }
}