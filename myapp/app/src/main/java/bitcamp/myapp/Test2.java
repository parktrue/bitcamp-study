// package bitcamp.myapp;

// // 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
// import java.util.Scanner;

// public class Test2 {
// public static void main(String[] args) {

// printTitle();
// inputMember(scanner, i, name, email, package, gender, userId);
// promptContinue(scanner);
// printMembers(no, name, email, gender)

// // 키보드 스캐너 준비
// Scanner scanner = new Scanner(System.in);

// final int MAX_SIZE = 100;
// int userId = 1;
// int length = 0;

// int[] no = new int[MAX_SIZE];
// String[] name = new String[MAX_SIZE];
// String[] email = new String[MAX_SIZE];
// String[] password = new String[MAX_SIZE];
// char[] gender = new char[MAX_SIZE];

// // 회원정보 등록
// for (int i = 0; i < MAX_SIZE; i++) {

// no[i] = userId++;

// length++;

// }

// }

// static void printTitle () {
// System.out.println("나의 목록 관리 시스템");
// System.out.println("----------------------------------");
// }

// static void inputMember (Scanner scanner, int[] i, String[] name,
// String[] email, String[] password,
// char[] gender, int[] userId) {
//         System.out.print("이름? ");
//         name[i] = scanner.next();

//         System.out.print("이메일? ");
//         email[i] = scanner.next();

//         System.out.print("암호? ");
//         password[i] = scanner.next();

//         loop: while (true) {
//           System.out.println("성별: ");
//           System.out.println("  1. 남자");
//           System.out.println("  2. 여자");
//           System.out.print("> ");
//           String menuNo = scanner.next();
//           scanner.nextLine(); // 이전에 next()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.

//           switch (menuNo) {
//             case "1":
//               gender[i] = 'M';
//               break loop;
//             case "2":
//               gender[i] = 'W';
//               break loop;
//             default:
//               System.out.println("무효한 번호입니다.");
//           }
//         }
//       }

//       static boolean promptContinue(Scanner scanner) {
//         System.out.print("계속 하시겠습니까?(Y/n) ");
//         String response = scanner.nextLine();
//         if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
//           break;
//         }
//       }

//       static void printMembers (int[] no, String[] name, String[] email, char[] gender) {
//         System.out.println("---------------------------------------");

//         System.out.println("번호, 이름, 이메일, 성별");
//         System.out.println("---------------------------------------");

//         for (int i = 0; i < length; i++) {
//         System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
//         }
//         scanner.close();
// }
