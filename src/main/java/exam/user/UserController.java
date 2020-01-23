package exam.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/main.do")
	public String main(Model model) {
		model.addAttribute("main_jsp", "../main/main1.jsp");
		return "main/main";
	}
	//게시판
	@RequestMapping("/board.do")
	public String board(Model model) {
		return "main/board";
	}
	//회원가입
	@RequestMapping("/join.do")
	public String join() {
		return "main/join";
	}
	//email중복체크 
	@RequestMapping("/join_ok.do")
	public String join_ok(HttpServletRequest request,HttpServletResponse response,Model model) {
		String user_email = (String)request.getParameter("email");
		
		return "main/join_ok";
	}
	
	//로그인
	@RequestMapping("/login.do")
	public String login() {
		return "main/login";
	}
	//
	@RequestMapping("/login_ok.do")
	public String login_ok(HttpServletRequest request,HttpServletResponse response,Model model) {
		String user_email = (String)request.getParameter("email");
		log.info("컨트롤"+user_email);
		String result = userService.userEmailYn(user_email);
		log.info("R:"+result);
		
		model.addAttribute("result", result);
		return "login_ok"; /////한수씨........값 넘기는 거ㅓ...도와주세엽,,,,ㅠㅠㅠㅠ
	}
	
	//비밀번호찾기
	@RequestMapping("/forgot-password.do")
	public String forgotPassword() {
		return "main/forgot-password";
	}
}
