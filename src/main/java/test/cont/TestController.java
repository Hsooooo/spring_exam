package test.cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
}
