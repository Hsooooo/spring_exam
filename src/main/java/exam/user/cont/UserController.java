package exam.user.cont;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exam.user.dto.UserDto;
import exam.user.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/main.do")
	public String main() {
		logger.info("--------------main Go---------");
		return "main/main";
	}
	
	@RequestMapping("/down.do")
	public ModelAndView down() throws Exception {
		logger.info("-----------down_Start-----------");
		List<UserDto> userDtoList = userService.userList();
		for(int i=0; i<userDtoList.size(); i++) {
			logger.info("User Name :["+userDtoList.get(i).getUser_name()+"]");
		}
		
		String fullPath = "/var/apache-tomcat-8.5.50/webapps" + "/" + "starbucks.apk";
		
		File file = new File(fullPath);
		
		return new ModelAndView("download","downloadFile",file);
	}
	
}
