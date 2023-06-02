package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정
import java.util.Scanner;

public class App {

  static Scanner scanner = new java.util.Scanner(System.in);

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  public static void main(String[] args) {
    // 키보드 스캐너 준비
    // 각 데이터를 키보드를 통해 입력받아서 출력한다.

    printTitle();

    // 회원 정보 등록
    while (length < MAX_SIZE) {
      inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    printMembers();
    scanner.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("\n-------------------------------\n");
  }

  static void inputMember() {
    System.out.print("이름 : ");
    name[length] = scanner.next();

    System.out.print("이메일 : ");
    email[length] = scanner.next();

    System.out.print("암호 : ");
    password[length] = scanner.next();

    loop:
    while (true) {
      System.out.println("성별 : ");
      System.out.println(" 1. 남자");
      System.out.println(" 2. 여자");
      System.out.print("> ");
      String menuNo = scanner.next();
      scanner.nextLine(); // 입력 값(token) 읽고 난 후에 남아있는 줄바꿈 코드를 제거한다.
      switch (menuNo) {
        case "1":
          gender[length] = 'M';
          break loop;
        case "2":
          gender[length] = 'W';
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
    no[length] = userId++;
    length++;
  }

  static boolean promptContinue() {
    System.out.print("계속 하시겠습니까?(Y/n) ");
    String response = scanner.nextLine();
    // equalsIgnoreCase 는 대소문자를 구분하지 않겠다는 의미이다.
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers() {
    System.out.println("\n-------------------------------\n");

    System.out.println("번호, 이름, 이메일, 성별\n");
    System.out.println("-----------나의 목록-----------");
    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
    }
  }
}
