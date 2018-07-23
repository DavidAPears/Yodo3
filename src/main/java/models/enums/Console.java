package models.enums;

public enum Console {

    ATARI_5200("Atari 5200"),
    GAMEBOY("Gameboy"),
    NINTENDO_64("Nintendo 64"),
    NINTENDO_DS("Nintendo DS"),
    PLAYSTATION_2("Playstation 2"),
    SEGA_GENESIS("Sega Genesis"),
    SUPER_NES("Super NES"),
    WII("Wii"),
    XBOX_360("Xbox 360"),
    XBOX_ONE("Xbox One"),
    OTHER("Other");

    private String name;

    Console(String name) { this.name = name; }

    public String getName() { return this.name; }



}