package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.filter.PersonFilter;
import com.br.gov.ms.campogrande.apiemha.service.PersonService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@Tag(name = "Pessoas", description = "Operações relacionadas à busca e consulta de pessoas beneficiadas no sistema EMHA")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/benefiteds")
    @Operation(summary = "Buscar beneficiados por CPF ou nome", description = "Retorna uma lista paginada de pessoas beneficiadas com base no CPF ou nome informados como filtro.")
    public ResponseEntity<Object> findBenefited(
            @RequestBody
            @Parameter(description = "Objeto contendo CPF e/ou nome para filtro da consulta") PersonFilter filter,

            @RequestParam(defaultValue = "0")
            @Parameter(description = "Número da página para paginação (inicia em 0)") int page,

            @RequestParam(defaultValue = "10")
            @Parameter(description = "Tamanho da página para paginação") int size
    ) {
        return ResponseUtil.generateResponse(personService.findBenefitedSummary(filter.getCpf(), filter.getName(), PageRequest.of(page, size)), HttpStatus.OK);
    }
}