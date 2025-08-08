package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.service.EventService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@Tag(name = "Eventos", description = "Operações para consulta de eventos públicos cadastrados no sistema EMHA, incluindo filtros por data de início e fim.")
public class EventController {

    private final EventService eventService;

    @GetMapping
    @Operation(summary = "Listar eventos com filtro de data", description = "Retorna os eventos cadastrados no sistema, podendo ser filtrados por data de início e/ou data de término.")
    public ResponseEntity<Object> findAll(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "Data inicial  do evento") LocalDate startDate,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "Data final  do evento") LocalDate endDate
    ) {
        return ResponseUtil.generateResponse(eventService.findAllByStartDateAndEndDate(startDate, endDate), HttpStatus.OK);
    }
}