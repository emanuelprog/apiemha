package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhcnj", schema = "emha")
public class Spouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcnj", nullable = false)
    private Long id; // Sequencial da tabela de cônjuge

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codpes", nullable = false)
    private Person person; // Sequencial da tabela de pessoas. Código do titular

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concnj", nullable = false)
    private Person spouse; // Código do cônjuge (referencia a tabela de pessoas)

    @Column(name = "codtab")
    private Long civilStatusId; // Estado civil (ESTCIV)

    @Column(name = "inicnj")
    private LocalDate startDate; // Data de início

    @Column(name = "fimcnj")
    private LocalDate endDate; // Data de fim

    @Column(name = "usualt", length = 30)
    private String changeUser; // Usuário de inclusão/alteração

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data de inclusão/alteração

    @Column(name = "depcnj", length = 1)
    private String spouseDependent; // Cônjuge é dependente (N/S)

    @Column(name = "exccnj")
    private Boolean excluded; // Cônjuge excluído true/false
}