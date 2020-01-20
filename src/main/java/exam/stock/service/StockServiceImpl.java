package exam.stock.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.stock.dao.StockDao;
import exam.stock.dto.StockDto;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockDao stockDao;
	
	@Override
	public List<StockDto> getStockList(Map<String, String> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return stockDao.getStockList(paramMap);
	}
	
}
