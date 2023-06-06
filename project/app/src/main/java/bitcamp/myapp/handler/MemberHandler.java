package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static int[] age = new int[MAX_SIZE];
  static String[] rank = new String[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final String SERGEANT = "병장";
  static final String CORPORAL = "상병";
  static final String PRIVATEFC = "일병";
  static final String PRIVATE = "이병";

  public static void inputMember() {
    name[length] = Prompt.inputString("이름? ");
    age[length] = Prompt.inputAge("나이? ");

    loop:
    while (true) {
      String menuNo =
          Prompt.inputString("계급 : \n" + " 1. 병장\n" + " 2. 상병\n" + " 3. 일병\n" + " 4. 이병\n" + "> ");

      switch (menuNo) {
        case "1":
          rank[length] = SERGEANT;
          break loop;
        case "2":
          rank[length] = CORPORAL;
          break loop;
        case "3":
          rank[length] = PRIVATEFC;
          break loop;
        case "4":
          rank[length] = PRIVATE;
          break loop;
        default:
          System.out.println("1~4 숫자를 입력하세요.");
      }
    }
    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("\n-------------------------------\n");

    System.out.println("순번, 이름, 나이, 계급\n");
    System.out.println("-----------병력 현황-----------");
    for (int i = 0; i < length; i++) {
      System.out.printf("%d,   %s, %d, %s\n", no[i], name[i], age[i], rank[i]);
    }
  }

  public static boolean available() {
    return length < MAX_SIZE;
  }
}
