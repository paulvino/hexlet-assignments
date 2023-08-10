package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat() {
    }

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        int result = (int) (getArea() - another.getArea());

        if (result != 0) {
            return result > 0 ? 1 : -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        double totalArea = area + balconyArea;
        return "Квартира площадью " + totalArea + " метров на " + floor + " этаже";
    }
}
// END
