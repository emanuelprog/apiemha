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
@Table(name = "emhctr", schema = "emha")
public class Contract {

    @Id
    @Column(name = "codctr", nullable = false)
    private Long id; // Sequencial da tabela de contratos

    @Column(name = "numctr", nullable = false)
    private Long number; // Número do contrato

    @Column(name = "seqctr", nullable = false)
    private Long sequence; // Sequencial do contrato

    @ManyToOne
    @JoinColumn(name = "codmdl")
    private CommercialModule commercialModule; // Sequencial da tabela modulos comerciais

    @Column(name = "datctr")
    private LocalDate contractDate; // Data de realização do contrato

    @Column(name = "codlte")
    private Long batchId; // Sequencial da tabela de lotes

    @ManyToOne
    @JoinColumn(name = "codpes")
    private Person person; // Sequencial da tabela de pessoas

    @Column(name = "grsctr", length = 1, nullable = false)
    private Character socialGuarantee; // Garantia social S - Sim N - Não

    @Column(name = "cbrctr", length = 1, nullable = false)
    private Character charge; // Cobrança S - Sim N - Não

    @Column(name = "mncctr", length = 200)
    private String nonChargeReason; // Motivo da não cobrança

    @ManyToOne
    @JoinColumn(name = "codobs")
    private LotteryNotes lotteryNotes; // Sequencial da tabela de observação do loteário.

    @ManyToOne
    @JoinColumn(name = "codind")
    private Index index; // Sequencial da tabela emhind

    @Column(name = "vimctr", precision = 16, scale = 4, nullable = false)
    private BigDecimal propertyValue; // Valor do imóvel

    @Column(name = "vinctr", precision = 16, scale = 4)
    private BigDecimal compensationValue; // Valor da indenização

    @Column(name = "vfictr", precision = 16, scale = 4)
    private BigDecimal financedValue; // Valor financiado

    @Column(name = "lgrctr", length = 120)
    private String streetDescription; // Descrição do logradouro (importação)

    @Column(name = "nroctr", length = 20)
    private String streetNumber; // Número do logradouro (importação)

    @Column(name = "escctr", length = 1)
    private Character choiceType; // Tipo de escolha, R - Remoção S - Sorteio P - PSH

    @Column(name = "fldctr", length = 1)
    private Character allowDiscount; // Flegue permite desconto (importação) S - Sim N - Não

    @Column(name = "fpcctr", length = 1)
    private Character spouseParticipation; // Flag participa conjuge  S -Sim N - Não (importação)

    @Column(name = "usrctr", length = 120)
    private String userName; // Nome do usuário (importação)

    @Column(name = "atvctr", length = 1, nullable = false)
    private Character active; // Ativo S - Sim N - Não E-SIMULAÇÃO

    @Column(name = "fmoctr", length = 1)
    private Character labor; // Flag mao de obra (importação)

    @Column(name = "pbnctr", length = 1)
    private Character firstBeneficiary; // Primeiro beneficiado S - Sim N - Não (importação)

    @Column(name = "usualt", length = 30)
    private String changeUser; // Usuario inclusão / alteracao

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data inclusão / alteracao

    @Column(name = "altctr")
    private Long newContractId; // código do novo contrato (transferência, permuta, novação, quota parte)

    @ManyToOne
    @JoinColumn(name = "codcnh")
    private HousingComplexes housingComplexes; // Código do Conjunto

    @Column(name = "vmqctr", precision = 16, scale = 4)
    private BigDecimal squareMeterValue; // Valor do m²

    @Column(name = "tprctr")
    private Long installmentQuantity; // Quantidade de parcelas

    @Column(name = "vlectr", precision = 16, scale = 4)
    private BigDecimal entryValue; // Valor da Entrada

    @ManyToOne
    @JoinColumn(name = "codope")
    private Operation operation; // Código da operação - emhope

    @Column(name = "vdpctr", precision = 16, scale = 4)
    private BigDecimal installmentValue; // Valor das prestações

    @Column(name = "przctr", length = 50)
    private String term; // Prazo

    @Column(name = "veactr", precision = 16, scale = 4)
    private BigDecimal previousContractLateValue; // Valor em atraso do contrato anterior

    @Column(name = "ccactr")
    private Long previousContractId; // Sequencial do contrato anterior

    @Column(name = "vepctr")
    private Long chosenInstallmentDueDay; // Dia de vencimento de parcelas escolhido

    @Column(name = "desctr")
    private Boolean disqualified; // Desclassificado true/false

    @Column(name = "codlnc")
    private Long importLaunchCode; // Lançamento do contrato - para contratos importados

    @Column(name = "abnctr")
    private Long lastBonusYear; // Ano do último bônus

    @Column(name = "vlcctr", precision = 16, scale = 4)
    private BigDecimal constructionValue; // Valor da construção

    @Column(name = "deactr", length = 1)
    private Character waiver; // Desistência sim ou não

    @Column(name = "ntictr", length = 1)
    private Character newHolder; // NOVO TITULAR, SIM OU NÃO

    @Column(name = "txtctr")
    private String lastContractText; // Texto do contrato emitido pela última vez

    @Column(name = "trnctr")
    private Boolean transferWithNovation; // Fará transferência com novação true/false

    @Column(name = "vavctr", precision = 16, scale = 4)
    private BigDecimal funafAverbationValue; // Valor de averbação para contratos funaf

    @Column(name = "arqctr")
    private Boolean archived; // Arquivo geral true/false

    @Column(name = "cagctr", length = 100)
    private String archiveLocation; // Local no arquivo

    @Column(name = "bloctr")
    private Boolean contractBlocked; // Contrato bloqueado true/false

    @Column(name = "spcctr")
    private Boolean addedToSpc; // Contrato adicionado ao SPC

    @Column(name = "codpno")
    private Long novationParameterTypeId; // Código da modalidade de parâmetro da novação

    @Column(name = "vatctr", precision = 16, scale = 4)
    private BigDecimal transferFeeValue; // Valor da taxa de transferência

    @Column(name = "codcpj")
    private Long cnpjId; // Sequencial da tabela de CNPJ

    @Column(name = "vdjctr", precision = 16, scale = 4)
    private BigDecimal judicialDiscountValue; // Valor do Desconto Judicial

    @Column(name = "nsjctr", length = 30)
    private String judicialSentenceNumber; // Número da Sentença Judicial

    @Column(name = "dsjctr")
    private LocalDate judicialSentenceDate; // Data da Sentença Judicial

    @Column(name = "codpch")
    private Long credihabitaProgramId; // Tem programa CREDIHABITA (S–SIM / N–NÃO)

    @Column(name = "chabctr", length = 6)
    private String credihabitaProgramFlag; // Tem programa CREDIHABITA (S/N)

    @Column(name = "nprctr", length = 20)
    private String credihabitaProcessNumber; // Número do Processo (CREDIHABITA)
}
