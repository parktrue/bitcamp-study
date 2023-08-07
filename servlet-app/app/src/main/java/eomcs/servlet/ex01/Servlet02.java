package eomcs.servlet.ex01;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex01/s2")
public class Servlet02 extends GenericServlet {

  // GenericServlet 추상 클래스는 java.io.Serialize 인터페이스를 구현하였다.
  // => serialVersionUID 변수 값을 설정해야 한다.
  private static final long serialVersionUID = 1L;

  public Servlet02() {
    System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Servlet02.service(ServletRequest,ServletResponse)");
  }
}

