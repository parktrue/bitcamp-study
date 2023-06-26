package bitcamp.util;

public class Test {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add(new String("홍길동"));

    names.add("임꺽정");
    names.add("유관순");
    names.add("이순신");

    // Object[] arr = names.toArray();
    String[] arr = names.toArray(new String[0]);


    for (String item : arr) {
      System.out.println(item); // arr[i]의 실제타입은 String이다.
    }
  }
}
