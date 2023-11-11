package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users
                .stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(user -> LocalDate.parse(user.get("birthday"))))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Map<String, String>> users = List.of(
                Map.of("name", "Vladimir Nikolaev", "birthday", "1990-12-27", "gender", "male"),
                Map.of("name", "Andrey Petrov", "birthday", "1989-11-23", "gender", "male"),
                Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male")
        );

        List<String> men = Sorter.takeOldestMans(users);
        System.out.println(men);
    }
}
// END

/*
// РЕШЕНИЕ ОБРАЗЦОВОЕ
class Sorter {
    public static List<String> takeOldestMans2(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender") == "male")
                .sorted((user1, user2) -> {
                    LocalDate date1 = LocalDate.parse(user1.get("birthday"));
                    LocalDate date2 = LocalDate.parse(user2.get("birthday"));
                    return date1.compareTo(date2);
                })
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }

    // alternative solution
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(map1 -> map1.get("gender").equals("male"))
                .sorted(Comparator.comparingLong(map2 -> LocalDate.parse(map2.get("birthday")).toEpochDay()))
                .map(map3 -> map3.get("name"))
                .collect(Collectors.toList());
    }

}
*/


