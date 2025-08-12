package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.PersonOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonOnlineRepository extends JpaRepository<PersonOnline, Long> {

    @Query(value = """
    SELECT DISTINCT onl.* FROM emha.emhonl onl
    LEFT JOIN emha.emhpes pes ON pes.cpfpes = onl.cpfonl
    WHERE (:nome IS NULL OR UNACCENT(lower(onl.nomonl)) LIKE UNACCENT(lower(CONCAT('%', :nome, '%'))))
    AND (:cpf IS NULL OR onl.cpfonl LIKE CONCAT('%', :cpf, '%'))
    AND NOT EXISTS (
        SELECT 1 FROM emha.emhctr ctr WHERE ctr.codpes = pes.codpes
    )
    ORDER BY onl.nomonl
    LIMIT :limit OFFSET :offset
""", nativeQuery = true)
    List<PersonOnline> findAllPaginatedWithFilters(
            @Param("nome") String nome,
            @Param("cpf") String cpf,
            @Param("limit") int limit,
            @Param("offset") int offset
    );


    @Query(value = """
    SELECT COUNT(DISTINCT onl.nomonl) FROM emha.emhonl onl
    LEFT JOIN emha.emhpes pes ON pes.cpfpes = onl.cpfonl
    WHERE (:nome IS NULL OR UNACCENT(lower(onl.nomonl)) LIKE UNACCENT(lower(CONCAT('%', :nome, '%'))))
    AND (:cpf IS NULL OR onl.cpfonl LIKE CONCAT('%', :cpf, '%'))
    AND NOT EXISTS (
        SELECT 1 FROM emha.emhctr ctr WHERE ctr.codpes = pes.codpes
    )
""", nativeQuery = true)
    long countAllWithFilters(
            @Param("nome") String nome,
            @Param("cpf") String cpf
    );

    Optional<PersonOnline> findPersonOnlineByCpfOrRegistrationPassword(String cpf, Long registrationPassword);

    Optional<PersonOnline> findPersonOnlineBySpouseCpf(String cpf);
}