package exam.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	public List<BoardDTO> boardList(int start,int end) {
		return sqlSession.selectList("boardList");
	}
}
