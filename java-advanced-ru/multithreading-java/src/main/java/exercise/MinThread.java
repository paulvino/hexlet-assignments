package exercise;

// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " started");
        min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMin() {
        return min;
    }
}
// END
