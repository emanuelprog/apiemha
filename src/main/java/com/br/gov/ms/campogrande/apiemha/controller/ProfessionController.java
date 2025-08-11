package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.ProfessionService;
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
@RequestMapping("/profession")
@RequiredArgsConstructor
@Tag(name = "Profissões", description = "Operações relacionadas à listagem das profissões no sistema EMHA.")
public class ProfessionController {

    private final ProfessionService professionService;

    @GetMapping
    @Operation(summary = "Listar profissões", description = "Retorna todos os dados das profissões cadastradas no sistema.")
    public ResponseEntity<Object> findAll() {
        return ResponseUtil.generateResponse(professionService.findAll(), HttpStatus.OK);
    }
}

