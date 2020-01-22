package exam.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserMapper uMapper;
	
	public int userEmailYn(String user_email) {
		log.info("dao"+user_email);
		return uMapper.userEmailYn(user_email);
	}
}
