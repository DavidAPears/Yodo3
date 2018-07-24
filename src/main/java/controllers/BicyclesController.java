package controllers;

import db.DBBicycle;
import db.DBHelper;
import db.DBUser;
import db.Seeds;
import models.Advert;
import models.Bicycle;
import models.User;
import org.hibernate.Hibernate;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BicyclesController {


    public BicyclesController() {this.setupEndpoints(); }

    private void setupEndpoints() {


        get("/bicycles", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/bicycles/index.vtl");

            List<Bicycle> bicycles = DBHelper.getAll(Bicycle.class);
            model.put("bicycles", bicycles);
            ModelAndView mv = new ModelAndView(model, "templates/layout.vtl");

            return mv;

        }, new VelocityTemplateEngine());


//  To Create New Bike:

        get("/bicycles/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/bicycles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//  To search bikes:

        get("bicycles/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/bicycles/show.vtl");
            int bicycleId = Integer.parseInt(req.params(":id"));
            Bicycle bicycle = DBBicycle.find(bicycleId);
            model.put("bicycle", bicycle);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//        post("/bicycles", (req, res) -> {
//            String bicycleName = req.queryParams("bicyclename");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            Bicycle newBicycle = new Bicycle(bicycleName, credit);
//            DBHelper.save(newBicycle);
//            res.redirect("/bicycles");
//            return null;
//        }, new VelocityTemplateEngine());


//  To edit bikes:

        get("bicycles/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int bicycleId = Integer.parseInt(req.params(":id"));
            Bicycle bicycle = DBBicycle.find(bicycleId);
            model.put("bicycle", bicycle);
            model.put("template", "templates/bicycles/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//        post("/bicycles/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String bicycleName = req.queryParams("bicycleName");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            int bicycleId = Integer.parseInt(req.params(":id"));
//            Bicycle bicycle = DBHelper.find(bicycleId, Bicycle.class);
//            bicycle.setbicycleName(bicycleName);
//            bicycle.setCredit(credit);
//            DBHelper.update(bicycle);
//            res.redirect("/bicycles");
//            return null;
//        }, new VelocityTemplateEngine());



//  To delete bikes:

        post("/bicycles/:id/delete", (req, res) -> {
            int bicycleId = Integer.parseInt(req.params(":id"));
            Bicycle bicycle = DBBicycle.find(bicycleId);
            DBHelper.delete(bicycle);
            res.redirect("/bicycles");
            return null;
        }, new VelocityTemplateEngine());


    }

}
