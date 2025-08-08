package com.br.gov.ms.campogrande.apiemha.feign;

import com.br.gov.ms.campogrande.apiemha.dto.DebtDTO;
import com.br.gov.ms.campogrande.apiemha.dto.UrlDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "debtClient", url = "${services.emha-api}")
public interface DebtClient {

    @PostMapping(value = "/portal/segunda-via", consumes = MediaType.APPLICATION_JSON_VALUE)
    UrlDTO getSecondCopy(@RequestBody List<DebtDTO.SecondCopy> extracts);

    @PostMapping(value = "/portal/carne", consumes = MediaType.APPLICATION_JSON_VALUE)
    UrlDTO getSlip(@RequestBody List<DebtDTO.SecondCopy> extracts);

    @GetMapping(value = "/portal/extrato-imprimir/{codigoContrato}", consumes = MediaType.APPLICATION_JSON_VALUE)
    UrlDTO getExtract(@PathVariable("codigoContrato") Long contractId);
}
