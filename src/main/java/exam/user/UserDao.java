package exam.user;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	SqlSession sqlSession;
	
	public int userEmailYn(String user_email) {
		return (Integer)sqlSession.selectOne("userEmailYn");
	};
}
