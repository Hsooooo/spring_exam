package exam.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	//메인
	@RequestMapping("/main.do")
	public String main(Model model) {
		model.addAttribute("main_jsp", "../main/main1.jsp");
		return "main/main";
	}
	//회원가입
	@RequestMapping("/join.do")
	public String join() {
		return "main/join";
	}
	
	//이메일중복체크
	@RequestMapping("/join_ok.do")
	@ResponseBody
	public String join_ok(HttpServletRequest request,HttpServletResponse response,Model model) {
		String user_email = (String)request.getParameter("email");
		log.info("이메일: "+user_email);
		String result = userService.userEmailYn(user_email);
		log.info("중복체크: "+result);
		
		return result;
	}
	
	//회원가입
	@RequestMapping("/insert.do")
	public String insertUser() {
		return "";
	}
	
	//로그인
	@RequestMapping("/login.do")
	public String login() {
		return "main/login";
	}
	//이메일체크
	@RequestMapping("/login_chk.do")
	@ResponseBody
	public String login_chk(HttpServletRequest request,HttpServletResponse response) {
		String user_email = (String)request.getParameter("email");
		//log.info("컨트롤"+user_email);
		String result = userService.userEmailYn(user_email);
		//log.info("R:"+result);
		
		return result;
	}
	//로그인처리
	@RequestMapping("/login_ok.do")
	public String login_ok(HttpServletRequest request, HttpServletResponse response) {
		String user_email = (String)request.getParameter("email");
		HttpSession session = request.getSession();
		session.setAttribute("email", user_email);
		return "main/login";
	}
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("main_jsp", "../main/main1.jsp");
		return "main/main";
	}
	//비밀번호찾기
	@RequestMapping("/forgot-password.do")
	public String forgotPassword() {
		return "main/forgot-password";
	}
}
