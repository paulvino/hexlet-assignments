package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> elements1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> elements2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> elements3 = new ArrayList<>(Arrays.asList(1));
        List<Integer> elements4 = new ArrayList<>();

        List<Integer> actual1 = App.take(elements1, 2);
        List<Integer> actual2 = App.take(elements2, 5);
        List<Integer> actual3 = App.take(elements3, 1);
        List<Integer> actual4 = App.take(elements4, 3);

        String msg = "Arrays not equal!";
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(1));
        List<Integer> expected4 = new ArrayList<>();

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(actual4).isEqualTo(expected4);

        Assertions.assertEquals(actual1, expected1, msg);
        Assertions.assertEquals(actual2, expected2, msg);
        Assertions.assertEquals(actual3, expected3, msg);
        Assertions.assertEquals(actual4, expected4, msg);
        // END
    }
}
