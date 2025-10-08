package de.vkb.onlineshop.repository;

import de.vkb.onlineshop.entity.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelRepository extends JpaRepository<Artikel, Integer> {
}
