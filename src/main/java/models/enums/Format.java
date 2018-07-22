package models.enums;

public enum Format {

    HARDBACK("Hardback"),
    PAPERBACK("Paperback"),
    BOARDBOOK("Board book"),
    OTHER("Other");

    private String name;

    Format(String name) { this.name = name; }

    public String getName() { return this.name; }


}