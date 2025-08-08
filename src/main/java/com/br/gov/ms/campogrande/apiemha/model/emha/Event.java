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
@Table(name = "emheve", schema = "emha")
public class Event {

    @Id
    @Column(name = "codeve", nullable = false)
    private Long id; // Sequencial da tabela de evento

    @Column(name = "deseve", length = 250, nullable = false)
    private String description; // Descrição do evento

    @Column(name = "inieve", nullable = false)
    private LocalDate startDate; // Data inicial do evento

    @Column(name = "fimeve", nullable = false)
    private LocalDate endDate; // Data final do evento

    @Column(name = "usualt", length = 120, nullable = false)
    private String changeUser; // Usuário da última alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data da última alteração

    @Column(name = "txteve", columnDefinition = "text")
    private String descriptionText; // Texto que descreve o evento e normas

    @Column(name = "tereve", columnDefinition = "text")
    private String schedule; // Cronograma

    @Column(name = "atveve", nullable = false)
    private Boolean active; // Ativo (true/false)

    @Column(name = "loceve", length = 250, nullable = false)
    private String location; // Local do evento

    @Column(name = "dteeve", nullable = false)
    private LocalDateTime eventDateTime; // Data/hora do evento

    @Column(name = "obseve", length = 800)
    private String observations; // Observações do evento

    @Column(name = "niseve", nullable = false)
    private Boolean nisRequired; // NIS obrigatório

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventComponent> eventComponents; // Componentes vinculados ao evento
}
