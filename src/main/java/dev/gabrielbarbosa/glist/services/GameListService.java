package dev.gabrielbarbosa.glist.services;

import dev.gabrielbarbosa.glist.dto.GameListDTO;
import dev.gabrielbarbosa.glist.entitites.GameList;
import dev.gabrielbarbosa.glist.projections.GameMinProjection;
import dev.gabrielbarbosa.glist.repositories.GameListRepository;
import dev.gabrielbarbosa.glist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream()
                .map(GameListDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List <GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
