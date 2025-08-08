package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Benefited;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenefitedRepository extends JpaRepository<Benefited, Long> {

    List<Benefited> findAllByPerson_Id(Long personId);
}
