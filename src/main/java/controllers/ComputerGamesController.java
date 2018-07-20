package controllers;

import db.DBHelper;

import models.Advert;
import models.ComputerGame;
import models.ComputerGame;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("computergames/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/computergames/show.vtl");
            int computerGameId = Integer.parseInt(req.params(":id"));
            ComputerGame computerGame = DBHelper.find(computerGameId, ComputerGame.class);
            model.put("computerGame", computerGame);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post("/computergames", (req, res) -> {
//            String computerGamename = req.queryParams("computerGamename");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            ComputerGame newComputerGame = new ComputerGame(computerGamename, credit);
//            DBHelper.save(newComputerGame);
//            res.redirect("/computergames");
//            return null;
//        }, new VelocityTemplateEngine());

        get("computergames/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int computerGameId = Integer.parseInt(req.params(":id"));
            ComputerGame computerGame = DBHelper.find(computerGameId, ComputerGame.class);
            model.put("computerGame", computerGame);
            model.put("template", "templates/computergames/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post("/computergames/:id", (req, res) -> {
////            Map<String, Object> model = new HashMap<>();
//            String computerGamename = req.queryParams("computerGamename");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            int computerGameId = Integer.parseInt(req.params(":id"));
//            ComputerGame computerGame = DBHelper.find(computerGameId, ComputerGame.class);
//            computerGame.setComputerGamename(computerGamename);
//            computerGame.setCredit(credit);
//            DBHelper.update(computerGame);
//            res.redirect("/computergames");
//            return null;
//        }, new VelocityTemplateEngine());

        post("/computergames/:id/delete", (req, res) -> {
            int computerGameId = Integer.parseInt(req.params(":id"));
            ComputerGame computerGame = DBHelper.find(computerGameId, ComputerGame.class);
            DBHelper.delete(computerGame);
            res.redirect("/computergames");
            return null;
        }, new VelocityTemplateEngine());


    }
}