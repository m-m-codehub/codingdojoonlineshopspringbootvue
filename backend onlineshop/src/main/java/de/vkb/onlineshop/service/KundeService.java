package de.vkb.onlineshop.service;

import de.vkb.onlineshop.entity.Kunde;
import de.vkb.onlineshop.repository.KundeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KundeService {

    private final KundeRepository repository;

    public List<Kunde> findAll() {
        return repository.findAll();
    }

    public Kunde update(int id, Kunde kunde) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Kunde nicht gefunden");
        }
        kunde.setKundennummer(id);
        return repository.save(kunde);
    }

    public Kunde save(Kunde kunde) {
        return repository.save(kunde);
    }

    public boolean deleteById(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
