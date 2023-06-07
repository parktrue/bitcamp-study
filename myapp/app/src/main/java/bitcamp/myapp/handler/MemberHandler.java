package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    name[length] = Prompt.inputString("이름? ");
    email[length] = Prompt.inputString("이메일? ");
    password[length] = Prompt.inputString("암호? ");

    loop:
    while (true) {
      String menuNo = Prompt.inputString("성별 : \n" + " 1. 남자\n" + " 2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          gender[length] = MALE;
          break loop;
        case "2":
          gender[length] = FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("\n-------------------------------\n");

    System.out.println("번호, 이름, 이메일, 성별\n");
    System.out.println("-----------나의 목록-----------");
    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %s\n", no[i], name[i], email[i], toGenderString(gender[i]));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야한다.
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("이메일: %s\n", email[i]);
        System.out.printf("성별: %s\n", toGenderString(gender[i]));
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
      if (no[i] == Integer.parseInt(memberNo)) {
        name[i] = Prompt.inputString("이름? ");
        email[i] = Prompt.inputString("이메일? ");
        password[i] = Prompt.inputString("암호? ");

        loop:
        while (true) {
          String menuNo = Prompt.inputString("성별 : \n" + " 1. 남자\n" + " 2. 여자\n" + "> ");

          switch (menuNo) {
            case "1":
              gender[i] = MALE;
              break loop;
            case "2":
              gender[i] = FEMALE;
              break loop;
            default:
              System.out.println("무효한 번호입니다.");
          }
        }
        break;
      }
    }
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
