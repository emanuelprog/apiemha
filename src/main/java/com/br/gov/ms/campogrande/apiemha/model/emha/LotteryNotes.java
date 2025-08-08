package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhobs", schema = "emha")
public class LotteryNotes {

    @Id
    @Column(name = "codobs", nullable = false)
    private Long id; // Sequencial da tabela de observação do loteário

    @Column(name = "desobs", length = 120, nullable = false)
    private String description; // Descrição

    @Column(name = "emiobs", length = 1, nullable = false)
    private String emits; // Emite S - SIM / N - NÃO

    @Column(name = "usualt", length = 30, nullable = false)
    private String changeUser; // Usuário inclusão/alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data inclusão/alteração

    @Column(name = "atvobs", length = 1)
    private String active; // Registro ativo? S - Sim / N - Não
}