package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int elements) {

        return list.stream()
                .limit(elements)
                .sorted(Home::compareTo)
                .limit(elements)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
