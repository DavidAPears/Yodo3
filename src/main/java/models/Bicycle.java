package models;

import models.enums.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="bicycles")
public class Bicycle extends Advert {

    private int wheelSize;
    private int minAge;
    private int maxAge;

    public Bicycle() {}

    public Bicycle(String title, String description, int price, String imageUrl, User user, int wheelSize, int minAge, int maxAge) {
        super(title, description, price, Category.BICYCLE, imageUrl, user);
        this.wheelSize = wheelSize;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Column(name="wheel_size")
    public int getWheelSize() {
        return wheelSize;
    }
    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Column(name="min_age")
    public int getMinAge() {
        return minAge;
    }
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Column(name="max_age")
    public int getMaxAge() {
        return maxAge;
    }
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}