package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long> {

    List<Debt> findByContractIdAndActiveFlagOrderByInstallmentNumberAsc(Long contractId, Character activeFlag);

    @Query("""
    SELECT d FROM Debt d
    WHERE d.contract.id = :contractId
      AND d.activeFlag = 'S'
      AND d.paymentDate IS NULL
""")
    List<Debt> findOpenActiveDebtsByContract(@Param("contractId") Long contractId);
}
