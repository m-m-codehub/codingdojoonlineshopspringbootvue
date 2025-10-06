package de.vkb.onlineshop.controller;

import de.vkb.onlineshop.entity.Kunde;
import de.vkb.onlineshop.service.KundeService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/kunden")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class KundeController {

    private final KundeService service;

    @GetMapping
    public List<Kunde> getAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Kunde updateKunde(@PathVariable int id, @RequestBody Kunde kunde) {
        return service.update(id, kunde);
    }

    @PostMapping
    public Kunde create(@RequestBody Kunde kunde) {
        return service.save(kunde);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        boolean deleted = service.deleteById(id);

        if (deleted) {
            return "Löschen erfolgreich";
        } else {
            return "Löschen fehlgeschlagen";
        }
    }

}
