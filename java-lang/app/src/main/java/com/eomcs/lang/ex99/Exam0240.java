package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 여러 종류의 데이터를 섞어 입력 받기
//
public class Exam0240 {
  public static void main(String[] args) { 
    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    System.out.print("나이? ");
    int age = keyboardScanner.nextInt();
    // nextInt()는 한 개의 토큰을 읽은 후에 줄 바꿈 코드는 읽기 전 상태로 내비둔다.
    // 따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한 줄을 
    // 읽는 상황이 된다. 
    // nextInt() 다음에 nextLine()을 호출할 때 이런 상황이 발생한다.
    // 해결 방법? nextInt()를 호출한 후 남아있는 엔터 코드를 읽어서 제거하라.
    keyboardScanner.nextLine(); // 남아 있는 빈 문자열의 한 줄(LF 코드)을 읽어서 버린다.
    // nextInt는 엔터를 칠때까지 기다리며 엔터를 치면 인자를 리턴하는데, 문제는 엔터가 남아있기 때문에
    // 위의 nextLine를 주석처리하면 남아있던 엔터가 있기 때문에 아래의 이름 부분의 nextLine에 입력되어
    // 바로 리턴해버린다. 따라서 nextInt한 후에는 엔터를 버려줘야 한다.

    System.out.print("이름? ");
    String name = keyboardScanner.nextLine();

    keyboardScanner.close();

    System.out.printf("%d(%s)\n", age, name);
  }
}















