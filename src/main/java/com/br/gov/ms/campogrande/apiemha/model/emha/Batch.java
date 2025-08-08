package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhlte", schema = "emha")
public class Batch {

    @Id
    @Column(name = "codlte", nullable = false)
    private Long id; // Sequencial da tabela de lotes

    @ManyToOne
    @JoinColumn(name = "codcnh")
    private HousingComplexes housingComplexes; // Sequencial da tabela de conjuntos habitacionais

    @Column(name = "qualte", length = 25)
    private String block; // Quadra

    @Column(name = "lotlte", length = 25)
    private String description; // Lote

    @Column(name = "squlte", length = 10)
    private String blockAbbreviation; // Sigla da quadra

    @Column(name = "slolte", length = 10)
    private String batchAbbreviation; // Sigla do lote

    @Column(name = "arrlte", precision = 14, scale = 2)
    private BigDecimal area; // Área

    @Column(name = "ti1lte")
    private Long propertyTypeId1; // Sequencial da tabela tipo de imóvel

    @Column(name = "ti2lte")
    private Long propertyTypeId2; // Sequencial da tabela tipo de imóvel

    @Column(name = "matlte", length = 20)
    private String registration; // Matrícula

    @Column(name = "cirlte", length = 120)
    private String jurisdiction; // Circunscrição

    @Column(name = "imolte")
    private Long propertyRegistrationId; // Inscrição imobiliária

    @ManyToOne
    @JoinColumn(name = "codtab")
    private Chart chart; // Sequencial da tabela - Espécie do lote (ESPLOT)

    @Column(name = "brrlte", length = 120)
    private String neighborhood; // Bairro

    @Column(name = "obslte", columnDefinition = "text")
    private String observation; // Observações

    @Column(name = "conlte", columnDefinition = "text")
    private String confrontations; // Confrontações

    @Column(name = "usualt", length = 125)
    private String changeUser; // Usuário inclusão/alteração

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data inclusão/alteração

    @Column(name = "atvlte", length = 1)
    private String active; // Lote ativo - S - Sim N - Não

    @Column(name = "loglte", length = 250)
    private String address; // Logradouro

    @Column(name = "ceplte")
    private Long zipCode; // CEP

    @Column(name = "numlte")
    private Long addressNumber; // Número

    @Column(name = "opdlte", length = 1)
    private String occupied; // Ocupado (S/N)
}