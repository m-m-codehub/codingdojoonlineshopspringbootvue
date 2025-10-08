package de.vkb.onlineshop.controller;

import de.vkb.onlineshop.dto.ArtikelDto;
import de.vkb.onlineshop.service.ArtikelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artikel")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ArtikelController {

    private final ArtikelService service;

    @GetMapping
    public List<ArtikelDto> getAll() {
        return service.getAlleArtikel();
    }
}
