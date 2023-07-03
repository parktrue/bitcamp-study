// 객체 --> JSON 문자열 : 배열 다루기
package com.eomcs.openapi.json.gson;


import java.sql.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Exam0211 {
  public static void main(String[] args) {


    // 1) 배열 준비
    Member m1 = new Member();
    m1.setNo(101);
    m1.setName("홍길동");
    m1.setEmail("hong@test.com");
    m1.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member m2 = new Member();
    m2.setNo(102);
    m2.setName("임꺽정");
    m2.setEmail("leem@test.com");
    m2.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member m3 = new Member();
    m3.setNo(103);
    m3.setName("안창호");
    m3.setEmail("ahn@test.com");
    m3.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member[] members = {m1, m2, m3};
    // Gson gson = new Gson();

    // GsonBuilder builder = new GsonBuilder(); 빌더객체 준비
    // builder.setDateFromat("yyyy-MM-dd"); 빌더의 날짜설정 준비
    // Gson gson = builder.create(); 생성한다. => 이와같은걸 아래와같이 한줄로 만들 수 있다.
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    String jsonStr = gson.toJson(members);
    // String jsonStr = new Gson().toJson(members);

    System.out.println(jsonStr);

  }
}

// JSON 배열 형식 - [{ 객체 정보 },{ 객체 정보}, ...]
// => [
// {"프로퍼티명":값,"프로퍼티명":값, ...},
// {"프로퍼티명":값,"프로퍼티명":값, ...},
// {"프로퍼티명":값,"프로퍼티명":값, ...},
// ...
// ]
//


