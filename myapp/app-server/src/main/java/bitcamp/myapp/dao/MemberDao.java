package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao {

  int insert(Member member);

  List<Member> findAll();

  Member findBy(int no);

  Member findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

  int update(Member member);

  int delete(int no);
}
