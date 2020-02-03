package exam.user;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	SqlSession sqlSession;
	
	public int userEmailYn(String user_email) {
		return (Integer)sqlSession.selectOne("userEmailYn",user_email);
	}
	
	public void insertUser(Map<String, String> paramMap) {
		sqlSession.selectList("insertUser", paramMap);
	}
}
