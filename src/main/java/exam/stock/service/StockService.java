package exam.stock.service;

import java.util.List;
import java.util.Map;

import exam.stock.dto.StockDto;

public interface StockService {

	public List<StockDto> getStockList(Map<String, String> paramMap) throws Exception;
}
