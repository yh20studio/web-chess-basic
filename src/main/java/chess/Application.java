package chess;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Application {

    public static void main(final String... args) {
        port(8081);

        get("/", (req, res) -> {
            return new ModelAndView(null, "index.html");
        }, new HandlebarsTemplateEngine());

        final var board = Board.create();
        post("/move", (req, res) -> {
            final var moveRequest = MoveCommand.of(req.body());
            board.move(moveRequest);

            return board.toMap();
        }, new JsonTransformer());

        exception(Exception.class, (exception, request, response) -> {
            response.status(400);
            response.body(exception.getMessage());
        });
    }
}
