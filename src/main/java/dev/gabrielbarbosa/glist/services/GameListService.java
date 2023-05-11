package dev.gabrielbarbosa.glist.services;

import dev.gabrielbarbosa.glist.dto.GameListDTO;
import dev.gabrielbarbosa.glist.entitites.GameList;
import dev.gabrielbarbosa.glist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream()
                .map(GameListDTO::new)
                .collect(Collectors.toList());
    }

}
