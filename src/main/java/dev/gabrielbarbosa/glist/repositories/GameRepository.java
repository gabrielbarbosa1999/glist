package dev.gabrielbarbosa.glist.repositories;

import dev.gabrielbarbosa.glist.entitites.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
