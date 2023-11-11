package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    /*public static String[][] enlargeArrayImage(String[][] image) {
        int imageLength = image.length;
        int elLength = image[0].length;

        String[][] enlargedImage = new String[imageLength * 2][elLength * 2];

        if (image.equals(null)) {
            return null;
        }

//        for (int i = 0; i < imageLength; i++) {
//            for (int j = 0; j < elLength; j++) {
//                /*enlargedImage[i][j] = image[j][i];
//                enlargedImage[imageLength - 1 - i][elLength - 1 - j] = image[i][j];
//            }
//        }

        //enlargedImage = Arrays.stream(image).map(String[]::clone).toArray(String[][]::new);
        enlargedImage = Arrays.stream(image)
                .map(String[]::clone)
                .flatMap(el -> Arrays.stream(el.clone()))
                .toArray(String[][]::new);
        return enlargedImage;
    }*/

    // ОБРАЗЦОВОЕ РЕШЕНИЕ
    public static String[] duplicateValues(String[] items) {

        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[] {item, item}))
                .toArray(String[]::new);
    }

    public static String[][] enlargeArrayImage(String[][] image) {

        String[][] horizontalyStretched = Arrays.stream(image)
                .map(App::duplicateValues)
                .toArray(String[][]::new);

        return Arrays.stream(horizontalyStretched)
                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
                .toArray(String[][]::new);
    }

    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        for (String[] el: image) {
            System.out.println(Arrays.deepToString(el));
        }
        System.out.println();

        String[] duplicatedValue = App.duplicateValues(image[1]);
        System.out.println(Arrays.deepToString(duplicatedValue));
        System.out.println();

        String[][] enlargedImage = App.enlargeArrayImage(image);

        for (String[] el: enlargedImage) {
            System.out.println(Arrays.deepToString(el));
        }

    }
}
// END
