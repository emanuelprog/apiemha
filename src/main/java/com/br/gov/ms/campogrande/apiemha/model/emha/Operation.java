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
@Table(name = "emhope", schema = "emha")
public class Operation {

    @Id
    @Column(name = "codope", nullable = false)
    private Long id; // Sequencial da tabela de operações

    @Column(name = "desope", length = 50, nullable = false)
    private String description; // Descrição da operação

    @Column(name = "usualt", length = 50, nullable = false)
    private String changeUser; // Usuário de inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data de inclusão/alteração
}
