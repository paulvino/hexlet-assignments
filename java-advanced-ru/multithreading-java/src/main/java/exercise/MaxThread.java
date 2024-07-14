package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int maximum;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        maximum = max;
    }

    public int getMax() {
        return maximum;
    }
}
// END
