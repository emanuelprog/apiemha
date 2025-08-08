package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.HousingComplexes;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingComplexesRepository extends JpaRepository<HousingComplexes, Long> {

    List<HousingComplexes> findAllByCommercialModuleId(Long commercialModuleId, Sort id);

    @Query("""
    SELECT DISTINCT c.housingComplexes
    FROM Contract c
    WHERE c.person.id = :personId
""")
    List<HousingComplexes> findHousingComplexesByPersonId(@Param("personId") Long personId);
}
