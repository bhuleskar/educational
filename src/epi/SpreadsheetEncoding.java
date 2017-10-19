package epi;

import java.util.Random;

public class SpreadsheetEncoding {
  private static String randString(int len) {
    Random r = new Random();
    StringBuilder result = new StringBuilder();
    while (len-- != 0) {
      result.append((char)(r.nextInt('Z' - 'A' + 1) + 'A'));
    }
    return result.toString();
  }

  // @include
  public static int ssDecodeColID(final String col) {
    int result = 0;
    for (int i = 0; i < col.length(); i++) {
      char c = col.charAt(i);
      int a = c - 'A';
      int z = c - 'Z';
      int o = c - '0';
      result = result * 26 + c - 'A' + 1;
    }
    return result;
  }
  // @exclude

  private static void simpleTest() {
    assert(1 == ssDecodeColID("A"));
    assert(2 == ssDecodeColID("B"));
    assert(26 == ssDecodeColID("Z"));
    assert(27 == ssDecodeColID("AA"));
  }

  public static void main(String[] args) {
    simpleTest();
    Random r = new Random();
    if (args.length == 1) {
      System.out.println(args[0] + " " + ssDecodeColID(args[0]));
    } else {
      String s = "ZZZ"; // randString(r.nextInt(5) + 1);
      System.out.println(s + " " + ssDecodeColID(s));
    }
  }
}