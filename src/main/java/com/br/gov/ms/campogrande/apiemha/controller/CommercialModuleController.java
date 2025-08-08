package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.CommercialModuleService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commercial-module")
@RequiredArgsConstructor
@Tag(name = "Módulos Comerciais", description = "Operações relacionadas à listagem dos módulos comerciais disponíveis no sistema EMHA.")
public class CommercialModuleController {

    private final CommercialModuleService commercialModuleService;

    @GetMapping
    @Operation(summary = "Listar módulos comerciais", description = "Retorna todos os módulos comerciais cadastrados no sistema.")
    public ResponseEntity<Object> findAll() {
        return ResponseUtil.generateResponse(commercialModuleService.findAll(), HttpStatus.OK);
    }
}

