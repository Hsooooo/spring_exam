package exam.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
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
	public String join_ok(String email,Model model) {
		
		return "../main/join_ok.jsp";
	}
	//로그인
	@RequestMapping("/login.do")
	public String login(String id,String pwd,Model model) {
		return "main/login";
	}
	//비밀번호찾기
	@RequestMapping("/forgot-password.do")
	public String forgotPassword() {
		return "main/forgot-password";
	}
}
