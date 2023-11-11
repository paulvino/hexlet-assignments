package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
/*public class App {
    public static long getCountOfFreeEmails(List<String> list) {

        return list.stream()
                .filter(email -> email.endsWith("gmail.com")
                        || email.endsWith("yandex.ru")
                        || email.endsWith("hotmail.com"))
                .count();
    }
}*/

class App {

    private static final List<String> FREE_DOMAINS = Arrays.asList(
            "gmail.com", "yandex.ru", "hotmail.com"
    );

    public static long getCountOfFreeEmails(List<String> emails) {
        return emails
                .stream()
                .map(email -> email.split("@")[1])
                .filter(email -> FREE_DOMAINS.contains(email))
                .count();
    }
}
// END
