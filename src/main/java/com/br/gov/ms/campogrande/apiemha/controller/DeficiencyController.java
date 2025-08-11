package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.DeficiencyService;
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
@RequestMapping("/deficiency")
@RequiredArgsConstructor
@Tag(name = "Deficiências", description = "Operações relacionadas à listagem das deficiências no sistema EMHA.")
public class DeficiencyController {

    private final DeficiencyService deficiencyService;

    @GetMapping
    @Operation(summary = "Listar deficiências", description = "Retorna todos os dados das deficiências cadastradas no sistema.")
    public ResponseEntity<Object> findAll() {
        return ResponseUtil.generateResponse(deficiencyService.findAll(), HttpStatus.OK);
    }
}

