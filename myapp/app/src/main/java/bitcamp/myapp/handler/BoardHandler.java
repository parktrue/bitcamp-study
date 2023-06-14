package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE]; // 레퍼런스 100개 생성
  static int length = 0;

  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));

    boards[length++] = board; // m에는 멤버인스턴스의 주소를 가지고있다.
  }

  public static void printBoard() {
    System.out.println("-------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일\n");
    System.out.println("-------------------------------");


    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }


  public static void viewBoard() {
    // String memberNo = Prompt.inputString("번호? ");
    // // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야한다.
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // if (board.getNo() == Integer.parseInt(memberNo)) {
    // System.out.printf("이름: %s\n", board.getName());
    // Systeboard.out.printf("이메일: %s\n", board.getEmail());
    // Systeboard.out.printf("성별: %s\n", toGenderString(board.getGender()));
    // return;
  }



  public static void updateBoard() {
    // String memberNo = Prompt.inputString("변경할 회원번호? ");
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // if (board.getNo() == Integer.parseInt(memberNo)) {
    // Systeboard.out.printf("이름(%s)?", board.getName());
    // board.setName(Prompt.inputString(""));
    // Systeboard.out.printf("이메일(%s)?", board.getEmail());
    // board.setEmail(Prompt.inputString(""));
    // Systeboard.out.println("새 암호?");
    // board.setPassword(Prompt.inputString(""));
    // board.setGender(inputGender(board.getGender()));
    //
    // return;
    // }
    // }
    // Systeboard.out.println("해당 번호의 회원이 없습니다!");
  }


  public static void deleteBoard() {
    // int memberNo = Prompt.inputInt("삭제할 회원번호? "); // 입력받는다.
    //
    // int deletedIndex = indexOf(memberNo); // 입력받은걸
    // if (deletedIndex == -1) {
    // Systeboard.out.println("해당 번호의 회원이 없습니다!");
    // return;
    // }
    //
    // for (int i = deletedIndex; i < length - 1; i++) {
    // boards[i] = boards[i + 1];
    // }
    //
    // boards[--length] = null;
  }

  private static int indexOf(int boardNo) {
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}

