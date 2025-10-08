package de.vkb.onlineshop.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Embeddable
public class PositionId implements Serializable {
    private int bestellnummer;
    private int artikelnummer;
}
