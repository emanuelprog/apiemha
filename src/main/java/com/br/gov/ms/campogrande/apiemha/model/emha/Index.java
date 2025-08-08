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
@Table(name = "emhind", schema = "emha")
public class Index {

    @Id
    @Column(name = "codind")
    private Long id; // Sequencial da tabela

    @Column(name = "refind")
    private LocalDate referenceDate; // Data de referência

    @ManyToOne
    @JoinColumn(name = "codtab")
    private Chart chart; // Sequencial da tabela. Valor do índice (INDICE)

    @Column(name = "vsmind", precision = 16, scale = 4)
    private BigDecimal salaryValue; // Valor do Salário Mínimo

    @Column(name = "usualt", length = 30)
    private String changeUser; // Usuário de inclusão/alteração

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data de inclusão/alteração

    @Column(name = "masind", precision = 16, scale = 4)
    private BigDecimal maxAboveSalary; // Máxima de Entrada em Cima do SM(Salário Mínimo)

    @Column(name = "misind", precision = 16, scale = 4)
    private BigDecimal minAboveSalary; // Mínima de Entrada em Cima do SM(Salário Mínimo)

    @Column(name = "ipoind", precision = 16, scale = 4)
    private BigDecimal contractEntryRequirement; // % de requisição de parcelas nos contratos

    @Column(name = "anoind")
    private Long year; // Ano de cadastro do índice

    @Column(name = "desind", precision = 16, scale = 4)
    private BigDecimal discountPercentage; // % de Desconto nas parcelas

    @Column(name = "perind", precision = 16, scale = 4)
    private BigDecimal firstInstallmentPeriod; // Período para vencimento 1ª parcela

    @Column(name = "reaind", precision = 16, scale = 4)
    private BigDecimal annualAdjustment; // Reajuste anual

    @Column(name = "defind", precision = 16, scale = 4)
    private BigDecimal funafDiscount; // Desconto FUNAF

    @Column(name = "deiind", precision = 16, scale = 4)
    private BigDecimal minimumPropertyImplantationDiscount; // desconto mínimo no valor do imóvel nos contratos com valor da implantação acima de 50 mil

    @Column(name = "demind", precision = 16, scale = 4)
    private BigDecimal maximumPropertyImplantationDiscount; // Desconto máximo no valor do imóvel nos contratos com valor de implantação

    @Column(name = "didind")
    private LocalDate discountStartDate; // Data inicial para os descontos nos contratos acima de vlcind mil

    @Column(name = "dfdind")
    private LocalDate discountEndDate; // Data final para os descontos nos contratos acima de 50 mil

    @Column(name = "vlcind", precision = 16, scale = 4)
    private BigDecimal minContractValueForDiscount; // Valor mínimo padrão do contrato para os descontos mínimo e máximo

    @Column(name = "maxind", precision = 16, scale = 4)
    private BigDecimal maxContractValueForDiscount; // Valor máximo do contrato para os descontos mínimo e máximo
}
