package db;

import models.*;
import models.enums.*;

public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(User.class);
        DBHelper.deleteAll(Advert.class);

//        delete other class objects
//
//        add seed data

        User user1 = new User("Abigail", 10);
        DBHelper.save(user1);
        User user2 = new User("Benedict", 2);
        DBHelper.save(user2);
        User user3 = new User("Cecilia", 12);
        DBHelper.save(user3);
        User user4 = new User("Dylan", 15);
        DBHelper.save(user4);
        User user5 = new User("Emily", 8);
        DBHelper.save(user5);
        User user6 = new User("Ferdinand", 20);
        DBHelper.save(user6);
        User user7 = new User("Grace", 7);
        DBHelper.save(user7);
        User user8 = new User("Humphrey", 5);
        DBHelper.save(user8);
        User user9 = new User("Imogen", 50);
        DBHelper.save(user9);

        ComputerGame computerGame1 = new ComputerGame("Sonic the Hedgehog", "1991 Sega game", 5, "/images/sonic.jpeg", user1, Console.SEGA_GENESIS, AgeClassification.THREE, GameType.ACTION);
        DBHelper.save(computerGame1);
        ComputerGame computerGame2 = new ComputerGame("Mario Bros.", "Mario and Luigi in the sewers!", 6, "/images/mariobros.jpeg", user2, Console.SUPER_NES, AgeClassification.THREE, GameType.ACTION);
        DBHelper.save(computerGame2);
        ComputerGame computerGame3 = new ComputerGame("Men in Black", "Mr Smith and Mr Jones battle the aliens in this fun game.", 8, "/images/meninblack.jpg", user2, Console.SUPER_NES, AgeClassification.SEVEN, GameType.SCIFI);
        DBHelper.save(computerGame3);

        Advert advert1 = new Advert("Huddersfield Town top, age 3-4 years", "Blue and white home replica shirt from 2017-18 season.", 10, Category.CLOTHING, "/images/htfc.jpeg", user3);
        DBHelper.save(advert1);
        Advert advert2 = new Advert("drumsticks", "Drumsticks. For banging drums.", 7, Category.MUSIC,"/images/drumsticks.jpg", user4);
        DBHelper.save(advert2);

        Bicycle bicycle1 = new Bicycle("Pink bike", "Raleigh bike with stabilizers", 20, "/images/pinkbike.png", user5, 14, 3, 5);
        DBHelper.save(bicycle1);
        Bicycle bicycle2 = new Bicycle("Purple bike", "Raleigh bike with basket", 25, "/images/purplebike.JPG", user5, 18, 6, 8);
        DBHelper.save(bicycle2);
        Bicycle bicycle3 = new Bicycle("Black bike", "Apollo bike with 12 gears", 30, "/images/blackbike.jpg", user5, 20, 7, 9);
        DBHelper.save(bicycle3);

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Book by J. K. Rowling", 5, "/images/harrypotter.jpeg", user6, Genre.FANTASY, Format.HARDBACK);
        DBHelper.save(book1);

        BoardGame boardGame1 = new BoardGame("Catan", "Catan board game, good condition", 12, "/images/catan.jpeg", user7, GameType.STRATEGY);
        DBHelper.save(boardGame1);

    }

}