package exam.home.cont;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.stock.service.StockService;
import exam.user.cont.UserController;
import exam.user.util.CrawlingUtil;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	StockService stockService;
	
	@RequestMapping("/home.do")
	public String home(Model model, HttpServletRequest request) {
		String kindType = request.getParameter("kindType");
		logger.info("kindtype : " + kindType);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("kindType",kindType);
		
		
		return "crawling/crawHome";
	}
	
	@RequestMapping("/stockDetail.do")
	public String stockDetail(Model model) {
		CrawlingUtil crawlingUtil = new CrawlingUtil();
		String html = crawlingUtil.getHtml("http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code=035420");
		JSONObject json = XML.toJSONObject(html);
		
		logger.info(json.toString());
		Map<String, Object> resultMap = crawlingUtil.parseJsonToMap(json.toString());
		
		model.addAttribute("map",resultMap);
		
		return "crawling/krx";
	}
}
