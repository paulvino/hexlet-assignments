package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Math.PI * (getRadius() * getRadius());
    }

//    Эталонное решение (учителя):
//    public double getSquare() throws NegativeRadiusException {
//        if (this.getRadius() < 0) {
//            throw new NegativeRadiusException("Radius can not be negative");
//        }
//
//        return Math.PI * Math.pow(circleRadius, 2);
//    }
}
// END
