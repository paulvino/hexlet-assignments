package exercise;

class SafetyList {
    // BEGIN
    private int[] list = new int[1];
    private int size = 0;

    public synchronized void add(int n) {
        if (size == list.length) {
            int[] newElements = new int[list.length + 1];
            System.arraycopy(list, 0, newElements, 0, size);
            list = newElements;
        }

        list[size] = n;
        size++;
    }

    public synchronized int get(int index) {
        return list[index];
    }

    public synchronized int getSize() {
        return list.length;
    }
    // END
}
