package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhbep", schema = "emha")
public class Benefited {

    @Id
    @Column(name = "codbep", nullable = false)
    private Long id; // Sequencial da tabela de pessoas do envio

    @ManyToOne
    @JoinColumn(name = "codpes")
    private Person person; // Sequencial da tabela de pessoas

    @Column(name = "benbep", length = 1)
    private String benefited; // Beneficiado - Sim / Não

    @Column(name = "motbep", length = 20)
    private String nonBenefitReason; // Motivo do não benefício

    @Column(name = "usualt")
    private String changeUser; // Usuário inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data inclusão/alteração

    @ManyToOne
    @JoinColumn(name = "codben")
    private Benefit benefit; // Código do benefício

    @Column(name = "codcpj")
    private Long companyCode; // Sequencial da tabela de CNPJ
}