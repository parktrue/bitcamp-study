package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE]; // 레퍼런스 100개 생성

  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.name = Prompt.inputString("이름? ");
    m.email = Prompt.inputString("이메일? ");
    m.password = Prompt.inputString("암호? ");
    m.gender = inputGender((char) 0);
    m.no = userId++;

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[length++] = m; // m에는 멤버인스턴스의 주소를 가지고있다.
  }

  public static void printMembers() {
    System.out.println("\n-------------------------------\n");

    System.out.println("번호, 이름, 이메일, 성별\n");
    System.out.println("-----------나의 목록-----------");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n", m.no, m.name, m.email, toGenderString(m.gender));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야한다.
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.name);
        System.out.printf("이메일: %s\n", m.email);
        System.out.printf("성별: %s\n", toGenderString(m.gender));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("변경할 회원번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)?", m.name);
        m.name = Prompt.inputString("");
        System.out.printf("이메일(%s)?", m.email);
        m.email = Prompt.inputString("");
        System.out.println("새 암호?");
        m.password = Prompt.inputString("");
        m.gender = inputGender(m.gender);

        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private static char inputGender(char gender) {
    String label = "";
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    loop:
    while (true) {
      String menuNo = Prompt.inputString(label + " 1. 남자\n" + " 2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return MALE;
        case "2":
          return FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    int memberNo = Prompt.inputInt("삭제할 회원번호? "); // 입력받는다.

    int deletedIndex = indexOf(memberNo); // 입력받은걸
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}

  // for (int i = 0; i < length; i++) {
  //   if (Integer.parseInt(memberNo) == length) {
  //     no[length] = 0;
  //     name[length] = null;
  //     email[length] = null;
  //     password[length] = null;
  //     gender[length] = '\0';
  //     length--;
  //   } else if (no[i] == Integer.parseInt(memberNo)) {
  //     for (int j = 0; j < length; j++) {
  //       no[i] = no[i + 1];
  //       name[i] = name[i + 1];
  //       email[i] = email[i + 1];
  //       password[i] = password[i + 1];
  //       gender[i] = gender[i + 1];
  //     }
  //     length--;
  //     System.out.println("삭제에 성공했습니다!");
  //   }
  // }
  // System.out.println("해당 번호의 회원이 없습니다!");
  // CRUD
