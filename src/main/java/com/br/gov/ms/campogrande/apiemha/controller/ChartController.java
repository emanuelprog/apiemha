package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.ChartService;
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
@RequestMapping("/chart")
@RequiredArgsConstructor
@Tag(name = "Tabelas", description = "Operações relacionadas à listagem das tabelas no sistema EMHA.")
public class ChartController {

    private final ChartService chartService;

    @GetMapping
    @Operation(summary = "Listar tabelas por tipo", description = "Retorna todos os dados da tabela por tipo cadastrados no sistema.")
    public ResponseEntity<Object> findAllByChartType(
            @RequestParam
            @Parameter(description = "Tipo da tabela") String chartType) {
        return ResponseUtil.generateResponse(chartService.findAllByChartType(chartType), HttpStatus.OK);
    }
}

