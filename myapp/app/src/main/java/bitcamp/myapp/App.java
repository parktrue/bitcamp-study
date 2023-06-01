package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.printf("\n------------------------\n");

    // 키보드 스캐너 준비
    // 각 데이터를 키보드를 통해 입력받아서 출력한다.
    Scanner scanner = new java.util.Scanner(System.in);

    final int SIZE = 100; // final 변수는 값이 한번 들어가면 값을 바꿀 수 없다.

    int[] no = new int[SIZE]; // 3은 메모리의 개수이며 int는 만들 메모리의 데이터 타입이다. no는 배열의 주소를 담는 레퍼런스이다.
    String[] name = new String[SIZE];
    int[] age = new int[SIZE];
    boolean[] working = new boolean[SIZE];
    char[] gender = new char[SIZE];
    float[] leftEye = new float[SIZE];
    float[] rightEye = new float[SIZE];

    for (int i = 0; i < SIZE; i++) {
      // i++; // 값을 1개 증가 == i += 1;, i = i + 1;

      System.out.print("번호 : ");
      no[i] = scanner.nextInt();

      System.out.print("이름 : ");
      name[i] = scanner.next();

      System.out.print("나이 : ");
      age[i] = scanner.nextInt();

      System.out.print("재직중 (true/false) : ");
      working[i] = scanner.nextBoolean();

      System.out.print("성별 (남자:M, 여자:W) : ");
      String str = scanner.next();
      gender[i] = str.charAt(0);

      System.out.print("시력 (왼쪽, 오른쪽) : ");
      leftEye[i] = scanner.nextFloat();
      rightEye[i] = scanner.nextFloat();
    }

    System.out.println("\n----------------------\n");

    // int no = SIZE;
    // String name = "홍길동"; // name는 레퍼런스 변수이다.
    // int age = 20;
    // boolean working = true;
    // char gender = 'M';
    // float leftEye = 1.5f;
    // float rightEye = 1.0f; // camel 표기법, 파라미터명은 소문자 시작, class명은 대문자로 시작

    for (int i = 0; i < SIZE; i++) {
      System.out.printf("번호: %d\n", no[i]);

      System.out.printf("이름: %s\n", name[i]);

      System.out.printf("나이: %d\n", age[i]); // 나이라는 문자열과 20이라는 정수를 합쳐서 하나의 문자열로 전달

      System.out.printf("재직자 : %b\n", working[i]);

      System.out.printf("성별: (남자(M), 여자(W)): %c\n", gender[i]);

      System.out.printf("좌우시력: %.1f, %.1f\n", leftEye[i], rightEye[i]);
    }
  }
}