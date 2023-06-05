package item17;

import java.math.BigInteger;
import java.util.BitSet;

public class item17 {
    public static void main(String[] args) {

        BigInteger bigInteger = new BigInteger("123456789");
        int signum = bigInteger
                .signum();

        System.out.println("bigInteger = " + bigInteger);

        bigInteger = new BigInteger("987654321");
        System.out.println("bigInteger = " + bigInteger);
        bigInteger = bigInteger.flipBit(1);
        System.out.println("bigInteger = " + bigInteger);
        bigInteger = bigInteger.flipBit(1);
        System.out.println("bigInteger = " + bigInteger);
        //

        BitSet bitSet = new BitSet(16);
        bitSet.set(0);

        System.out.println("bitSet = " + bitSet);
        boolean b = bitSet.get(0);
        System.out.println("b = " + b);
    }
}
