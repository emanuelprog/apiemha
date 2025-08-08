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
@Table(name = "emhtab", schema = "emha")
public class Chart {

    @Id
    @Column(name = "codtab", nullable = false)
    private Long id; // Sequencial da tabela

    @Column(name = "tabtab", length = 6, nullable = false)
    private String chartType; // Tipo da Tabela (Conjunto de dados)

    @Column(name = "valtab", length = 10, nullable = false)
    private String chartValue; // Valor da Tabela

    @Column(name = "destab", length = 90, nullable = false)
    private String chartDescription; // Descrição da Tabela (tipos, estado civil etc)

    @Column(name = "usualt", length = 30, nullable = false)
    private String changeUser; // Usuário de Inclusão/Alteração

    @Column(name = "datalt", nullable = false)
    private LocalDateTime updatedAt; // Data de Inclusão/Alteração

    @Column(name = "atvtav", length = 1, nullable = false)
    private String active; // Ativo SIM ou NÃO

    @Column(name = "va2tab", length = 90)
    private String auxiliaryValue; // Valor auxiliar
}