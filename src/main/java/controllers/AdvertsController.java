package controllers;

import db.DBHelper;
import models.Advert;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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
    }
}