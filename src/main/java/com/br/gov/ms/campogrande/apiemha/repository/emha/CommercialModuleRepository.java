package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.CommercialModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommercialModuleRepository extends JpaRepository<CommercialModule, Long> {

    @Query("""
    SELECT c.commercialModule
    FROM Contract c
    WHERE c.person.id = :personId
    ORDER BY c.id
""")
    Optional<CommercialModule> findFirstCommercialModuleByPersonId(@Param("personId") Long personId);
}
