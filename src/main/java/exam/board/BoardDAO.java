package exam.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;

	public List<BoardDTO> boardList(Map<String, Object> paramMap) {
		return sqlSession.selectList("boardList", paramMap);
	}
	
	public BoardDTO boardDetail(int board_no) {
		return sqlSession.selectOne("boardDetail", board_no);
	}
}
