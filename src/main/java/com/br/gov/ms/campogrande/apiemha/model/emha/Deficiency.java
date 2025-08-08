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
@Table(name = "emhcif", schema = "emha")
public class Deficiency {

    @Id
    @Column(name = "codcif", nullable = false)
    private Long id; // Sequencial da tabela de deficiência.

    @Column(name = "descif", length = 1000, nullable = false)
    private String description; // Descrição da deficiencia.

    @Column(name = "gracif", length = 120, nullable = false)
    private String extension; // extensão da deficiencia

    @Column(name = "usualt", length = 30)
    private String changeUser; // Usuário de inclusão/alteração.

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data de inclusão/alteração.
}
