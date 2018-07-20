package controllers;

import db.DBHelper;
import models.Book;
import models.enums.Format;
import models.enums.Genre;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BooksController {

    public BooksController() { this.setupEndpoints(); }

    private void setupEndpoints () {

//        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/books", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "/templates/books/index.vtl");
            List<Book> book = DBHelper.getAll(Book.class);
            model.put("books", book);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/books/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/create.vtl");
            List<Genre> genres = DBHelper.getAll(Genre.class);
            model.put("genres", genres);
            List<Format> formats = DBHelper.getAll(Format.class);
            model.put("formats", formats);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("books/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/show.vtl");
            int computerGameId = Integer.parseInt(req.params(":id"));
            Book computerGame = DBHelper.find(computerGameId, Book.class);
            model.put("computerGame", computerGame);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post("/books", (req, res) -> {
//            String computerGamename = req.queryParams("computerGamename");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            Book newBook = new Book(computerGamename, credit);
//            DBHelper.save(newBook);
//            res.redirect("/books");
//            return null;
//        }, new VelocityTemplateEngine());

        get("books/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int computerGameId = Integer.parseInt(req.params(":id"));
            Book computerGame = DBHelper.find(computerGameId, Book.class);
            model.put("computerGame", computerGame);
            model.put("template", "templates/books/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post("/books/:id", (req, res) -> {
////            Map<String, Object> model = new HashMap<>();
//            String computerGamename = req.queryParams("computerGamename");
//            int credit = Integer.valueOf(req.queryParams("credit"));
//            int computerGameId = Integer.parseInt(req.params(":id"));
//            Book computerGame = DBHelper.find(computerGameId, Book.class);
//            computerGame.setBookname(computerGamename);
//            computerGame.setCredit(credit);
//            DBHelper.update(computerGame);
//            res.redirect("/books");
//            return null;
//        }, new VelocityTemplateEngine());

        post("/books/:id/delete", (req, res) -> {
            int computerGameId = Integer.parseInt(req.params(":id"));
            Book computerGame = DBHelper.find(computerGameId, Book.class);
            DBHelper.delete(computerGame);
            res.redirect("/books");
            return null;
        }, new VelocityTemplateEngine());


    }
}