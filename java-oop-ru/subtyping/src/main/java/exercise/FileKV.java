package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private static String filepath;
    private static Map<String, String> dataBase;

    FileKV(String filepath, Map<String, String> dataBase) {
        this.filepath = filepath;
        this.dataBase = new HashMap<>(dataBase);
        String content = Utils.serialize(dataBase);
        Utils.writeFile(filepath, content);
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> storage = processData();
        storage.put(key, value);
        String newContent = Utils.serialize(storage);
        Utils.writeFile(filepath, newContent);
    }

    @Override
    public void unset(String key) {
        Map<String, String> storage = processData();
        storage.remove(key);
        String newContent = Utils.serialize(storage);
        Utils.writeFile(filepath, newContent);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storage = processData();
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> storage = processData();
        return new HashMap<>(storage);
    }

    private Map<String, String> processData() {
        String content = Utils.readFile(filepath);
        return Utils.unserialize(content);
    }
}
// END
