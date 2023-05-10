package dev.gabrielbarbosa.glist.controllers;

import dev.gabrielbarbosa.glist.dto.GameMinDTO;
import dev.gabrielbarbosa.glist.entitites.Game;
import dev.gabrielbarbosa.glist.repositories.GameRepository;
import dev.gabrielbarbosa.glist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

}
