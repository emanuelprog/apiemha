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
@Table(name = "emhmdl", schema = "emha")
public class CommercialModule {

    @Id
    @Column(name = "codmdl", nullable = false)
    private Long id; // Sequencial da tabela módulos comerciais

    @Column(name = "desmdl", length = 120, nullable = false)
    private String description; // Descrição do módulo comercial

    @Column(name = "usualt", length = 30, nullable = false)
    private String changeUser; // Usuário de inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data de inclusão/alteração

    @Column(name = "pdemdl", length = 1, nullable = false)
    private Character hasDiscount; // Possui desconto nas parcelas? (Sim/Nao)

    @Column(name = "qtbmdl")
    private Long bonusInstallmentsQuantity; // Quantidade de Parcelas Bônus
}