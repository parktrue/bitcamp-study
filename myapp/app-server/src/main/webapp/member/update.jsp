<%@ page
        language="java"
        pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8"
        trimDirectiveWhitespaces="true"
        errorPage="/error.jsp"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bitcamp.myapp.dao.BoardDao" %>
<%@ page import="bitcamp.myapp.vo.AttachedFile" %>
<%@ page import="bitcamp.myapp.vo.Board" %>
<%@ page import="bitcamp.myapp.vo.Member" %>
<%@ page import="bitcamp.util.NcpObjectStorageService" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>


<%
    request.setAttribute("refresh", "2;url=list.jsp?category=" + request.getParameter("category"));

Member loginUser = (Member) request.getSession().getAttribute("loginUser");
if (loginUser == null) {
response.sendRedirect("/auth/form");
return;
}

BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");
NcpObjectStorageService ncpObjectStorageService = (NcpObjectStorageService) this.getServletContext().getAttribute("ncpObjectStorageService");


Board board = new Board();
board.setWriter(loginUser);
board.setNo(Integer.parseInt(request.getParameter("no")));
board.setTitle(request.getParameter("title"));
board.setContent(request.getParameter("content"));
board.setCategory(Integer.parseInt(request.getParameter("category")));

ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
for (Part part : request.getParts()) {
if (part.getName().equals("files") && part.getSize() > 0) {
String uploadFileUrl = ncpObjectStorageService.uploadFile(
"bitcamp-nc7-bucket-01", "board/", part);
AttachedFile attachedFile = new AttachedFile();
attachedFile.setFilePath(uploadFileUrl);
attachedFiles.add(attachedFile);
}
}
board.setAttachedFiles(attachedFiles);

if (boardDao.update(board) == 0) {
throw new Exception("게시글이 없거나 변경 권한이 없습니다.");
} else {
if (attachedFiles.size() > 0) {
// 게시글을 정상적으로 변경했으면, 그 게시글의 첨부파일을 추가한다.
int count = boardDao.insertFiles(board);
System.out.println(count);
}

sqlSessionFactory.openSession(false).commit();
response.sendRedirect("list.jsp?category=" + request.getParameter("category"));
}
%>
