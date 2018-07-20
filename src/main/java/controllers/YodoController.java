//package controllers;
//
//import db.DBHelper;
//import db.Seeds;
//import models.User;
//import spark.ModelAndView;
//import spark.template.velocity.VelocityTemplateEngine;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static spark.Spark.get;
//import static spark.SparkBase.staticFileLocation;
//
//public class YodoController {
//
//    public static void main(String[] args) {
//        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
//        staticFileLocation("/public");
//
//        Seeds.seedData();
//
////        AdvertsController advertsController = new AdvertsController();
////        ComputerGamesController computerGamesController = new ComputerGamesController;
////        BooksController BooksController = new BooksController;
////        BicyclesController bicyclesController = new BicyclesController;
////        BoardGamesController boardGamesController = new BoardGamesController;
//        UsersController usersController = new UsersController();
//
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("template", "templates/users/index.vtl");
//
//            List<User> users = DBHelper.getAll(User.class);
//            model.put("users", users);
//
//            return new ModelAndView(model, "templates/layout.vtl");
//
//        }, new VelocityTemplateEngine());
//
//        get("/hello", (request, response) -> "Hello World!");
//
//    }
//
//
//}