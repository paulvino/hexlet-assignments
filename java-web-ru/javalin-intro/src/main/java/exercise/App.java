package exercise;

// BEGIN
import io.javalin.Javalin;
// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        // создаем приложение
        var app = Javalin.create(config -> {
                // включаем логгирование при разработке
                config.plugins.enableDevLogging();
        });

        // описываем событие при GET запросе на адрес /welcome
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));

        // возвращаем настроенное приложение
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
