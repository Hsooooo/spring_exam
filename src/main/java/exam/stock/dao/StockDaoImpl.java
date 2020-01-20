package exam.stock.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.stock.dto.StockDto;

@Repository
public class StockDaoImpl implements StockDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<StockDto> getStockList(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getStockList", paramMap);
	}

}
