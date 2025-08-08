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
@Table(name = "emhond", schema = "emha")
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codond", nullable = false)
    private Long id; // Código Sequencial do(s) Dependentes do cadastramento on-line

    @ManyToOne
    @JoinColumn(name = "codonl")
    private PersonOnline personOnline; // Código Sequencial do titular

    @Column(name = "tdeond")
    private Long totalDependents; // Total Geral de Dependentes

    @Column(name = "d14ond")
    private Long under14; // Dependentes menores de 14 anos

    @Column(name = "d60ond")
    private Long over60; // Dependentes maiores de 60 anos

    @Column(name = "tdfond")
    private Long totalWithDisability; // Dependentes com Deficiência

    @Column(name = "dcaond")
    private Boolean hasWheelchairDependent; // Cadeirante

    @Column(name = "demond")
    private Boolean hasMotorDisability; // Deficiência Motora

    @Column(name = "defond")
    private Boolean hasPhysicalDisability; // Deficiência Física

    @Column(name = "deaond")
    private Boolean hasHearingDisability; // Deficiência Auditiva

    @Column(name = "devond")
    private Boolean hasVisualDisability; // Deficiência Visual

    @Column(name = "deuond")
    private Boolean hasMultipleDisabilities; // Deficiência Múltipla

    @Column(name = "deoond")
    private Boolean hasOtherDisabilities; // Outro tipo de deficiência

    @Column(name = "qadond", length = 200)
    private String descriptionOfDisabilities; // Qual deficiência?

    @Column(name = "qedond", length = 200)
    private String dependentsWithDisabilitiesNames; // Quais dependentes com deficiência?

    @Column(name = "tdcond")
    private Long totalChronicDiseases; // Total com Doença Crônica

    @Column(name = "ddmond")
    private Boolean hasMentalDisability; // Deficiência Mental

    @Column(name = "dmiond")
    private Boolean hasMicrocephaly; // Microcefalia

    @Column(name = "dciond")
    private Boolean hasDisablingChronicDisease; // Doença Crônica Incapacitante

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data de inclusão/alteração

    @Column(name = "dcanond")
    private Boolean hasCancer; // Possui algum tipo de câncer comprovado com laudo médico?

    @Column(name = "dcdond")
    private Boolean hasDegenerativeDisease; // Doença crônica degenerativa comprovada com laudo médico?
}
