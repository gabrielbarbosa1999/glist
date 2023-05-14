package dev.gabrielbarbosa.glist.controllers;

import dev.gabrielbarbosa.glist.dto.GameListDTO;
import dev.gabrielbarbosa.glist.dto.GameMinDTO;
import dev.gabrielbarbosa.glist.dto.ReplecementDTO;
import dev.gabrielbarbosa.glist.services.GameListService;
import dev.gabrielbarbosa.glist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replecement")
    public void move(@PathVariable Long listId, @RequestBody ReplecementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
