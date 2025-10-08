package de.vkb.onlineshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    @EmbeddedId
    private PositionId id;

    private int menge;

    @ManyToOne
    @MapsId("bestellnummer")
    @JoinColumn(name = "bestellnummer")
    private Bestellung bestellung;

    @ManyToOne
    @MapsId("artikelnummer")
    @JoinColumn(name = "artikelnummer")
    private Artikel artikel;
}
