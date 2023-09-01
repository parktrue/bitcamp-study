package bitcamp.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 페이지 컨트롤러 사용 규칙을 정의한다.
public interface PageController {

  String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
