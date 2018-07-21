package controllers;

import db.DBBoardGame;
import db.DBHelper;
import db.DBUser;
import models.BoardGame;
import models.User;
import models.enums.AgeClassification;
import models.enums.Console;
import models.enums.GameType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BoardGamesController {

    public BoardGamesController() { this.setupEndpoints(); }

    private void setupEndpoints () {

        get("/boardgames", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "/templates/boardgames/index.vtl");
            List<BoardGame> boardGames = DBHelper.getAll(BoardGame.class);
            model.put("boardgames", boardGames);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/boardgames/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/boardgames/create.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            List<GameType> gameTypes = Arrays.asList(GameType.values());
            model.put("gameTypes", gameTypes);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("boardgames/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/boardgames/show.vtl");
            int boardGameId = Integer.parseInt(req.params(":id"));
            BoardGame boardGame = DBBoardGame.find(boardGameId);
            model.put("boardGame", boardGame);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/boardgames", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            int price = Integer.valueOf(req.queryParams("price"));
            String imageUrl = req.queryParams("imageUrl");
            int userId = Integer.valueOf(req.queryParams("user"));
            User user = DBUser.find(userId);
            GameType gameType = GameType.valueOf(req.queryParams("gameType"));
            BoardGame newBoardGame = new BoardGame(title, description, price, imageUrl, user, gameType);
            DBHelper.save(newBoardGame);
            res.redirect("/boardgames");
            return null;
        }, new VelocityTemplateEngine());

        get("boardgames/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int boardGameId = Integer.parseInt(req.params(":id"));
            BoardGame boardGame = DBBoardGame.find(boardGameId);
            model.put("boardGame", boardGame);
            model.put("template", "templates/boardgames/edit.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            List<GameType> gameTypes = Arrays.asList(GameType.values());
            model.put("gameTypes", gameTypes);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/boardgames/:id", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            int price = Integer.valueOf(req.queryParams("price"));
            String imageUrl = req.queryParams("imageUrl");
            int userId = Integer.valueOf(req.queryParams("user"));
            User user = DBUser.find(userId);
            GameType gameType = GameType.valueOf(req.queryParams("gameType"));

            int boardGameId = Integer.parseInt(req.params(":id"));
            BoardGame boardGame = DBBoardGame.find(boardGameId);

            boardGame.setTitle(title);
            boardGame.setDescription(description);
            boardGame.setPrice(price);
            boardGame.setImageUrl(imageUrl);
            boardGame.setUser(user);
            boardGame.setGameType(gameType);

            DBHelper.update(boardGame);
            res.redirect("/boardgames");
            return null;
        }, new VelocityTemplateEngine());

        post("/boardgames/:id/delete", (req, res) -> {
            int boardGameId = Integer.parseInt(req.params(":id"));
            BoardGame boardGame = DBBoardGame.find(boardGameId);
            DBHelper.delete(boardGame);
            res.redirect("/boardgames");
            return null;
        }, new VelocityTemplateEngine());


    }

}
