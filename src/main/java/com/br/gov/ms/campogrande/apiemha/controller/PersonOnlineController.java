package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.dto.PersonOnlineDTO;
import com.br.gov.ms.campogrande.apiemha.filter.PersonOnlineFilter;
import com.br.gov.ms.campogrande.apiemha.service.PersonOnlineService;
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
@RequestMapping("/person-online")
@RequiredArgsConstructor
@Tag(name = "Cadastro Online de Pessoas", description = "Endpoints para cadastro, consulta e emissão de segunda via de senhas de pessoas cadastradas online")
public class PersonOnlineController {

    private final PersonOnlineService personOnlineService;

    @PostMapping("/registered")
    @Operation(summary = "Buscar pessoas cadastradas", description = "Retorna uma lista paginada de pessoas cadastradas online, filtrando por CPF ou nome.")
    public ResponseEntity<Object> findRegistered(
            @RequestBody
            @Parameter(description = "Filtros de nome e/ou CPF") PersonOnlineFilter filter,

            @RequestParam(defaultValue = "0")
            @Parameter(description = "Número da página para paginação (inicia em 0)") int page,

            @RequestParam(defaultValue = "10")
            @Parameter(description = "Tamanho da página") int size
    ) {
        return ResponseUtil.generateResponse(personOnlineService.findRegisteredSummary(filter.getCpf(), filter.getName(), PageRequest.of(page, size)), HttpStatus.OK);
    }

    @PostMapping("/second-copy")
    @Operation(summary = "Emitir segunda via da senha de inscrição", description = "Consulta por CPF e senha de inscrição para permitir a emissão da segunda via.")
    public ResponseEntity<Object> findSecondCopy(
            @RequestBody
            @Parameter(description = "Filtros de CPF e senha de inscrição") PersonOnlineFilter filter
    ) {
        return ResponseUtil.generateResponse(personOnlineService.findPersonOnlineByFilters(filter.getCpf(),filter.getRegistrationPassword()), HttpStatus.OK);
    }

    @PostMapping("/spouse")
    @Operation(summary = "Busca o cônjuge do titular", description = "Consulta por CPF para verificar se o titular já possui cônjuge cadastrado.")
    public ResponseEntity<Object> findSpouse(
            @RequestBody
            @Parameter(description = "Filtros de CPF") PersonOnlineFilter filter
    ) {
        return ResponseUtil.generateResponse(personOnlineService.findPersonOnlineBySpouse(filter.getCpf()), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova pessoa online", description = "Realiza o cadastro de uma nova pessoa no sistema de inscrição online.")
    public ResponseEntity<Object> createPersonOnline(
            @RequestBody
            @Parameter(description = "Dados da pessoa a ser cadastrada") PersonOnlineDTO personOnlineDTO
    ) {
        return ResponseUtil.generateResponse(personOnlineService.create(personOnlineDTO), HttpStatus.CREATED, "Cadastro criado com sucesso!");
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Atualizar cadastro da pessoa", description = "Atualiza os dados de uma pessoa cadastrada online com base no ID fornecido.")
    public ResponseEntity<Object> updatePersonOnline(
            @PathVariable
            @Parameter(description = "ID da pessoa cadastrada") Long id,

            @RequestBody
            @Parameter(description = "Novos dados da pessoa") PersonOnlineDTO personOnlineDTO
    ) {
        return ResponseUtil.generateResponse(personOnlineService.update(id, personOnlineDTO), HttpStatus.OK, "Cadastro atualizado com sucesso!");
    }
}