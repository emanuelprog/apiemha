package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhben", schema = "emha")
public class Benefit {

    @Id
    @Column(name = "codben", nullable = false)
    private Long benefitId; // Sequencial da tabela de benefícios

    @Column(name = "codprg", nullable = false)
    private Long programId; // Sequencial da tabela de Programas

    @ManyToOne
    @JoinColumn(name = "codcnh")
    private HousingComplexes housingComplexes; // Sequencial da tabela de conjuntos habitacionais

    @Column(name = "datben", nullable = false)
    private Date benefitDate; // Data do benefício

    @Column(name = "desben", length = 120, nullable = false)
    private String description; // Descrição do benefício

    @Column(name = "dtrben")
    private LocalDate responseDate; // Data de resposta

    @Column(name = "usualt", nullable = false)
    private String changeUser; // Usuário inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data inclusão/alteração

    @ManyToOne
    @JoinColumn(name = "codmdl")
    private CommercialModule commercialModule; // Código do módulo
}