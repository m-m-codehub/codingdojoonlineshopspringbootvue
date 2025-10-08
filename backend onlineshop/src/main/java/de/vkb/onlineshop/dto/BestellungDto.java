package de.vkb.onlineshop.dto;

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
public class BestellungDto {
    private int id;
    private String kunde;
    private LocalDate bestelldatum;
    private List<PositionDto> positionen;
}
