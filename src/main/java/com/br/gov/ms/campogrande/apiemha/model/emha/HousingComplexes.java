package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhcnh", schema = "emha")
public class HousingComplexes {

    @Id
    @Column(name = "codcnh", nullable = false)
    private Long id; // Sequencial da tabela de conjuntos habitacionais

    @ManyToOne
    @JoinColumn(name = "codmdl")
    private CommercialModule commercialModule; // Sequencial da tabela modulos comerciais

    @Column(name = "chave_reg", nullable = false)
    private Long regionId; // Sequencial da tabela dne_gu_regioes

    @Column(name = "nomcnh", length = 120, nullable = false)
    private String description; // Nome do conjunto

    @Column(name = "vlacnh", precision = 14, scale = 2)
    private BigDecimal purchaseValue; // Valor da aquisição

    @Column(name = "argcnh", precision = 14, scale = 2)
    private BigDecimal glebeArea; // Área da gleba

    @Column(name = "arlcnh", precision = 14, scale = 2)
    private BigDecimal allottedArea; // Área loteada

    @Column(name = "adpcnh", precision = 14, scale = 2)
    private BigDecimal publicDomainArea; // Área de domínio público

    @Column(name = "arecnh", precision = 14, scale = 2)
    private BigDecimal reservedArea; // Área reservada

    @Column(name = "arucnh", precision = 14, scale = 2)
    private BigDecimal streetArea; // Área de ruas

    @Column(name = "dtacnh")
    private LocalDate acquisitionDate; // Data de aquisição

    @Column(name = "qtlcnh")
    private Long lotQuantity; // Quantidade de lotes

    @Column(name = "objcnh", length = 2000)
    private String objectClause; // Cláusula do objeto

    @Column(name = "carcnh", length = 2000)
    private String characteristic; // Característica

    @Column(name = "reacnh", length = 2000)
    private String readjustment; // Reajuste

    @Column(name = "tracnh", length = 2000)
    private String transfer; // Transferência

    @Column(name = "poscnh", length = 2000)
    private String ownership; // Posse

    @Column(name = "atvcnh", length = 1, nullable = false)
    private Character active; // Ativo S - Sim / N - Não

    @Column(name = "usualt", length = 150, nullable = false)
    private String lastModifiedBy; // Usuário inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime lastModifiedDate; // Data inclusão/alteração

    @Column(name = "minprz", nullable = false)
    private Long minimumInstallments; // Prazo mínimo

    @Column(name = "maxprz", nullable = false)
    private Long maximumInstallments; // Prazo máximo
}