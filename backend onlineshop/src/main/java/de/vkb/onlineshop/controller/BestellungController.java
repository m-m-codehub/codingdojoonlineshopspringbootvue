package de.vkb.onlineshop.controller;

import de.vkb.onlineshop.dto.BestellungDto;
import de.vkb.onlineshop.service.BestellungService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bestellungen")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BestellungController {

    private final BestellungService service;

    @GetMapping
    public List<BestellungDto> getAll() {
        return service.findAll();
    }
}
