package bitcamp.test.step17;

import bitcamp.test.step17.vo.Score;

// 01) 낱개의 변수 사용
// 02) 낱개의 변수 재사용
// 03) 배열 사용
// 04) 클래스를 이용하여 데이터 타입 정의 (중첩클래스; 로컬클래스)
// 05) 출력 기능을 별도의 메서드로 분리 (중첩클래스; 스태틱클래스)
// 06) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 07) GRASP 패턴 : Information Exprt(정보를 갖고있는 클래스가 그 정보를 다룬다.)
// 08) 인스턴스 메서드 도입
// 09) 객체 생성이 복잡한 경우 메서드로 분리하는 것이 낫다.(디자인패턴; 팩토리 메서드)
// 10) GRASP 패턴 : Information Exprt --createScore()를 Score 클래스로 이동
// 11) 생성자 도입 : 인스턴스 변수를 보다 쉽게 초기화 시키기
// 12) 클래스를 유지보수 하기 쉽게 별도 소스 파일로 분리
// 13) 클래스를 유지보수 하기 쉽게 패키지로 분류 : import, public
// 14) 외부 접근 차단과 값 꺼내기 : private, getter
// 15) 프로그래밍의 일관성을 위해 보통 다른 필드에 대해서도 getter를 만들고 사용한다.
// 16) 필드에 직접 접근을 막고 setter를 정의하는 이유
// 17) 필드에 직접 접근을 막기 : 인스턴스 변수에 무효한 값이 저장되지 않게 하기 위해
// => getter 정의 : 값을 꺼낼 때 사용
// => setter 정의 : 값을 변경할 때 사용. 단 유효한 값을 저장하도록 통제한다.
public class App {

  public static void main(String[] args) {
    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    scores[length++] = new Score("홍길동", 100, 100, 100);
    scores[length++] = new Score("임꺽정", 90, 90, 90);
    scores[length++] = new Score("유관순", 80, 80, 80);

    // scores[0].kor = 7000; // 직접 접근 불가
    scores[0].setKor(55); // setter를 통해서는 값 변경이 가능하다. 단 유효한 값만 가능하다.
    // scores[0].compute(); // 호출하는 것을 잊어버릴 수 있기 때문에 setter에서 호출한다.

    for (int i = 0; i < 3; i++) {
      printscore(scores[i]);
    }
  }

  static void printscore(Score s) {
    System.out.printf(
        "%s: 국어=%d, 영어=%d, 수학=%d, 합계=%d, 평균=%.1f\n",
        s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
  }
}
