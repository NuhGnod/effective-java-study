package chapter3.item10;

import java.awt.*;
import java.util.Objects;

public class item10 {
    private final String s;

    public item10(String s) {

        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof chapter3.item10) {
//            return this.s.equalsIgnoreCase(((chapter3.item10) obj).s);
//        }
//        if (obj instanceof String) {
//            return this.s.equalsIgnoreCase((String) obj);
//        }
//        return false;
        return (obj instanceof item10) && obj.equals(s);
    }

    public static void main(String[] args) {
//        chapter3.item10 item = new chapter3.item10("item");
//        String s = "item";
//        List<chapter3.item10> list = new ArrayList<>();
//        list.add(item);
//        System.out.println(list.contains(s));
//        System.out.println(item.equals(s));
//        System.out.println(s.equals(item));

        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint cp3 = new ColorPoint(1, 2, Color.BLACK);
        System.out.println("cp1.equals(p2) = " + cp1.equals(p2));
        System.out.println("p2.equals(cp3) = " + p2.equals(cp3));
        System.out.println("cp1.equals(cp3) = " + cp1.equals(cp3));

        SmellPoint sp4 = new SmellPoint(1, 2, "BAD");
//        System.out.println("cp1.equals(sp4) = " + cp1.equals(sp4));

//        cp1.equals(sp4);
    }

}

class SmellPoint extends Point {
    private final String smell;

    public SmellPoint(int x, int y, String smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        if (!(obj instanceof ColorPoint)) {
            return obj.equals(this);
        }

        return super.equals(obj) && ((SmellPoint) obj).smell == smell;
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x
                = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
//        if (!(obj instanceof Point)) {
//            return false;
//        }
//        Point p = (Point) obj;
//        return p.x == x && p.y == y;
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}

class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        if (!(obj instanceof ColorPoint)) {
            return obj.equals(this);
        }
        if (!(obj instanceof SmellPoint)) {
            return obj.equals(this);
        }
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }
}