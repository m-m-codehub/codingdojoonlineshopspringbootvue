package de.vkb.onlineshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bestellnummer;

    private LocalDate bestelldatum;

    @ManyToOne
    @JoinColumn(name = "kundennummer")
    private Kunde kunde;

    @OneToMany(mappedBy = "bestellung")
    private List<Position> positionen;
}
