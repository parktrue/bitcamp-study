package bitcamp.myapp.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.util.Bean;
import bitcamp.util.ComponentScan;
import bitcamp.util.SqlSessionFactoryProxy;


// Application 을 실행하는데 필요한 객체를 설정하는 역할을 한다!
//
@ComponentScan(basePackages = {"bitcamp.myapp.dao", "bitcamp.myapp.handler"})
public class AppConfig {

  // Mybatis 객체를 준비한다.
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    return new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml")));
  }
}
