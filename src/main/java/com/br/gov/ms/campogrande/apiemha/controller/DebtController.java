package com.br.gov.ms.campogrande.apiemha.controller;

import com.br.gov.ms.campogrande.apiemha.dto.DebtDTO;
import com.br.gov.ms.campogrande.apiemha.service.DebtService;
import com.br.gov.ms.campogrande.apiemha.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/debt")
@RequiredArgsConstructor
@Tag(name = "Dívidas", description = "Consulta dívidas associadas a contratos no sistema EMHA.")
public class DebtController {

    private final DebtService debtService;

    @GetMapping("/contract")
    @Operation(summary = "Buscar dívidas por contrato", description = "Retorna todas as dívidas vinculadas ao contrato informado pelo ID.")
    public ResponseEntity<Object> findDebtsByContract(
            @RequestParam
            @Parameter(description = "ID da do contrato", required = true) Long contractId) {
        return ResponseUtil.generateResponse(debtService.getDebtByContract(contractId), HttpStatus.OK);
    }

    @PostMapping("/second-copy")
    @Operation(summary = "Gera a segunda via a partir dos extratos", description = "Retorna a url da segunda via com base nos extratos.")
    public ResponseEntity<Object> generateSecondCopy(
            @RequestBody
            @Parameter(description = "Extratos para gerar a segunda via") List<DebtDTO> debtsDTO) {
        return ResponseUtil.generateResponse(debtService.generateSecondCopy(debtsDTO), HttpStatus.OK);
    }

    @PostMapping("/slip")
    @Operation(summary = "Gera o carnê a partir dos extratos", description = "Retorna a url do carnê com base nos extratos.")
    public ResponseEntity<Object> generateSlip(
            @RequestBody
            @Parameter(description = "Extratos para gerar o carnê") List<DebtDTO> debtsDTO) {
        return ResponseUtil.generateResponse(debtService.generateSlip(debtsDTO), HttpStatus.OK);
    }

    @GetMapping("/extract")
    @Operation(summary = "Gera o extrato a partir do ID do contrato", description = "Retorna a url do extrato com base no ID do contrato.")
    public ResponseEntity<Object> generateExtract(
            @RequestParam
            @Parameter(description = "ID do contrato") Long contractId) {
        return ResponseUtil.generateResponse(debtService.generateExtract(contractId), HttpStatus.OK);
    }
}