// 메서드 chianing call
package com.eomcs.openapi.json.gson;

public class Exam0116 {


  public static void main(String[] args) {

    class Member {
      int no;
      String name;
      String email;
      String password;
      boolean working;


      public int getNo() {
        return no;
      }

      public Member setNo(int no) {
        this.no = no;
        return this;
      }

      public String getName() {
        return name;
      }

      public Member setName(String name) {
        this.name = name;
        return this;
      }

      public String getEmail() {
        return email;
      }

      public Member setEmail(String email) {
        this.email = email;
        return this;
      }

      public String getPassword() {
        return password;
      }

      public Member setPassword(String password) {
        this.password = password;
        return this;
      }

      public boolean isWorking() {
        return working;
      }

      public Member setWorking(boolean working) {
        this.working = working;
        return this;
      }


      Member m = new Member().m.setNo(100).m.setName("홍길동").m.setEmail("hong@test.com").m
          .setPassword("1111").m.setWorking(true);
    }
  }
}
// JSON 객체 형식 - { 객체 정보 }
// => { "프로퍼티명" : 값, "프로퍼티명": 값, ...}
//
// 값:
// - 문자열 => "값"
// - 숫자 => 값
// - 논리 => true, false
//
// 프로퍼티명은 반드시 문자열로 표현해야 한다.


