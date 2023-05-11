package dev.gabrielbarbosa.glist.dto;

import dev.gabrielbarbosa.glist.entitites.GameList;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList gameList) {
        this.id = gameList.getId();
        this.name = gameList.getName();
    }
}
