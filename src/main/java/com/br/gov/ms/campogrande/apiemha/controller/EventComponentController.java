package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.EventComponentService;
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
@RequestMapping("/event-component")
@RequiredArgsConstructor
@Tag(name = "Componentes do Evento", description = "Operações para consulta de componentes do evento cadastrado no sistema EMHA")
public class EventComponentController {

    private final EventComponentService eventComponentService;

    @GetMapping("/event")
    @Operation(summary = "Listar módulos por evento", description = "Retorna os módulos vinculados ao evento informado pelo ID.")
    public ResponseEntity<Object> findAllByEvent(
            @RequestParam
            @Parameter(description = "ID do evento") Long eventId) {
        return ResponseUtil.generateResponse(eventComponentService.findAllByEvent(eventId), HttpStatus.OK);
    }
}