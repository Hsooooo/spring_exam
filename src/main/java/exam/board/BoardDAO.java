package exam.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardDTO> boardList() {
		return boardMapper.boardList();
	}
}
