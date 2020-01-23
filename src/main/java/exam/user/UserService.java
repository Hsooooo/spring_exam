package exam.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;
	
	public String userEmailYn(String user_email) {
		int countEmail = 0;
		String result = "";
		log.info("before"+user_email);
		countEmail = userDao.userEmailYn(user_email);
		log.info("서비스"+user_email);
		if(countEmail > 0) { //이메일 존재
			result = "1";
		}else {
			result = "0";
		}
		return result;
	}
}
