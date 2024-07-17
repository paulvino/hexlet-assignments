package exercise;

// BEGIN
public class ListThread implements Runnable {
    private final SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван");
            }

            list.add(i);
        }
    }
}
// END
