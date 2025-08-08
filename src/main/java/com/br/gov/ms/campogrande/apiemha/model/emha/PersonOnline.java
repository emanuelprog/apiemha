package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhonl", schema = "emha")
public class PersonOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codonl", nullable = false)
    private Long id; // Código Sequencial

    @Column(name = "cadonl")
    private Long legacySystemCode; // Código do Cadastro Emha Sistema anterior

    @Column(name = "senonl")
    private Long registrationPassword; // Senha para protocolo do cadastramento

    @Column(name = "nomonl", length = 120, nullable = false)
    private String name; // Nome do Titular

    @Column(name = "sexonl", length = 1, nullable = false)
    private String gender; // Sexo (M = Masculino / F = Feminino / O = Outro)

    @Column(name = "dtnonl", nullable = false)
    private LocalDate birthDate; // Data de Nascimento do Titular

    @ManyToOne
    @JoinColumn(name = "estonl", referencedColumnName = "codtab")
    private Chart maritalStatus; // Sequencial da tabela - Estado Civil

    @Column(name = "maeonl", length = 120)
    private String motherName; // Nome da Mãe do Titular

    @Column(name = "paionl", length = 120)
    private String fatherName; // Nome do Pai do Titular

    @Column(name = "naconl", length = 1, nullable = false)
    private Character nationality; // Nacionalidade (B = Brasileiro / E = Estrangeiro)

    @Column(name = "natonl", length = 80, nullable = false)
    private String naturalPlace; // Naturalidade

    @ManyToOne
    @JoinColumn(name = "proonl", referencedColumnName = "codpro")
    private Profession profession; // Sequencial da tabela de profissão

    @ManyToOne
    @JoinColumn(name = "stponl", referencedColumnName = "codtab")
    private Chart professionalStatus; // Sequencial da tabela - SITPRO

    @Column(name = "renonl")
    private Float income; // Renda do Titular

    @Column(name = "cpfonl", length = 11, nullable = false)
    private String cpf; // CPF do Titular

    @Column(name = "tcaonl")
    private Boolean isWheelchair; // Titular é cadeirante?

    @Column(name = "tdconl")
    private Boolean hasChronicDisease; // Titular tem Doença Crônica?

    @Column(name = "tidonl")
    private Boolean isElderly; // Titular é Idoso?

    @Column(name = "tdeonl")
    private Boolean hasPhysicalDisability; // Titular tem Deficiência Física?

    @ManyToOne
    @JoinColumn(name = "detonl", referencedColumnName = "codcif")
    private Deficiency deficiency; // Sequencial da tabela de deficiência

    @Column(name = "rgionl", length = 30)
    private String rg; // Número do RG do Titular

    @Column(name = "rgoonl", length = 70)
    private String rgIssuer; // Órgão Expedidor do RG do Titular

    @ManyToOne
    @JoinColumn(name = "rguonl", referencedColumnName = "codtab")
    private Chart rgState; // Sequencial da tabela - UF do RG

    @Column(name = "rgdonl")
    private LocalDate rgIssueDate; // Data de Expedição do RG do Titular

    @Column(name = "nisonl", length = 11)
    private String nis; // Número do NIS do Titular

    @Column(name = "nmconl", length = 120)
    private String spouseName; // Nome do Cônjuge

    @Column(name = "sxconl", length = 1)
    private String spouseGender; // Sexo do Cônjuge

    @Column(name = "dnconl")
    private LocalDate spouseBirthDate; // Data de Nascimento do Cônjuge

    @Column(name = "maconl", length = 120)
    private String spouseMotherName; // Nome da Mãe do Cônjuge

    @Column(name = "paconl", length = 120)
    private String spouseFatherName; // Nome do Pai do Cônjuge

    @Column(name = "cpconl", length = 11)
    private String spouseCpf; // CPF do Cônjuge

    @Column(name = "rgconl", length = 30)
    private String spouseRgNumber; // Número do RG do Cônjuge

    @Column(name = "fononl", length = 15)
    private String phone; // Telefone de contato

    @Column(name = "celonl", length = 17)
    private String mobile; // Celular de contato

    @Column(name = "emaonl", length = 100)
    private String email; // E-mail de contato

    @ManyToOne
    @JoinColumn(name = "timonl", referencedColumnName = "codtab")
    private Chart housingType; // Sequencial da tabela - TIPIMO

    @ManyToOne
    @JoinColumn(name = "areonl", referencedColumnName = "codtab")
    private Chart areaType; // Sequencial da tabela - ARERIS

    @ManyToOne
    @JoinColumn(name = "simonl", referencedColumnName = "codtab")
    private Chart housingSituation; // Sequencial da tabela - SITIMO

    @Column(name = "vlaonl")
    private Float rentValue; // Valor do Aluguel/Financiamento

    @Column(name = "cheonl", length = 1, nullable = false)
    private String householdResponsibleGender; // Responsável pela Unidade Familiar (H = Homem / M = Mulher)

    @Column(name = "treonl")
    private Long residenceTime; // Tempo de Residência

    @Column(name = "tteonl", length = 20)
    private String residenceTimeType; // Tipo de Tempo de Residência (Dias / Meses / Anos)

    @Column(name = "btronl", length = 100)
    private String workNeighborhood; // Bairro do Parcelamento do Trabalho

    @Column(name = "rtronl", length = 40)
    private String workRegion; // Região do Endereço do Trabalho

    @Column(name = "aptonl")
    private Boolean wantsApartment; // Se interessa por Apartamento?

    @Column(name = "casonl")
    private Boolean wantsHouse; // Se interessa por Casa?

    @Column(name = "cgeonl")
    private Boolean wantsTownhouse; // Se interessa por Casa Geminada?

    @Column(name = "teronl")
    private Boolean wantsLand; // Se interessa por Terreno?

    @Column(name = "tmconl")
    private Boolean wantsLandAndMaterial; // Se interessa por Terreno + Material de Construção?

    @Column(name = "dtconl", nullable = false)
    private LocalDateTime createdAt; // Data e Hora do cadastro

    @Column(name = "dtaonl")
    private LocalDateTime updatedAt; // Data e Hora da Alteração do cadastro

    @Column(name = "niconl", length = 11)
    private String spouseNis; // Número do NIS do Cônjuge

    @Column(name = "ctronl", length = 15)
    private String benefitContractNumber; // Número do Contrato de Benefício

    @Column(name = "cnjonl", columnDefinition = "text")
    private String benefitedConjunto; // Nome do Conjunto que foi Beneficiado

    @Column(name = "quaonl", length = 20)
    private String benefitBlockNumber; // Número da Quadra do Benefício

    @Column(name = "squonl", length = 10)
    private String benefitBlockCode; // Sigla da Quadra do Benefício

    @Column(name = "lotonl", length = 20)
    private String benefitLotNumber; // Número do Lote do Benefício

    @Column(name = "sloonl", length = 10)
    private String benefitLotCode; // Sigla do Lote do Benefício

    @Column(name = "modonl", columnDefinition = "text")
    private String benefitModule; // Nome do Módulo do Benefício

    @Column(name = "deconl")
    private Boolean isSpouseDependent; // Cônjuge é dependente do Titular?

    @Column(name = "ncconl", length = 1)
    private String spouseNationality; // Nacionalidade do Cônjuge (B = Brasileiro / E = Estrangeiro)

    @Column(name = "freonl", length = 17)
    private String contactPhone; // Telefone para recado

    @Column(name = "prjonl")
    private Long projectId; // Código do Projeto

    @Column(name = "prgonl")
    private Long programId; // Código do Programa

    @Column(name = "atuonl")
    private Boolean updatedViaKattle; // Atualização feita via Kattle no banco Firebird?

    @Column(name = "nmsonl", length = 120)
    private String socialName; // Nome Social

    @Column(name = "m14onl", nullable = false)
    private Boolean hasChildrenUnder14; // Possui filhos menores de 14 anos

    @Column(name = "m60onl")
    private Boolean hasEldersAsDependents; // Possui pessoas idosas como dependentes

    @Column(name = "doeonl", length = 1)
    private String isBloodDonor; // DOADOR DE SANGUE SIM OU NÃO (S/N)

    @Column(name = "prconl")
    private Long spouseProfessionId; // Profissão do cônjuge

    @Column(name = "stconl")
    private Long spouseProfessionStatusId; // Situação profissional do cônjuge

    @Column(name = "vioonl")
    private Boolean isViolenceVictim; // Mulher vítima de violência

    @Column(name = "ncoonl", length = 250)
    private String contactName; // Nome do contato para recado

    @Column(name = "redonl", length = 250)
    private String socialNetwork; // Rede social

    @Column(name = "comonl", length = 17)
    private String comonl;

    @Column(name = "caponl", nullable = false)
    private Boolean caponl;

    @Column(name = "mpeonl")
    private Boolean mpeonl;

    @Column(name = "pimonl")
    private Boolean pimonl;

    @Column(name = "dcionl")
    private Boolean dcionl;

    @Column(name = "cras")
    private Boolean cras; // É acompanhado pelo CRAS

    @Column(name = "creas")
    private Boolean creas; // É acompanhado pelo CREAS

    @Column(name = "rcronl", length = 1)
    private String creditRestrictionFlag; // Possui restrição de crédito (S/N)

    @Column(name = "fsuonl")
    private Boolean wantsSubsidizedLoan; // Se interessa por Financiamento Subsidiado?

    @Column(name = "losonl")
    private Boolean wantsSocialRentFlag; // Se interessa por Locação Social?

    @Column(name = "renonlformatado", columnDefinition = "text")
    private String formattedIncome; // Renda formatada

    @Column(name = "vlaonlformatado", columnDefinition = "varchar")
    private String formattedRentValue; // Valor do aluguel formatado

    @Column(name = "etnonl", length = 255)
    private String ethnicity; // Etnia do Titular

    @Column(name = "tipetnonl", length = 255)
    private String indigenousEthnicity; // Qual etnia indígena do titular?

    @Column(name = "cetnonl", length = 255)
    private String spouseEthnicity; // Etnia do Cônjuge

    @Column(name = "ctipetnonl", length = 255)
    private String spouseIndigenousEthnicity; // Qual etnia indígena do cônjuge?

    @Column(name = "aldonl")
    private Boolean livesInVillage; // Titular mora em aldeia?

    @Column(name = "etnquionl")
    private Boolean isQuilombola; // Se o titular for etnia negra a Família é quilombola?

    @Column(name = "defonl")
    private Boolean hasDisability; // Pessoa com deficiência

    @Column(name = "cdefonl")
    private Boolean spouseHasDisability; // Cônjuge com deficiência

    @Column(name = "cdoecroonl")
    private Boolean spouseHasWorkLimitingDisease; // Cônjuge com doença crônica incapacitante e atestado?

    @Column(name = "cdoecrodegonl")
    private Boolean spouseHasDegenerativeDisease; // Cônjuge possui doença crônica degenerativa com laudo?

    @Column(name = "canonl")
    private Boolean hasCancer; // Titular possui câncer com laudo?

    @Column(name = "ccanonl")
    private Boolean spouseHasCancer; // Cônjuge possui câncer com laudo?

    @Column(name = "ctidonl")
    private Boolean spouseIsElderly; // Cônjuge é idoso?

    @Column(name = "habpreonl")
    private Boolean hasPrecariousHousing; // Habitação precária?

    @Column(name = "sitcoaonl")
    private Boolean isInCoHousing; // Situação de coabitação?

    @Column(name = "sitadeexcdomaluonl")
    private Boolean hasOvercrowding; // Adensamento excessivo?

    @Column(name = "resarerisonl")
    private Boolean livesInRiskArea; // Reside em área de risco?

    @Column(name = "sitonuexcaluonl")
    private Boolean hasExcessiveRentBurden; // Ônus excessivo com aluguel?

    @Column(name = "benproalusocproonl")
    private Boolean receivesRentSubsidy; // Beneficiário de programa de aluguel social?

    @Column(name = "sitruaonl")
    private Boolean isHomeless; // Situação de rua?

    @Column(name = "doecrodegonl")
    private Boolean hasDegenerativeDisease; // Titular com doença crônica degenerativa com laudo?

    @Column(name = "caldonl")
    private Boolean spouseLivesInVillage; // Cônjuge mora em aldeia?

    @Column(name = "cetnquionl")
    private Boolean spouseIsQuilombola; // Cônjuge negro com família quilombola?

    @Column(name = "ctdconl")
    private Boolean spouseHasChronicDisease; // Cônjuge tem doença crônica?

    @Column(name = "sitpreonl")
    private Boolean sitpreonl;

    @Column(name = "fammononl")
    private Boolean isSingleParentFamily; // Família monoparental?

    @OneToMany(mappedBy = "personOnline", cascade = CascadeType.ALL)
    private List<Address> addresses; // Endereço do titular

    @OneToMany(mappedBy = "personOnline", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Dependent> dependents; // Dependentes vinculados ao cadastro online
}
