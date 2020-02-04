package exam.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/board_detail.do")
	public String boardDetail(Model model, HttpServletRequest request) {
		String email = "";
		int board_no = (Integer.parseInt(request.getParameter("no")));
		//log.info("게시물번호 들어오니? "+board_no);
		BoardDTO list = boardService.boardDetail(board_no);
		
		HttpSession session = request.getSession();
		session.getAttribute(email);
		
		log.info("이메일 누구꺼냐 ? "+email);
		
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../board/board_detail.jsp");
		return "main/main";
	}
	
	@RequestMapping("/board_insert.do")
	public String boardInsert(Model model) {
		
		
		model.addAttribute("main_jsp", "../board/board_insert.jsp");
		return "main/main";
	}
	

}
