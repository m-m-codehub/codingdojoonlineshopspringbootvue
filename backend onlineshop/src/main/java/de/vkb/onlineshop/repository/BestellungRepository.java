package de.vkb.onlineshop.repository;

import de.vkb.onlineshop.entity.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, Integer> {
}
