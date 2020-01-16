package test.cont;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/main.do")
	public String main(Model model) {
		model.addAttribute("main_jsp", "../main/main1.jsp");
		return "main/main";
	}
	
	@RequestMapping("/board.do")
	public String board(Model model) {
		//model.addAttribute("main_jsp", "../main/board.jsp");
		return "main/board";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "main/login";
	}
	@RequestMapping("/forgot-password.do")
	public String forgotPassword() {
		return "main/forgot-password";
	}
}
