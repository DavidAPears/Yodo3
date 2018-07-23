package models.enums;

public enum AgeClassification {

    THREE(3),
    SEVEN(7),
    TWELVE(12),
    SIXTEEN(16),
    EIGHTEEN(18);

    private int age;

    AgeClassification(int age) { this.age = age; }

    public int getAge() { return this.age; }

}