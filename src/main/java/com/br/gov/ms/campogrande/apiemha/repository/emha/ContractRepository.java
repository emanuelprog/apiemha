package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = """
    SELECT * FROM emha.emhctr\s
    WHERE numctr = :number\s
      AND codcnh = :housingComplexesId\s
      AND codmdl = :commercialModuleId\s
    ORDER BY seqctr DESC\s
    LIMIT 1
   \s""", nativeQuery = true)
    Optional<Contract> findLastContract(
            @Param("number") Long number,
            @Param("housingComplexesId") Long housingComplexesId,
            @Param("commercialModuleId") Long commercialModuleId
    );

    List<Contract> findAllByPerson_Id(Long personId);
}
