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

/*// РЕШЕНИЕ УЧИТЕЛЯ

class App {
    public static String getForwardedVariables(String config) {
        String[] lines = config.split("\n");
        return Arrays.stream(lines)
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replaceAll("environment=", ""))
                .map(line -> line.replaceAll("\"", ""))
                .map(line -> line.split(","))
                .flatMap(Arrays::stream)
                .filter(kv -> kv.startsWith("X_FORWARDED_"))
                .map(kv -> kv.replaceFirst("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}*/
