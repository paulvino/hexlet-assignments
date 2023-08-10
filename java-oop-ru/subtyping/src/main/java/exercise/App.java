package exercise;

import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (Map.Entry<String, String> entry : storage.toMap().entrySet()) {
            String newKey = entry.getValue();
            String newValue = entry.getKey();

            storage.unset(newValue);
            storage.set(newKey, newValue);
        }
    }
}
// END
