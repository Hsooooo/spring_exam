package exam.core.config;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
 * Configuration -> 이것이 설정파일이다!
 * PropertySource -> 읽어들일 prop 파일
 */

@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConfiguration {
	//요건 왜 쓰는지 모르겟지만 일단 쓰래
	@Autowired
	private ApplicationContext applicationContext;
	
	//이건 상단 PropertySource로 가져온 파일을 환경파일로 읽어들일때 쓰는건가..
	@Autowired
	Environment env;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(env.getProperty("db.className"));
		source.setUrl(env.getProperty("db.url"));
		source.setUsername(env.getProperty("db.username"));
		source.setPassword(env.getProperty("db.password"));
		
		return source;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSession sqlSession() throws Exception{
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		sqlSessionTemplate.clearCache();
		return sqlSessionTemplate;
	}
}
