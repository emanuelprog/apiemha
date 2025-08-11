package com.br.gov.ms.campogrande.apiemha.model.emha;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emhone", schema = "emha")
public class Address {

    @Id
    @Column(name = "codone")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Código sequencial do endereço

    @ManyToOne
    @JoinColumn(name = "codonl", referencedColumnName = "codonl")
    private PersonOnline personOnline;

    @Column(name = "cepone", length = 11)
    private String zipCode; // CEP do endereço

    @Column(name = "logone", length = 100)
    private String street; // Logradouro

    @Column(name = "cidone", length = 100)
    private String city; // Cidade

    @Column(name = "regone", length = 40)
    private String region; // Região

    @Column(name = "baione", length = 100)
    private String neighborhood; // Bairro ou parcela

    @Column(name = "nreone", length = 10)
    private String number; // Número do endereço

    @Column(name = "cplone", length = 50)
    private String complement; // Complemento do endereço

    @Column(name = "codreg")
    private Long regionCode; // Código da região
}