package leetcode.solution.number;

public class Atoi {

  public int myAtoi(String str) {

    if (str == null || str.length() == 0) {
      return 0;
    }

    int index = 0;
    while (index < str.length() && str.charAt(index) == ' ') {
      index++;
    }
    if (index == str.length()) {
      return 0;
    }

    int symbol = 1;
    char c = str.charAt(index);
    if (c == '-' || c == '+') {
      symbol = c == '-' ? -1 : 1;
      index++;
    } else if (c < '0' || c > '9') {
      return 0;
    }

    long value = 0;
    while (index < str.length()) {
      c = str.charAt(index);
      if (c < '0' || c > '9') {
        break;
      }
      value = value * 10 + symbol * (c - '0');
      if (value >= Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (value <= Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      index++;
    }
    return (int) value;
  }

  public static void main(String[] args) {
    Atoi atoi = new Atoi();

    System.out.println(atoi.myAtoi("-"));
    System.out.println(atoi.myAtoi("+"));
    System.out.println(atoi.myAtoi("           "));
    System.out.println(atoi.myAtoi("42"));
    System.out.println(atoi.myAtoi("   -42"));
    System.out.println(atoi.myAtoi("   +42"));
    System.out.println(atoi.myAtoi("4193 with words"));
    System.out.println(atoi.myAtoi("words and 987"));
    System.out.println(atoi.myAtoi("91283472332"));
    System.out.println(atoi.myAtoi("-91283472332"));

  }
}
