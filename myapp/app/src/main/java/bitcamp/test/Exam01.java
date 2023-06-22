package bitcamp.test;

class A {
  {
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
  }
  int v1 = 100;
  int v2 = 200;

  public A() {
    System.out.println("444");
  }

  public A(int a) {
    System.out.println("555");
  }

  public A(int a, int b) {
    System.out.println("666");
  }

}


public class Exam01 {

  public static void main(String[] args) {
    new A();
    new A();
    new A();
  }
}
