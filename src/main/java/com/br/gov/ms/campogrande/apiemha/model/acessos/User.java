package com.br.gov.ms.campogrande.apiemha.model.acessos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "webusu", schema = "public")
public class User {


    @Id
    @Column(name = "codusu", nullable = false)
    private Long id; // Codigo do usuario

    @Column(name = "logusu", length = 12)
    private String login; // Login do usuario

    @Column(name = "senusu", length = 32)
    private String password; // Senha do usuario

}
