package de.vkb.onlineshop.service;

import de.vkb.onlineshop.dto.ArtikelDto;
import de.vkb.onlineshop.entity.Artikel;
import de.vkb.onlineshop.repository.ArtikelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtikelService {

    private final ArtikelRepository repository;

    public List<ArtikelDto> getAlleArtikel() {
        List<Artikel> artikelListe = repository.findAll();
        List<ArtikelDto> dtoListe = new ArrayList<>();

        for (Artikel artikel : artikelListe) {
            String gruppenName = null;

            if (artikel.getArtikelgruppe() != null) {
                gruppenName = artikel.getArtikelgruppe().getBezeichnung();
            }
            ArtikelDto dto = new ArtikelDto(
                    artikel.getArtikelnummer(),
                    artikel.getBezeichnung(),
                    artikel.getPreis(),
                    gruppenName
            );
            dtoListe.add(dto);
        }
        return dtoListe;
    }

}
