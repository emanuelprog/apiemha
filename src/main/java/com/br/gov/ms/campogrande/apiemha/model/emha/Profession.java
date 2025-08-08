package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhpro", schema = "emha")
public class Profession {

    @Id
    @Column(name = "codpro")
    private Long id; // Sequencial da tabela de profissão.

    @Column(name = "despro", length = 120, nullable = false)
    private String description; // Descrição da profissão.

    @Column(name = "atvpro", length = 1, nullable = false)
    private String status; // S - Ativo / N - Inativo

    @Column(name = "usualt", length = 30)
    private String changeUser; // Usuário de inclusão/alteração.

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data de inclusão/alteração.
}
