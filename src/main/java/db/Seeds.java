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
        ComputerGame computerGame3 = new ComputerGame("Men in Black", "Mr Smith and Mr Jones battle the aliens in this fun game. (1 of 2 copies for sale.)", 8, "/images/meninblack.jpg", user2, Console.SUPER_NES, AgeClassification.SEVEN, GameType.SCIFI);
        DBHelper.save(computerGame3);
        ComputerGame computerGame4 = new ComputerGame("Men in Black", "Mr Smith and Mr Jones battle the aliens in this fun game. (2 of 2 copies for sale.)", 8, "/images/meninblack.jpg", user2, Console.SUPER_NES, AgeClassification.SEVEN, GameType.SCIFI);
        DBHelper.save(computerGame4);
        ComputerGame computerGame5 = new ComputerGame("Men in Black II: Alien Escape", "You are MiB agent Agent K or Agent J, and are required to stop aliens blowing up the Earth with their Class 7 Ozone Demogrifier. Perfect for a relaxing Sunday afternoon.", 9, "/images/meninblackii.jpg", user2, Console.PLAYSTATION_2, AgeClassification.SEVEN, GameType.SCIFI);
        DBHelper.save(computerGame5);
        ComputerGame computerGame6 = new ComputerGame("ZTYPE", "Want a place at CodeClan? You have to get this game! It's free on the Internet, but so what?!", 400, "/images/ztype.png", user3, Console.PLAYSTATION_2, AgeClassification.EIGHTEEN, GameType.WORD);
        DBHelper.save(computerGame6);

        Advert advert1 = new Advert("Huddersfield Town top, age 3-4 years", "Blue and white home replica shirt from 2017-18 season.", 10, Category.CLOTHING, "/images/htfc.jpeg", user3);
        DBHelper.save(advert1);
        Advert advert2 = new Advert("drumsticks", "Drumsticks. For banging drums.", 7, Category.MUSIC,"/images/drumsticks.jpg", user4);
        DBHelper.save(advert2);
        Advert advert3 = new Advert("Manuel Rodriguez classical guitar", "Beautiful sound!", 100, Category.MUSIC,"/images/guitar.jpeg", user4);
        DBHelper.save(advert3);
        Advert advert4 = new Advert("Spider-man costume, age 3-4 years", "With great power comes a great costume.", 6, Category.CLOTHING, "/images/spiderman.jpeg", user3);
        DBHelper.save(advert4);
        Advert advert5 = new Advert("Batman costume, age 2-4 years", "Just the thing to wear when your little one is helping David and Edward with their Git merges.", 5, Category.CLOTHING, "/images/batman.jpeg", user5);
        DBHelper.save(advert5);
        Advert advert6 = new Advert("Elmo!", "One owner, much loved. Genuine reason for sale (I prefer Cookie Monster now).", 4, Category.TOY, "/images/elmo.jpeg", user6);
        DBHelper.save(advert6);
        Advert advert7 = new Advert("Salmon horse", "With Hungarian visa.", 1000000, Category.OTHER, "/images/horse.png", user6);
        DBHelper.save(advert7);

        Bicycle bicycle1 = new Bicycle("Pink bike", "Raleigh bike with stabilizers", 20, "/images/pinkbike.jpg", user5, 14, 3, 5);
        DBHelper.save(bicycle1);
        Bicycle bicycle2 = new Bicycle("Purple bike", "The Raleigh Krush is the perfect cycling companion for any style conscious child, with a beautiful heart design, soft floating feathers and using the latest colour trends it provides instant riding style.", 25, "/images/purplebike.jpeg", user5, 18, 6, 8);
        DBHelper.save(bicycle2);
        Bicycle bicycle3 = new Bicycle("Black bike", "Apollo bike", 30, "/images/blackbikeapollo.jpg", user5, 20, 7, 9);
        DBHelper.save(bicycle3);

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Book by J. K. Rowling", 5, "/images/harrypotter.jpeg", user6, Genre.FANTASY, Format.HARDBACK);
        DBHelper.save(book1);
        Book book2 = new Book("The Railway Series", "Box of 26 classic books by the Rev. W Awdry. The Fat Controller pre-dates Intellij.", 20, "/images/railwayseries.jpeg", user6, Genre.TRAVEL, Format.HARDBACK);
        DBHelper.save(book2);
        Book book3 = new Book("The Tiger Who Came to Tea", "He had a good appetite actually. By Judith Kerr", 3, "/images/tiger.jpeg", user7, Genre.ANIMALS, Format.PAPERBACK);
        DBHelper.save(book3);

        BoardGame boardGame1 = new BoardGame("Catan", "Catan board game, good condition", 12, "/images/catan.jpeg", user7, GameType.STRATEGY);
        DBHelper.save(boardGame1);
        BoardGame boardGame2 = new BoardGame("Scrabble Junior", "Word game for kids.", 7, "/images/scrabble.jpeg", user8, GameType.WORD);
        DBHelper.save(boardGame2);
        BoardGame boardGame3 = new BoardGame("Ligretto", "Addictive game!", 4, "/images/ligretto.jpeg", user8, GameType.OTHER);
        DBHelper.save(boardGame3);

    }

}