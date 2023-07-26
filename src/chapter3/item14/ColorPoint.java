package chapter3.item14;

public class ColorPoint implements Comparable<ColorPoint> {
    private Point point;
    private int color;

    public ColorPoint(Point point, int color) {
        this.point = point;
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public int compareTo(ColorPoint colorPoint) {
        int result = point.compareTo(colorPoint.point);
        if (result == 0) {
            return Integer.compare(color, colorPoint.color);
        }
        return result;
    }
}