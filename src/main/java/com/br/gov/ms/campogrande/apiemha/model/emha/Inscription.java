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
@Table(name = "emhins", schema = "emha")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codins", nullable = false)
    private Long id; // Sequencial da tabela de inscrição

    @ManyToOne
    @JoinColumn(name = "codonl")
    private PersonOnline personOnline; // Código do cadastro geral

    @ManyToOne
    @JoinColumn(name = "codcoe")
    private EventComponent eventComponent; // Componente do evento de inscrição

    @Column(name = "usualt", length = 120)
    private String changeUser; // Usuário que alterou

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data e hora da alteração

    @Column(name = "proins", length = 250)
    private String registrationProtocol; // Protocolo da inscrição

    @Column(name = "atvins")
    private Boolean active; // Ativa true/false
}
