package models.enums;

public enum GameType {

    ACTION("Action"),
    FANTASY("Fantasy"),
    HISTORICAL("Historical"),
    LUCK("Luck"),
    MURDER_MYSTERY("Murder mystery"),
    NUMBER("Number"),
    SCIFI("Science fiction"),
    STRATEGY("Strategy"),
    WAR("War"),
    WORD("Word"),
    OTHER("Other");

    private String name;

    GameType(String name) { this.name = name; }

    public String getName() { return this.name; }


}
