package bitcamp.myapp;

import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정

public class App {

  public static void main(String[] args) {
    // 키보드 스캐너 준비
    // 각 데이터를 키보드를 통해 입력받아서 출력한다.

    printTitle();

    // 회원 정보 등록
    while (MemberHandler.available()) {
      MemberHandler.inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    MemberHandler.printMembers();

    Prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("\n-------------------------------\n");
  }

  static boolean promptContinue() {
    String response = Prompt.inputString("계속 하시겠습니까?(Y/n) ");
    // equalsIgnoreCase 는 대소문자를 구분하지 않겠다는 의미이다.
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }
}
