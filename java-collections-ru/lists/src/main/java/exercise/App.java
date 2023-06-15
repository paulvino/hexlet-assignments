package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {

    public static boolean scrabble(String letters, String word) {
        List<String> lettersList = new ArrayList<>();
        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {
            lettersList.add(String.valueOf(letters.toLowerCase().charAt(i)));
        }

        for (int i = 0; i < word.length(); i++) {
            wordsList.add(String.valueOf(word.toLowerCase().charAt(i)));
        }

        boolean flag = true;

        for (String oneWord: wordsList) {
            if (!lettersList.contains(oneWord)) {
                return false;
            } else {
                lettersList.remove(oneWord);
            }
        }

        return flag;
    }
}
//END
