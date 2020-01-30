package exam.core.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

//WebApplicationInitializer 를 impl 해줌으로써 스프링이 web.xml을 안읽고 얠 읽음
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//하단 내용들은 web.xml이랑 비교해서 보면 비슷한 꼴이 많을테니 이해는 어렵지 않을듯
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("exam.core.config");
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.do");
		
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		
		
		
	}

}
