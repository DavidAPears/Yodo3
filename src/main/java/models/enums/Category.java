package models.enums;

public enum Category {

    BICYCLE("Bicycle", true),
    BOARD_GAME("Board game", true),
    BOOK("Book", true),
    CD("CD", false),
    CLOTHING("Clothing", false),
    COMPUTER_GAME("Computer game", true),
    MUSIC("Music", false),
    TOY("Toy", false),
    OTHER("Other", false);

    private String name;
    private boolean isClass;

    Category(String name, boolean isClass) { this.name = name; this.isClass = isClass; }

    public String getName() { return this.name; }
    public boolean isClass() { return this.isClass; }


}