package exam.board;

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
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.core.pattern.parser.Parser;

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
		
		//log.info("이메일 누구꺼냐 ? "+email);
		
		
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../board/board_detail.jsp");
		return "main/main";
	}
	
	@RequestMapping("/board_insert.do")
	public String boardInsert(Model model,HttpServletRequest request) {
		
		String email = "";
		HttpSession session = request.getSession();
		session.getAttribute(email);
		
		model.addAttribute("main_jsp", "../board/board_insert.jsp");
		return "main/main";
	}
	
	@RequestMapping("/board_insert_ok.do")
	public String boardInsert_ok(HttpServletRequest request,Model model,String page) {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String email   = request.getParameter("email");
		
		BoardDTO boarddto = new BoardDTO();
		
		boarddto.setBoard_email(email);
		boarddto.setBoard_subject(subject);
		boarddto.setBoard_content(content);
		log.info(boarddto.toString());
		int cnt = 0;
		
		cnt = boardService.boardInsert_ok(boarddto);
		
		if(cnt > 1) {
			log.info("===========비정상처리 [데이터 인서트 안됨]");
		}else {
			log.info("정상처리");
		}
		
		//게시판 
		if(page == null) {
			page = "1";
		}
		int curPage = Integer.parseInt(page);
		int rowSize = 5;
		int start = (curPage * rowSize) - (rowSize - 1);
		int end = (curPage * rowSize);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		
		List<BoardDTO> list = (List<BoardDTO>)boardService.boardList(paramMap);
		
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../board/board_list.jsp");
		return "main/main";
	}
	
	@RequestMapping("/board_update.do")
	public String boardUpdate() {
		
		return "";
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(HttpServletRequest request,Model model) {
		String board_no = request.getParameter("no");
		
		log.info("##########"+board_no);
		
		boardService.boardDelete(Integer.parseInt(board_no));
		
		int cnt = 0;
		if(cnt > 1) {
			log.info("============= 정상처리안됨 ========");
		}else {
			log.info("============= 정상처리완료 ========");
		}
		
		model.addAttribute("main_jsp", "../board/board_list.jsp");
		return "main/main";
	}

}

