package exam.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userdao;
	
	public String userEmailYn(String user_email) {
		int countEmail = 0;
		String message = "";
		log.info("before"+user_email);
		countEmail = userdao.userEmailYn(user_email);
		log.info("서비스"+user_email);
		if(countEmail > 0) { //이메일 존재
			message = "EmailOK";
		}else {
			message = "EmailNO";
		}
		return message;
	}
}
