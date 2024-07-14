package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int minimun;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        minimun = min;
    }

    public int getMin() {
        return minimun;
    }
}
// END
