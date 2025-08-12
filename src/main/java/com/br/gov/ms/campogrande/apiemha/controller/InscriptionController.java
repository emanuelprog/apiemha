package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.dto.InscriptionDTO;
import com.br.gov.ms.campogrande.apiemha.filter.PersonOnlineFilter;
import com.br.gov.ms.campogrande.apiemha.service.InscriptionService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscription")
@RequiredArgsConstructor
@Tag(name = "Inscrições", description = "Gerenciamento de inscrições no sistema EMHA, vinculadas a pessoas cadastradas.")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @GetMapping("/person-online")
    @Operation(summary = "Listar inscrições por pessoa", description = "Retorna todas as inscrições vinculadas a uma determinada pessoa cadastrada no sistema online.")
    public ResponseEntity<Object> findAllByPersonOnline(
            @Parameter(description = "ID da pessoa online cadastrada", required = true)
            @RequestParam Long personOnlineId
    ) {
        return ResponseUtil.generateResponse(inscriptionService.findAllByPersonOnline(personOnlineId), HttpStatus.OK);
    }

    @PostMapping("/spouse")
    @Operation(summary = "Listar inscrições por cônjuge e ID do componente do evento", description = "Retorna todas as inscrições vinculadas a um determinado cônjuge e ID do componente do evento cadastrados no sistema online.")
    public ResponseEntity<Object> findAllBySpouse(
            @Parameter(description = "Filtros de CPF")
            @RequestBody PersonOnlineFilter filter,
            @Parameter(description = "ID do componente do evento")
            @RequestParam Long eventComponentId
    ) {
        return ResponseUtil.generateResponse(inscriptionService.findAllBySpouseAndEventComponent(filter.getCpf(), eventComponentId), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova inscrição", description = "Realiza o cadastro de uma nova inscrição vinculada a uma pessoa.")
    public ResponseEntity<Object> createInscription(
            @RequestBody
            @Parameter(description = "Dados da inscrição a ser realizada") InscriptionDTO inscriptionDTO) {
        return ResponseUtil.generateResponse(
                inscriptionService.create(inscriptionDTO),
                HttpStatus.CREATED,
                "Inscrição realizada com sucesso!"
        );
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar inscrição existente",
            description = "Atualiza os dados de uma inscrição com base no ID informado."
    )
    public ResponseEntity<Object> updateInscription(
            @Parameter(description = "ID da inscrição que será atualizada", required = true)
            @PathVariable Long id,
            @RequestBody
            @Parameter(description = "Dados da inscrição a ser atualizada") InscriptionDTO inscriptionDTO) {
        return ResponseUtil.generateResponse(
                inscriptionService.update(id, inscriptionDTO),
                HttpStatus.OK,
                "Inscrição atualizada com sucesso!"
        );
    }
}