package exam.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	//게시판
		@RequestMapping("/board.do")
		public String board(Model model) {
			return "main/board";
		}
}
