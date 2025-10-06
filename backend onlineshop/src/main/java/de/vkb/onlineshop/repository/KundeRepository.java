package de.vkb.onlineshop.repository;

import de.vkb.onlineshop.entity.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde, Integer> {
}
