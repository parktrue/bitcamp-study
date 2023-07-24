package coding.ex001;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class Test2 {

  public static void main(String[] args) {
    // BiFunction<T, U, R> 인터페이스
    // => R apply(T, U) / T U 파라미터를 받아서 R리턴

    // Map.put(키, 값)
    // => 키 : Character
    // => 값 : Integer
    // => 예) put('x', 100);

    // Map.compute(키, 값을 리턴할 객체)
    // => 키 : K
    // => 값을 리턴할 객체 : BiFunction<? super K, ? suer V, ? extends V>
    // => 예) compute('x', BitFunction 구현 객체);
    // put은 값을 직접 집어넣고 컴퓨트는 구현객체 apply메서드를 호출해서 apply가 리턴한 값을 x라는 값에 저장.
    // x라는 값을 저장할때 BiFunction의 리턴값을 x라는 이름으로 저장

    class MyValue implements BiFunction<Character, Integer, Integer> {
      @Override
      public Integer apply(Character key, Integer value) {
        // 이 메서드는 Map.compute() 가 호출한다.
        // 파라미터로 넘어 오는 것은 기존에 저장된 key와 value다.
        // 해당 키에 값이 없다면 null이 넘어온다.

        return (value == null) ? 1 : value + 1;
      }
    }
    MyValue 값생성기 = new MyValue();


    String str = "Be strong, be fearless, be beautiful. "
        + "And believe that anything is possible when you have the right "
        + "people there to support you. ";

    Map<Character, Integer> result = new HashMap<>();

    for (char ch : str.toCharArray()) {
      result.compute(ch, 값생성기);
      // result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
    }

    for (Entry<Character, Integer> entry : result.entrySet()) {
      System.out.printf("%c: %d\n", entry.getKey(), entry.getValue());
    }
  }
}
