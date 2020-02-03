package exam.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board_list.do")
	public String boardList(Model model) {
		List<BoardDTO> list = (List<BoardDTO>)boardService.boardList();
		model.addAttribute("list", list);
		
		return "/board/board_list";
	}
}
