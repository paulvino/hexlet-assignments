package exercise;

class SafetyList {
    // BEGIN
    private int[] data = new int[10];
    private int size;

    public synchronized void add(int element) {
        if (data.length == size) {
            int[] extendedData = new int[data.length * 2];
            System.arraycopy(data, 0, extendedData, 0, data.length);
            data = extendedData;
        }

        data[size++] = element;
    }

    public synchronized int get(int index) {
        return data[index];
    }

    public synchronized int getSize() {
        return size;
    }
    // END
}
