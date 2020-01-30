package exam.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import exam.user.util.DownloadView;

/*
 * Configuration -> 이 파일이 설정파일이다 알리는 것 (스프링이 얠 설정파일로 읽음)
 * EnableWebMvc -> applicationContext.xml 에서 anotation-driven/> 설정이랑 같다고 생각하면 됨
 * ComponentScan -> 이것도 applicationContext.xml 에 있던 설정 (exam 아래의 패키지는 다 스캔)
 * ComponentScan으로 패키지 설정해주는걸 보면 다른 설정파일을 만들고
 * 컴포넌트 스캔 범위를 다른곳으로 잡고 View Resolver를 선언 안해주면 다른식으로도 리턴이 가능하긴 할듯
 * 나중생각.. 
 */
@Configuration
@EnableWebMvc
@ComponentScan("exam.*")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {				
		//View Resolver 설정 (컨트롤러에서 리턴값 접두사 접미사 설정하여 간단하게 리턴시키는 설정)
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");		//접두사
		viewResolver.setSuffix(".jsp");					//접미사
		viewResolver.setOrder(1);						//우선순위
		return viewResolver;
	}
	@Bean
	public BeanNameViewResolver downloadViewResolver() {
		//이건 파일 다운로드 할때 쓰려고 설정해둔건데.. 안해도 상관없음..
		BeanNameViewResolver downloadViewResolver = new BeanNameViewResolver();
		downloadViewResolver.setOrder(0);
		
		return downloadViewResolver;
	}
	
	@Bean
	public DownloadView download() {
		//이것도 파일 다운로드용으로..
		DownloadView download = new DownloadView();
		download.Download();
		return download;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//리소스 경로 설정해주는것
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	
} // 기타 다른 bean 설정들.. }