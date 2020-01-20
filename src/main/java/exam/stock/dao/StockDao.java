package exam.stock.dao;

import java.util.List;
import java.util.Map;

import exam.stock.dto.StockDto;

public interface StockDao {
	public List<StockDto> getStockList(Map<String, String> paramMap) throws Exception;
}
