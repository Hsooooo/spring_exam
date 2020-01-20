package exam.user.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CrawlingUtil {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingUtil.class);
	public static String getHtml(String url) {
		try {
			URL targetUrl = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream(),"UTF-8"));
			StringBuilder html = new StringBuilder();
			String current = "";
			while((current = reader.readLine()) != null) {
				
				html.append(current);
			}
			
			reader.close();
			return html.toString();
		}catch(MalformedURLException e) {
			logger.error(e.getMessage());
		}catch(IOException e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}
	
	public static Map<String, Object> parseJsonToMap(String json){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, new TypeReference<Map<String, Object>>(){
				
			});
		}catch(JsonParseException e) {
			logger.error(e.getMessage());
		}catch(JsonMappingException e) {
			logger.error(e.getMessage());
		}catch(IOException e) {
			logger.error(e.getMessage());
		}
		return new HashMap<String, Object>();
	}
}
