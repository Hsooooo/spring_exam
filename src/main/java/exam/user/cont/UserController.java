package exam.user.cont;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/main.do")
	public String main() {
		logger.info("--------------main Go---------");
		return "main/main";
	}
	
}
