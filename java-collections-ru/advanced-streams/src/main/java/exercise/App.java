package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {

    public static String getForwardedVariables(String conf) {

        return Arrays.stream(conf.split("\n"))
                .filter(str -> str.startsWith("environment="))
                .flatMap(str -> Arrays.stream(str
                        .replaceAll("\"", "")
                        .replaceAll("environment=", "")
                        .split(",")))
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .flatMap(str -> Arrays.stream(new String[]{str
                        .replaceAll("X_FORWARDED_", "")
                        .replaceAll(" ", "")
                        .concat("")}))
                .collect(Collectors.joining(","));
    }
}
//END
