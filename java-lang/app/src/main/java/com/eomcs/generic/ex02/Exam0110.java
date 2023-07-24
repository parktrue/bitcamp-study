// 제네릭(Generic) 활용 - java.util.ArrayList
package com.eomcs.generic.ex02;

public class Exam0110 {

  static class A {
  }
  static class B1 extends A {
  }
  static class B2 extends A {
  }
  static class C extends B1 {
  }

  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */
  
  static class Box<T> {
    void set(T obj) {}
  }

  static <T extends B1> T echo(T obj) {
    return obj;
  }

  public static void main(String[] args) {
    Box<String> box1 = new Box<>();
    Box<Integer> box2 = new Box<>();
    Box<Member> box3 = new Box<>();

    // box1 = new Box<Object>; // 컴파일 오류!
    // box2 = new Box<String>; // 컴파일 오류!
    // box3 = new Box<Object>; // 컴파일 오류!
  }

}


