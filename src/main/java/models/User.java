package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String username;
    private int credit;
    private List<Advert> adverts;

    public User() {}

    public User(String username, int credit) {
        this.username = username;
        this.credit = credit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "credit")
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }

    @OneToMany(mappedBy = "user")
    public List<Advert> getAdverts() { return adverts; }
    public void setAdverts(List<Advert> adverts) { this.adverts = adverts; }


}