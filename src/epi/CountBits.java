package epi;

import java.util.BitSet;
import java.util.Random;

public class CountBits {
  // @include
  public static short countBits(int x) {
    short numBits = 0;
    while (x>0) {
    	x &= (x-1) ;
    	numBits++;
    }
    return numBits;
  }
  // @exclude

  public static void main(String[] args) {
    if (args.length == 1) {
      int x = Integer.parseInt(args[0]);
      System.out.println("x = " + x + ", = " + countBits(x));
    } else {
//      Random r = new Random();
//      for (int times = 0; times < 1000; ++times) {
//        int x = r.nextInt(Integer.MAX_VALUE);
        System.out.println("x = " + 100 + ", = " + countBits(100));
//        BitSet checker = BitSet.valueOf(new long[] {x});
//        assert(countBits(x) == checker.cardinality());
//      }
    }
  }
}