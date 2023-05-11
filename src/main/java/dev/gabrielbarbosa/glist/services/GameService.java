package dev.gabrielbarbosa.glist.services;

import dev.gabrielbarbosa.glist.dto.GameDTO;
import dev.gabrielbarbosa.glist.dto.GameMinDTO;
import dev.gabrielbarbosa.glist.entitites.Game;
import dev.gabrielbarbosa.glist.projections.GameMinProjection;
import dev.gabrielbarbosa.glist.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

}
