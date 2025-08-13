package com.br.gov.ms.campogrande.apiemha.service.impl;

import com.br.gov.ms.campogrande.apiemha.dto.BenefitedDTO;
import com.br.gov.ms.campogrande.apiemha.dto.ContractDTO;
import com.br.gov.ms.campogrande.apiemha.dto.PersonDTO;
import com.br.gov.ms.campogrande.apiemha.exception.AlreadyExistsException;
import com.br.gov.ms.campogrande.apiemha.model.emha.Benefited;
import com.br.gov.ms.campogrande.apiemha.repository.emha.BenefitedRepository;
import com.br.gov.ms.campogrande.apiemha.service.BenefitedService;
import com.br.gov.ms.campogrande.apiemha.service.ContractService;
import com.br.gov.ms.campogrande.apiemha.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitedServiceImpl implements BenefitedService {

    private final BenefitedRepository benefitedRepository;

    private final PersonService personService;
    private final ContractService contractService;

    @Override
    public List<BenefitedDTO> findAllByPersonOnline(String cpf) {
        PersonDTO personDTO = personService.findByCpf(cpf);

        if (personDTO != null) {
            List<ContractDTO> contracts = contractService.findContractsByPerson(personDTO.getId());
            List<Benefited> benefiteds = benefitedRepository.findAllByPerson_IdAndAndBenefited(personDTO.getId(), "S");

            if (!contracts.isEmpty() || !benefiteds.isEmpty()) {
                throw new AlreadyExistsException("CPF já beneficiado!");
            }
        }

        return null;
    }
}
