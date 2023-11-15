package exercise;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var companyId = ctx.pathParamAsClass("id", Integer.class).getOrDefault(-1);

            if (companyId >= (COMPANIES.size() + 1) || companyId < 0) {
                throw new NotFoundResponse("Company not found");
            }

            for (var company : COMPANIES) {
                if (company.get("id").equalsIgnoreCase(companyId.toString())) {
                    ctx.json(company);
                }
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
