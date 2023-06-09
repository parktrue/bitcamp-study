package bitcamp.test.step13.vo;

public class Score {
  public String name;
  int kor;
  int eng;
  int math;
  public int sum;
  public float aver;

  // 생성자 : 인슨턴스를 생성한 직후 호출하는 메서드
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
