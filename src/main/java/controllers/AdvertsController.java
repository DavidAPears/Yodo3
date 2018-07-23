package controllers;

import db.DBAdvert;
import db.DBHelper;
import db.DBUser;
import models.Advert;
import models.Bicycle;
import models.BoardGame;
import models.User;
import models.enums.Category;
import models.enums.GameType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class AdvertsController {

    public AdvertsController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/adverts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/index.vtl");

            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("adverts", adverts);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

//  To Create New Advert

        get("/adverts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/create.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            List<Category> categorys = Arrays.asList(Category.values());
            model.put("categorys", categorys);


            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//  To search adverts:

        get("adverts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/show.vtl");
            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBAdvert.find(advertId);
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//        post("/adverts", (req, res) -> {
//            String advertName = req.queryParams("advertname");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            Advert newAdvert = new Advert(advertName, credit);
//            DBAdvert.save(newAdvert);
//            res.redirect("/adverts");
//            return null;
//        }, new VelocityTemplateEngine());

        post("/adverts", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            int price = Integer.valueOf(req.queryParams("price"));
            Category category = Category.valueOf(req.queryParams("category"));
            String imageUrl = req.queryParams("imageUrl");
            int userId = Integer.valueOf(req.queryParams("user"));
            User user = DBUser.find(userId);
            Advert newAdvert = new Advert(title, description, price, category, imageUrl, user);
            DBHelper.save(newAdvert);
            res.redirect("/adverts");
            return null;
        }, new VelocityTemplateEngine());


//  To edit adverts:

        get("adverts/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBAdvert.find(advertId);
            model.put("advert", advert);
            model.put("template", "templates/adverts/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//        post("/adverts/:id", (req, res) -> {


//            Map<String, Object> model = new HashMap<>();
//            String advertName = req.queryParams("advertName");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            int advertId = Integer.parseInt(req.params(":id"));
//            Advert advert = DBAdvert.find(advertId);
//            advert.setadvertName(advertName);
//            advert.setCredit(credit);
//            DBAdvert.update(advert);
//            res.redirect("/adverts");
//            return null;
//        }, new VelocityTemplateEngine());


//        To delete adverts:

        post("/adverts/:id/delete", (req, res) -> {
            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBAdvert.find(advertId);
            DBHelper.delete(advert);
            res.redirect("/adverts");
            return null;
        }, new VelocityTemplateEngine());







    }
}