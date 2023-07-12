package item34;

import java.util.HashMap;

public class RawEnum {
    static final HashMap<String, RawEnum> map = new HashMap<>();

    static final RawEnum ONE = new RawEnum(1);
    static final RawEnum TWO = new RawEnum(1);
    static final RawEnum THREE = new RawEnum(1);
    static final int a = 1341421421;
    static final String s = "kimdonghun";
    static final Object a2 = new Object();
    private int number;


    public RawEnum(int number) {
        this.number = number;
        map.put("one", RawEnum.ONE);
    }
}

enum Enum {
    ONE(1),
    TWO(2),
    THREE(3),;
    private int number;

    Enum(int number) {
        this.number = number;
    }
}