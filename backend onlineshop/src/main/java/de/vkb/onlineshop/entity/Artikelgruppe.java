package de.vkb.onlineshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Artikelgruppe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artikelgruppennummer;

    private String bezeichnung;
    private String rabatt;
}
