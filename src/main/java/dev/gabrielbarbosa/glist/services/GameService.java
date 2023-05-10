package dev.gabrielbarbosa.glist.services;

import dev.gabrielbarbosa.glist.dto.GameMinDTO;
import dev.gabrielbarbosa.glist.entitites.Game;
import dev.gabrielbarbosa.glist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

}
