package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정
import java.util.Scanner;

public class App {
public static void main(String[] args) {
  System.out.println("나의 목록 관리 시스템");
  System.out.println("------------------------");

  // 키보드 스캐너 준비
  // 각 데이터를 키보드를 통해 입력받아서 출력한다.
  Scanner scanner = new java.util.Scanner(System.in);

  System.out.print("번호 : ");
  int no = scanner.nextInt();

  System.out.print("이름 : ");
  String name = scanner.next();

  System.out.print("나이 : ");
  int age = scanner.nextInt();

  System.out.print("재직중 (true/false) : ");
  boolean working = scanner.nextBoolean();

  System.out.print("성별 (남자:M, 여자:W) : ");
  String str = scanner.next();
  char gender = str.charAt(0);

  System.out.print("시력 (왼쪽, 오른쪽) : ");
  float leftEye = scanner.nextFloat();
  float rightEye = scanner.nextFloat();

  System.out.println("----------------------");


  // int no = 100;
  // String name = "홍길동"; // name는 레퍼런스 변수이다.
  // int age = 20;
  // boolean working = true;
  // char gender = 'M';
  // float leftEye = 1.5f;
  // float rightEye = 1.0f; // camel 표기법, 파라미터명은 소문자 시작, class명은 대문자로 시작

  System.out.printf("번호: %d\n", no);

  System.out.printf("이름: %s\n", name);

  System.out.printf("나이: %d\n", age); //나이라는 문자열과 20이라는 정수를 합쳐서 하나의 문자열로 전달

  System.out.printf ("재직자 : %b\n", working);

  System.out.printf ("성별: (남자(M), 여자(W)): %c\n", gender);

  System.out.printf ("좌우시력: %.1f, %.1f\n", leftEye, rightEye);
  }
}