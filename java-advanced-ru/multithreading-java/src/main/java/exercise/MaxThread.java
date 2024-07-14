package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " started");
        max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMax() {
        return max;
    }
}
// END
