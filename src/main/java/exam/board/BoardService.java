package exam.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardDAO boardDao;
	
	public List<BoardDTO> boardList(int start,int end) {
		
		return boardDao.boardList(start, end);
	}
	
}
