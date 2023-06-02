package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // 키보드 스캐너 준비
    // 각 데이터를 키보드를 통해 입력받아서 출력한다.
    Scanner scanner = new java.util.Scanner(System.in);

    final int MAX_SIZE = 100; // final 변수는 값이 한번 들어가면 값을 바꿀 수 없다.(상수)
    int userId = 1;
    int length = 0;

    // int[] no = new int[MAX_SIZE]; // 3은 메모리의 개수이며 int는 만들 메모리의 데이터 타입이다. no는 배열의
    // 주소를 담는 레퍼런스이다.
    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];
    printTitle();

    // 회원 정보 등록
    for (int i = 0; i < MAX_SIZE; i++) {
      // i++; // 값을 1개 증가 == i += 1;, i = i + 1;
      inputMember(scanner, i, name, email, password, gender, no, userId++);
      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    printMembers(length, no, name, email, gender);
    scanner.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("\n-------------------------------\n");
  }

  static void inputMember(
      Scanner scanner,
      int i,
      String[] name,
      String[] email,
      String[] password,
      char[] gender,
      int[] no,
      int userId) {
    System.out.print("이름 : ");
    name[i] = scanner.next();

    System.out.print("이메일 : ");
    email[i] = scanner.next();

    System.out.print("암호 : ");
    password[i] = scanner.next();

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
          gender[i] = 'M';
          break loop;
        case "2":
          gender[i] = 'W';
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
    no[i] = userId++;
  }

  static boolean promptContinue(Scanner scanner) {
    System.out.print("계속 하시겠습니까?(Y/n) ");
    String response = scanner.nextLine();
    // equalsIgnoreCase 는 대소문자를 구분하지 않겠다는 의미이다.
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers(int length, int[] no, String[] name, String[] email, char[] gender) {
    System.out.println("\n-------------------------------\n");

    System.out.println("번호, 이름, 이메일, 성별\n");
    System.out.println("-----------나의 목록-----------");
    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
    }
  }
}
