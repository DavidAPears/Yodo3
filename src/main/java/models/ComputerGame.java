package models;

import models.enums.AgeClassification;
import models.enums.Category;
import models.enums.Console;
import models.enums.GameType;

import javax.persistence.*;

@Entity
@Table(name="computer_games")
public class ComputerGame extends Advert {

    private Console console;
    private AgeClassification ageClassification;
    private GameType gameType;

    public ComputerGame() {}

    public ComputerGame(String title, String description, int price, String imageUrl, User user, Console console, AgeClassification ageClassification, GameType gameType) {
        super(title, description, price, Category.COMPUTER_GAME, imageUrl, user);
        this.console = console;
        this.ageClassification = ageClassification;
        this.gameType = gameType;
    }

    @Enumerated(value=EnumType.STRING)
    public Console getConsole() {
        return console;
    }
    public void setConsole(Console console) {
        this.console = console;
    }

    @Enumerated(value=EnumType.STRING)
    public AgeClassification getAgeClassification() {
        return ageClassification;
    }
    public void setAgeClassification(AgeClassification ageClassification) {
        this.ageClassification = ageClassification;
    }

    @Enumerated(value=EnumType.STRING)
    public GameType getGameType() {
        return gameType;
    }
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}