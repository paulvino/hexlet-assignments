package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] words = sentence.split(" ");

        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence.isEmpty()) {
            return wordsCount;
        }
        for (String word: words) {
            int newWordCounter = wordsCount.getOrDefault(word, 0) + 1;
            wordsCount.put(word, newWordCounter);
        }

        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }

        String result = "{\n";
        for (Map.Entry<String, Integer> word: wordsCount.entrySet()) {
            result = result + "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        result = result + "}";
        return result;
    }
}
//END
