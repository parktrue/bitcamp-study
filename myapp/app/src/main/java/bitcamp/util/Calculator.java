package bitcamp.util;

public class Calculator {

  public static int result; // static 변수는 기본 값으로 0으로 초기화 된다. 로컬변수는 개발자가 초기화 시켜야 한다.

  public static void init(int a) {
    result = a;
  }

  public static void plus(int a) {
    result += a;
  }

  public static void minus(int a) {
    result -= a;
  }

  public static void multiple(int a) {
    result *= a;
  }

  public static void divide(int a) {
    result /= a;
  }
}
