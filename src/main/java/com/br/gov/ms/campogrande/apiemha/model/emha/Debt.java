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
@Table(name = "emhdeb", schema = "emha")
public class Debt {

    @Id
    @Column(name = "coddeb", nullable = false)
    private Long id; // Sequencial da tabela de débitos

    @ManyToOne
    @JoinColumn(name = "codctr")
    private Contract contract; // Sequencial da tabela de contratos

    @ManyToOne
    @JoinColumn(name = "codpes")
    private Person person; // Sequencial da tabela de pessoas

    @Column(name = "codtrb", nullable = false)
    private Long taxTypeId; // Sequencial da tabela de tributos (1 = Parcela, 2 = Taxa)

    @Column(name = "codlnc")
    private Long debtLaunchId; // Sequencial da tabela de lançamento de débitos

    @Column(name = "numdeb", nullable = false)
    private Long installmentNumber; // Número da prestação

    @Column(name = "emideb", nullable = false)
    private LocalDate issueDate; // Data de emissão

    @Column(name = "vendeb", nullable = false)
    private LocalDate dueDate; // Data de vencimento

    @Column(name = "vlodeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal originalAmount; // Valor original

    @Column(name = "vladeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal adjustmentAmount; // Valor do reajuste

    @Column(name = "jurdeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal interestAmount; // Juros

    @Column(name = "muldeb", precision = 16, scale = 4)
    private BigDecimal fineAmount; // Multa

    @Column(name = "desdeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal discountAmount; // Desconto

    @Column(name = "totdeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal totalAmount; // Valor total

    @Column(name = "dpgdeb")
    private LocalDate paymentDate; // Data do pagamento

    @Column(name = "ajmdeb", precision = 16, scale = 4)
    private BigDecimal additionalAdjustment; // Ajuste para mais (importação)

    @Column(name = "ajsdeb", precision = 16, scale = 4)
    private BigDecimal subtractionAdjustment; // Ajuste subtração (importação)

    @Column(name = "nrvdeb")
    private Long batchNumber; // Número da via (importação)

    @Column(name = "usrdeb", length = 120)
    private String maintenanceUser; // Usuário de manutenção

    @Column(name = "atvdeb", nullable = false, length = 1)
    private Character activeFlag; // Ativo S - Sim / N - Não

    @Column(name = "rdmdeb")
    private Long rdmFlag; // Flag RDM (importação)

    @Column(name = "rdfdeb")
    private Long rdmReference; // Flag envio rdm (importação)

    @Column(name = "usualt", nullable = false, length = 30)
    private String changeUser; // Usuário inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data inclusão/alteração

    @Column(name = "segdeb", precision = 16, scale = 4)
    private BigDecimal segdeb;

    @Column(name = "readeb", precision = 16, scale = 4)
    private BigDecimal percentageAdjustment; // Reajuste de 1% do contrato

    @Column(name = "bnsdeb")
    private Boolean bonus; // Bônus (true/false)

    @Column(name = "rejdeb", precision = 16, scale = 4)
    private BigDecimal ipcaAdjustmentValue; // VALOR DO REAJUSTE EM CIMA DO IPCAE

    @Column(name = "vlpdeb", precision = 16, scale = 4)
    private BigDecimal paidAmount; // Valor pago

    @Column(name = "jubdeb", columnDefinition = "text")
    private String writeOffJustification; // Justificativa da baixa

    @Column(name = "ubadeb", length = 120)
    private String writeOffUser; // Usuário da baixa

    @Column(name = "codprs")
    private Long processCode; // Código do processo

    @Column(name = "durdeb")
    private LocalDateTime lastAdjustmentDate; // Data do último reajuste

    @Column(name = "duadeb")
    private LocalDateTime lastAnnualAdjustmentDate; // Último reajuste anual de 1%

    @Column(name = "abndeb")
    private Long bonusYear; // Ano do bônus

    @Column(name = "dejdeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal interestDiscount; // Desconto de juros

    @Column(name = "demdeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal fineDiscount; // Desconto de multas

    @Column(name = "deddeb", precision = 16, scale = 4)
    private BigDecimal centDownAdjustment; // Ajuste de centavos menos

    @Column(name = "ajudeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal centUpAdjustment; // Ajuste de centavos mais

    @Column(name = "deadeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal additionalDiscount; // Desconto adicional

    @Column(name = "inadeb")
    private Boolean inactivatedByUser; // Inativos feitos pelo usuário

    @Column(name = "fecdeb")
    private Boolean closedInstallment; // Parcela fechada pelo usuário

    @Column(name = "detdeb", precision = 16, scale = 4)
    private BigDecimal originalAmountDiscount; // Desconto no valor original da parcela

    @Column(name = "guideb")
    private Long guideCode; // Código da guia para verificação de bônus

    @Column(name = "usualt1", length = 20)
    private String inactivationUser; // Usuário da inativação do débito

    @Column(name = "vlddeb", nullable = false, precision = 16, scale = 4)
    private BigDecimal additionalValue; // Valor adicional

    @Column(name = "codtdd")
    private Long deductionTypeId; // Código de tipos de dedução

    @Column(name = "coddec")
    private Long discountTableId; // Código da tabela de descontos (emhdec)

    @Column(name = "simdeb", precision = 16, scale = 2)
    private BigDecimal paymentTypeCode; // Código do tipo de pagamento

    @Column(name = "selparc")
    private String parcelPaymentCode; // Código referente ao tipo de pagamento da parcela

    @Column(name = "dtinadeb")
    private LocalDateTime inactivationDate; // Data e hora da última inativação

    @Column(name = "codcpj")
    private Long cnpjId; // Sequencial da tabela de CNPJ
}

