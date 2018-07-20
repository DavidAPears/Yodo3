package controllers;

import db.DBHelper;
import models.Bicycle;
import org.hibernate.Hibernate;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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

//        get("/hello", (request, response) -> "Hello World!!");

//        Hibernate.initialize(subProcessModel.getElement());
    }

}
