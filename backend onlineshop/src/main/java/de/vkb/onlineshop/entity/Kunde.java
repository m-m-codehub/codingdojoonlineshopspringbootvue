package de.vkb.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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