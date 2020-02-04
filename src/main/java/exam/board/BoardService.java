package exam.board;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardDAO boardDao;
	
	public List<BoardDTO> boardList(Map<String,Object> paramMap) {
		return boardDao.boardList(paramMap);
	}
	
	public BoardDTO boardDetail(int board_no) {
		return boardDao.boardDetail(board_no);
	}
	
}
