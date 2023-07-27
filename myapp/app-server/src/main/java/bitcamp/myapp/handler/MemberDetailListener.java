package bitcamp.myapp.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MemberDetailListener implements ActionListener {

  MemberDao memberDao;
  SqlSessionFactory sqlSessionFactory;


  public MemberDetailListener(MemberDao memberDao, SqlSessionFactory sqlSessionFactory) {
    this.memberDao = memberDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int memberNo = prompt.inputInt("번호? ");

    Member m = memberDao.findBy(memberNo);
    if (m == null) {
      prompt.println("해당 번호의 회원이 없습니다!");
      return;
    }

    prompt.printf("이름: %s\n", m.getName());
    prompt.printf("이메일: %s\n", m.getEmail());
    prompt.printf("성별: %s\n", m.getGender() == 'M' ? "남성" : "여성");
    prompt.printf("가입일: %s\n", m.getCreatedDate());

    try {
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }

  }
}
