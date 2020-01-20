package exam.user.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(DownloadView.class);
	public void Download() {
		setContentType("application/download; utf-8");
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file = (File)model.get("downloadFile");
		logger.info("downloadView --> file.getPath() : " + file.getPath());
		logger.info("downloadView --> file.getName() : " + file.getName());
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		String userAgent = request.getHeader("User-Agent");
		
		boolean ie = userAgent.indexOf("MSIE") > -1;
		
		String fileName = null;
		
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		}else {
			fileName = new String(file.getName().getBytes("utf-8"));
		}
		
		boolean flag = StringUtils.isEmpty(fileName);
		logger.info("filename null ->" + flag);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			
			FileCopyUtils.copy(fis, out);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch(Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		
		out.flush();
	}

}
