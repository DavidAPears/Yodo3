package models.enums;

public enum Genre {

    ADVENTURE("Adventure"),
    ANIMALS("Animals"),
    ART("Art"),
    BIOGRAPHY("Biography"),
    CLASSIC("Classic"),
    CRAFTS_AND_HOBBIES("Crafts and hobbies"),
    CRIME("Crime"),
    EDUCATIONAL("Educational"),
    FANTASY("Fantasy"),
    GENERAL("General"),
    HISTORICAL("Historical"),
    HORROR("Horror"),
    HUMOUR("Humour"),
    POETRY("Poetry"),
    REFERENCE("Reference"),
    ROMANCE("Romance"),
    SCHOOL("School"),
    SCIFI("Science fiction"),
    TRAVEL("Travel"),
    OTHER("Other");

    private String name;

    Genre(String name) { this.name = name; }

    public String getName() { return this.name; }


}
