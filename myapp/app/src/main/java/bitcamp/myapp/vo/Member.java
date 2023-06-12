package bitcamp.myapp.vo;

// 데이터를 저장할 메모리 설계도 > 메모리 준비 > 설계도에 따라 변수를 생성한다.
public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }
}
