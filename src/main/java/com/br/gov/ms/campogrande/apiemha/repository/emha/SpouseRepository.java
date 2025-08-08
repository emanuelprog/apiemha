package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpouseRepository extends JpaRepository<Spouse, Long> {

    Optional<Spouse> findBySpouseId(Long spouseId);
}
