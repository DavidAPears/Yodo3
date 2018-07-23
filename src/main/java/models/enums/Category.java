package models.enums;

public enum Category {

    BICYCLE("Bicycle"),
    BOARD_GAME("Board game"),
    BOOK("Book"),
    CD("CD"),
    CLOTHING("Clothing"),
    COMPUTER_GAME("Computer game"),
    MUSIC("Music"),
    TOY("Yoy"),
    OTHER("Other");

    private String name;

    Category(String name) { this.name = name; }

    public String getName() { return this.name; }


}