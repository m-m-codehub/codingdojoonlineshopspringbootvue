package de.vkb.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtikelDto {

    private int artikelnr;
    private String bezeichnung;
    private double preis;
    private String artikelgruppe;
}
