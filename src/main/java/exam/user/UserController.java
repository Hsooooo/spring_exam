package exam.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import exam.board.BoardDTO;
import exam.board.BoardService;

@Controller
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardService boardService;

	//메인
	@RequestMapping("/main.do")
	public String main(Model model,HttpServletRequest request,String page) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		String email = "";
		HttpSession session = request.getSession();
		session.getAttribute(email);
		
		//게시판 
		if(page == null) {
			page = "1";
		}
		int curPage = Integer.parseInt(page);
		int rowSize = 5;
		int start = (curPage * rowSize) - (rowSize - 1);
		int end = (curPage * rowSize);
		
		paramMap.put("start", start);
		paramMap.put("end", end);
		
		List<BoardDTO> list = (List<BoardDTO>)boardService.boardList(paramMap);
		
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../board/board_list.jsp"); // 메인에 게시판이씀.
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
		String result = userService.userEmailYn(user_email);
		
		return result;
	}
	
	//회원가입
	@RequestMapping("/insert.do")
	@ResponseBody
	public String insertUser(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> paramMap = new HashMap<String, String>();
		
		String user_name = request.getParameter("name");
		String user_email = request.getParameter("email");
		String user_pwd = request.getParameter("pwd");
		
		String result = "";
		paramMap.put("user_name", user_name);
		paramMap.put("user_email", user_email);
		paramMap.put("user_pwd", user_pwd);
		
		userService.insertUser(paramMap);
		
		return result;
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
		model.addAttribute("main_jsp", "../board/board_list.jsp");
		return "main/main";
	}
	//비밀번호찾기
	@RequestMapping("/forgot-password.do")
	public String forgotPassword() {
		return "main/forgot-password";
	}
}
