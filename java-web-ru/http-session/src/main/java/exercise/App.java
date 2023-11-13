package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            // page is pageNumber
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            // per is usersQuantity
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            var min = page == 1 ? page : page * (per - 1);
            var max = page * per;

            var result = USERS.stream()
//                    .filter(userNum ->
//                            Integer.parseInt(userNum.get("id")) >= min
//                            && Integer.parseInt(userNum.get("id")) <= max)
                    .filter(i -> USERS.indexOf(i) >= min - 1 && USERS.indexOf(i) <= max - 1)
                    .toList();

            ctx.json(result);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
