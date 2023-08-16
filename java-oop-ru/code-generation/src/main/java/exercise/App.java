package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
//import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path filePath, Car car) {
        String serializedCar = car.serialize();
        try {
            Files.writeString(filePath, serializedCar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path filePath) {
        try {
            String value = Files.readString(filePath);
            return Car.unserialize(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
// END
