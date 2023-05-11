package dev.gabrielbarbosa.glist.dto;

import dev.gabrielbarbosa.glist.entitites.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

@Getter
@AllArgsConstructor
public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game game) {
        BeanUtils.copyProperties(game, this);
    }

}
