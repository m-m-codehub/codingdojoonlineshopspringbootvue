package de.vkb.onlineshop.service;

import de.vkb.onlineshop.dto.BestellungDto;
import de.vkb.onlineshop.dto.PositionDto;
import de.vkb.onlineshop.entity.Bestellung;
import de.vkb.onlineshop.entity.Position;
import de.vkb.onlineshop.repository.BestellungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BestellungService {

    private final BestellungRepository repository;

    public List<BestellungDto> findAll() {
        List<Bestellung> bestellungen = repository.findAll();

        List<BestellungDto> bestellungDtos = new ArrayList<>(bestellungen.size());

        for (Bestellung bestellung : bestellungen) {
            List<PositionDto> positionDtos = new ArrayList<>();
            for (Position pos : bestellung.getPositionen()) {
                PositionDto posDto = new PositionDto(
                        pos.getArtikel().getBezeichnung(),
                        pos.getMenge()
                );
                positionDtos.add(posDto);
            }

            BestellungDto dto = new BestellungDto(
                    bestellung.getBestellnummer(),
                    bestellung.getKunde().getVorname() + " " + bestellung.getKunde().getNachname(),
                    bestellung.getBestelldatum(),
                    positionDtos
            );
            bestellungDtos.add(dto);
        }

        return bestellungDtos;
    }
}
