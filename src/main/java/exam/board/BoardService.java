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
	
	//리스트
	public List<BoardDTO> boardList(Map<String,Object> paramMap) {
		return boardDao.boardList(paramMap);
	}
	//상세보기
	public BoardDTO boardDetail(int board_no) {
			   boardDao.boardCntHit(board_no);
		return boardDao.boardDetail(board_no);
	}
	//게시판글추가
	public int boardInsert_ok(BoardDTO boarddto) {
		return boardDao.boardInsert_ok(boarddto);
	}
	//게시글삭제
	public int boardDelete(int board_no) {
		return boardDao.boardDelete(board_no);
	}
	
}
