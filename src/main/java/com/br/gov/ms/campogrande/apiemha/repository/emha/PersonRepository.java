package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = """
        SELECT * FROM (
            SELECT DISTINCT ON (pes.nompes) pes.*
            FROM emha.emhcnj cnj
            JOIN emha.emhctr ctr ON cnj.codpes = ctr.codpes
            JOIN emha.emhpes pes ON pes.codpes = cnj.codpes
            JOIN emha.emhmdl mdl on mdl.codmdl = ctr.codmdl
            WHERE LENGTH(pes.cpfpes) = 11
              AND pes.cpfpes NOT LIKE '00000000000'
              AND pes.cpfpes NOT LIKE '***********'
              AND (:cpf IS NULL OR REPLACE(REPLACE(REPLACE(pes.cpfpes, '.', ''), '-', ''), ' ', '') ILIKE CONCAT(:cpf, '%'))
              AND (:name IS NULL OR UNACCENT(UPPER(pes.nompes)) ILIKE CONCAT('%', UNACCENT(UPPER(:name)), '%'))

            UNION

            SELECT DISTINCT ON (pes.nompes) pes.*
            FROM emha.emhcnj cnj
            JOIN emha.emhctr ctr ON cnj.codpes = ctr.codpes
            JOIN emha.emhpes pes ON pes.codpes = cnj.concnj
            JOIN emha.emhmdl mdl on mdl.codmdl = ctr.codmdl
            WHERE LENGTH(pes.cpfpes) = 11
              AND pes.cpfpes NOT LIKE '00000000000'
              AND pes.cpfpes NOT LIKE '***********'
              AND (:cpf IS NULL OR REPLACE(REPLACE(REPLACE(pes.cpfpes, '.', ''), '-', ''), ' ', '') ILIKE CONCAT(:cpf, '%'))
              AND (:name IS NULL OR UNACCENT(UPPER(pes.nompes)) ILIKE CONCAT('%', UNACCENT(UPPER(:name)), '%'))

            UNION

            SELECT DISTINCT ON (pes.nompes) pes.*
            FROM emha.emhctr ctr
            JOIN emha.emhpes pes ON pes.codpes = ctr.codpes
            WHERE LENGTH(pes.cpfpes) = 11
              AND pes.cpfpes NOT LIKE '00000000000'
              AND pes.cpfpes NOT LIKE '***********'
              AND (:cpf IS NULL OR REPLACE(REPLACE(REPLACE(pes.cpfpes, '.', ''), '-', ''), ' ', '') ILIKE CONCAT(:cpf, '%'))
              AND (:name IS NULL OR UNACCENT(UPPER(pes.nompes)) ILIKE CONCAT('%', UNACCENT(UPPER(:name)), '%'))
        ) AS resultado
        ORDER BY nompes
        LIMIT :limit OFFSET :offset
        """, nativeQuery = true)
    List<Person> findAllWithFilters(
            @Param("cpf") String cpf,
            @Param("name") String name,
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    @Query(value = """
        SELECT COUNT(*) FROM (
            SELECT pes.codpes
            FROM emha.emhcnj cnj
            JOIN emha.emhctr ctr ON cnj.codpes = ctr.codpes
            JOIN emha.emhpes pes ON pes.codpes = cnj.codpes
            WHERE LENGTH(pes.cpfpes) = 11
              AND pes.cpfpes NOT LIKE '00000000000'
              AND pes.cpfpes NOT LIKE '***********'
              AND (:cpf IS NULL OR REPLACE(REPLACE(REPLACE(pes.cpfpes, '.', ''), '-', ''), ' ', '') ILIKE CONCAT(:cpf, '%'))
              AND (:name IS NULL OR UNACCENT(UPPER(pes.nompes)) ILIKE CONCAT('%', UNACCENT(UPPER(:name)), '%'))

            UNION

            SELECT pes.codpes
            FROM emha.emhcnj cnj
            JOIN emha.emhctr ctr ON cnj.codpes = ctr.codpes
            JOIN emha.emhpes pes ON pes.codpes = cnj.concnj
            WHERE LENGTH(pes.cpfpes) = 11
              AND pes.cpfpes NOT LIKE '00000000000'
              AND pes.cpfpes NOT LIKE '***********'
              AND (:cpf IS NULL OR REPLACE(REPLACE(REPLACE(pes.cpfpes, '.', ''), '-', ''), ' ', '') ILIKE CONCAT(:cpf, '%'))
              AND (:name IS NULL OR UNACCENT(UPPER(pes.nompes)) ILIKE CONCAT('%', UNACCENT(UPPER(:name)), '%'))

            UNION

            SELECT pes.codpes
            FROM emha.emhctr ctr
            JOIN emha.emhpes pes ON pes.codpes = ctr.codpes
            WHERE LENGTH(pes.cpfpes) = 11
              AND pes.cpfpes NOT LIKE '00000000000'
              AND pes.cpfpes NOT LIKE '***********'
              AND (:cpf IS NULL OR REPLACE(REPLACE(REPLACE(pes.cpfpes, '.', ''), '-', ''), ' ', '') ILIKE CONCAT(:cpf, '%'))
              AND (:name IS NULL OR UNACCENT(UPPER(pes.nompes)) ILIKE CONCAT('%', UNACCENT(UPPER(:name)), '%'))
        ) AS total
        """, nativeQuery = true)
    long countAllSummaryWithFilters(
            @Param("cpf") String cpf,
            @Param("name") String name
    );

    Optional<Person> findByCpf(String cpf);
}