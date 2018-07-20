package controllers;

import db.DBHelper;
import db.DBUser;
import db.Seeds;
import models.Advert;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

public class UsersController {

    public static void main(String[] args) {
//        using 9000 because 4567 not working
        port(9000);

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");

        Seeds.seedData();

        AdvertsController advertsController = new AdvertsController();
        BicyclesController bicyclesController = new BicyclesController();
//        ComputerGamesController computerGamesController = new ComputerGamesController();


        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/index.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        get("/hello", (request, response) -> "Hello World!!");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        get("/users/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("users/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/show.vtl");
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            model.put("user", user);
            List<Advert> adverts = DBUser.getAdvertsForUser(user);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/users", (req, res) -> {
            String username = req.queryParams("username");
            int credit = Integer.valueOf(req.queryParams("credit"));
            User newUser = new User(username, credit);
            DBHelper.save(newUser);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        get("users/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            model.put("user", user);
            model.put("template", "templates/users/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/users/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
            String username = req.queryParams("username");
            int credit = Integer.valueOf(req.queryParams("credit"));
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            user.setUsername(username);
            user.setCredit(credit);
            DBHelper.update(user);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        post("/users/:id/delete", (req, res) -> {
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            DBHelper.delete(user);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());



    }


}