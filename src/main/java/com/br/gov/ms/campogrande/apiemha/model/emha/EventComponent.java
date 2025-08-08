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
@Table(name = "emhcoe", schema = "emha")
public class EventComponent {

    @Id
    @Column(name = "codcoe", nullable = false)
    private Long id; // Sequencial da tabela de componentes de evento

    @ManyToOne
    @JoinColumn(name = "codmdl")
    private CommercialModule commercialModule; // Módulo comercial

    @ManyToOne
    @JoinColumn(name = "codeve")
    private Event event; // Evento do componente

    @Column(name = "codcnh")
    private Long housingComplexId; // Conjunto

    @Column(name = "usualt", length = 120)
    private String changeUser; // Usuário que alterou

    @Column(name = "datalt")
    private LocalDateTime updatedAt; // Data da alteração

    @Column(name = "qtmcoe")
    private Long housingQuantity; // Quantidade de moradias

    @Column(name = "descoe", length = 250)
    private String description; // Descrição do componente (ex: FUNAF)
}
