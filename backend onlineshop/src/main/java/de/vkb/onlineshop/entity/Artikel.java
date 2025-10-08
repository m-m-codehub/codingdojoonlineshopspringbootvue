package de.vkb.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artikelnummer;

    private String bezeichnung;

    private double preis;

    @ManyToOne
    @JoinColumn(name = "artikelgruppennummer")
    private Artikelgruppe artikelgruppe;
}
