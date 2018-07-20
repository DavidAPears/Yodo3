package models;


import models.enums.Category;
import models.enums.GameType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="board_games")
public class BoardGame extends Advert {

    private GameType gameType;

    public BoardGame() {}

    public BoardGame(String title, String description, int price, String imageUrl, User user, GameType GameType) {
        super(title, description, price, Category.BOARD_GAME, imageUrl, user);
        this.gameType = gameType;
    }

    @Enumerated(value=EnumType.STRING)
    public GameType getGameType() {
        return gameType;
    }
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}