package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "emhpes", schema = "emha")
public class Person {

    @Id
    @Column(name = "codpes", nullable = false)
    private Long id; // Sequencial da tabela de pessoas

    @Column(name = "regpes")
    private LocalDateTime registerDate; // Data de registro

    @Column(name = "cpfpes", length = 14)
    private String cpf; // CPF da pessoa

    @Column(name = "nompes", length = 120)
    private String name; // Nome da pessoa

    @Column(name = "nacpes", length = 1)
    private String nationality; // Nacionalidade da pessoa. B - Brasileiro / E - Estrangeiro

    @Column(name = "natpes", length = 80)
    private String birthplace; // Naturalidade da pessoa

    @Column(name = "ufnpes")
    private Long birthplaceStateId; // UF da naturalidade (tabela)

    @Column(name = "nispes", length = 11)
    private String nis; // Número de inscrição social

    @Column(name = "morpes")
    private LocalDate municipalityStartDate; // Data de início de moradia no município

    @Column(name = "rgipes", length = 30)
    private String rg; // RG da pessoa

    @Column(name = "rgepes", length = 70)
    private String rgIssuer; // Órgão expedidor do RG

    @Column(name = "sexpes", length = 1)
    private String gender; // Sexo da pessoa. M - Masculino / F - Feminino

    @Column(name = "cnppes", length = 14)
    private String cnpj; // CNPJ da pessoa

    @Column(name = "naspes")
    private LocalDate birthDate; // Data de nascimento da pessoa

    @Column(name = "rgupes")
    private Long rgStateId; // UF do RG (tabela)

    @Column(name = "titpes", length = 30)
    private String voterTitle; // Título eleitoral

    @Column(name = "tizpes", length = 10)
    private String voterZone; // Zona eleitoral

    @Column(name = "tispes", length = 10)
    private String voterSection; // Seção eleitoral

    @Column(name = "tiepes")
    private LocalDateTime voterIssueDate; // Data de emissão do título

    @Column(name = "telpes", length = 100)
    private String phoneList; // Lista de telefones

    @Column(name = "emlpes", length = 100)
    private String email; // Email da pessoa

    @Column(name = "paipes", length = 100)
    private String fatherName; // Nome do pai

    @Column(name = "maepes", length = 120)
    private String motherName; // Nome da mãe

    @Column(name = "tpipes")
    private Long propertyTypeId; // Tipo do imóvel (tabela TIPIMO)

    @Column(name = "arrpes")
    private Long riskAreaId; // Área de risco (tabela ARERIS)

    @Column(name = "simpes")
    private Long propertyStatusId; // Situação do imóvel (tabela SITIMO)

    @Column(name = "valpes", precision = 10, scale = 2)
    private BigDecimal rentValue; // Valor do aluguel

    @Column(name = "obspes", length = 4000)
    private String observations; // Observações

    @Column(name = "ceppes", length = 15)
    private String addressZipCode; // CEP

    @Column(name = "numpes", length = 15)
    private String addressNumber; // Número do endereço

    @Column(name = "compes", length = 25)
    private String addressComplement; // Complemento do endereço

    @Column(name = "quapes", length = 25)
    private String addressBlock; // Quadra do endereço

    @Column(name = "lotpes", length = 25)
    private String addressLot; // Lote do endereço

    @Column(name = "codend")
    private Long addressId; // Código do endereço (tabela)

    @Column(name = "chepes", length = 1)
    private String familyHeadGender; // Sexo do chefe de família. H - Homem / M - Mulher

    @Column(name = "usualt", length = 30)
    private String changeUser; // Usuário de inclusão/alteração

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data de inclusão/alteração

    @Column(name = "senpes", length = 25)
    private String portalPassword; // Senha de acesso ao portal Emhadtigital

    @Column(name = "celpes", length = 25)
    private String mobilePhone; // Telefone celular

    @Column(name = "estpes")
    private Long maritalStatusId; // Estado civil (tabela emhtab)

    @Column(name = "codpro")
    private Long professionId; // Profissão da pessoa
}
