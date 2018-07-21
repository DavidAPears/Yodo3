package controllers;

import db.DBComputerGame;
import db.DBHelper;

import db.DBUser;
import models.Advert;
import models.ComputerGame;
import models.ComputerGame;
import models.User;
import models.enums.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ComputerGamesController {

    public ComputerGamesController() { this.setupEndpoints(); }

    private void setupEndpoints () {

//        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/computergames", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "/templates/computergames/index.vtl");
            List<ComputerGame> computerGames = DBHelper.getAll(ComputerGame.class);
            model.put("computergames", computerGames);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/hi", (request, response) -> "Hello World!!");

        get("/computergames/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/computergames/create.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            List<Console> consoles = Arrays.asList(Console.values());
            model.put("consoles", consoles);
            List<AgeClassification> ageClassifications = Arrays.asList(AgeClassification.values());
            model.put("ageClassifications", ageClassifications);
            List<GameType> gameTypes = Arrays.asList(GameType.values());
            model.put("gameTypes", gameTypes);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("computergames/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/computergames/show.vtl");
            int computerGameId = Integer.parseInt(req.params(":id"));
            ComputerGame computerGame = DBComputerGame.find(computerGameId);
            model.put("computerGame", computerGame);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/computergames", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            int price = Integer.valueOf(req.queryParams("price"));
            String imageUrl = req.queryParams("imageUrl");
            int userId = Integer.valueOf(req.queryParams("user"));
            User user = DBUser.find(userId);
            Console console = Console.valueOf(req.queryParams("console"));
            AgeClassification ageClassification = AgeClassification.valueOf(req.queryParams("ageClassification"));
            GameType gameType = GameType.valueOf(req.queryParams("gameType"));
            ComputerGame newComputerGame = new ComputerGame(title, description, price, imageUrl, user, console, ageClassification, gameType);
            DBHelper.save(newComputerGame);
            res.redirect("/computergames");
            return null;
        }, new VelocityTemplateEngine());

        get("computergames/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int computerGameId = Integer.parseInt(req.params(":id"));
            ComputerGame computerGame = DBComputerGame.find(computerGameId);
            model.put("computerGame", computerGame);
            model.put("template", "templates/computergames/edit.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            List<Console> consoles = Arrays.asList(Console.values());
            model.put("consoles", consoles);
            List<AgeClassification> ageClassifications = Arrays.asList(AgeClassification.values());
            model.put("ageClassifications", ageClassifications);
            List<GameType> gameTypes = Arrays.asList(GameType.values());
            model.put("gameTypes", gameTypes);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post("/computergames/:id", (req, res) -> {
////            Map<String, Object> model = new HashMap<>();
//            String computerGamename = req.queryParams("computerGamename");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            int computerGameId = Integer.parseInt(req.params(":id"));
//            ComputerGame computerGame = DBComputerGame.find(computerGameId);
//            computerGame.setComputerGamename(computerGamename);
//            computerGame.setCredit(credit);
//            DBHelper.update(computerGame);
//            res.redirect("/computergames");
//            return null;
//        }, new VelocityTemplateEngine());

        post("/computergames/:id/delete", (req, res) -> {
            int computerGameId = Integer.parseInt(req.params(":id"));
            ComputerGame computerGame = DBComputerGame.find(computerGameId);
            DBHelper.delete(computerGame);
            res.redirect("/computergames");
            return null;
        }, new VelocityTemplateEngine());


    }
}