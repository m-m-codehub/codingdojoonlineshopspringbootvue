package de.vkb.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "kunden")
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kundennummer;

    private String nachname;
    private String vorname;
    private String strasse;
    private String plz;
    private String ort;
}