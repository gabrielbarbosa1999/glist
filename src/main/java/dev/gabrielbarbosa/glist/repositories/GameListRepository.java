package dev.gabrielbarbosa.glist.repositories;

import dev.gabrielbarbosa.glist.entitites.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
