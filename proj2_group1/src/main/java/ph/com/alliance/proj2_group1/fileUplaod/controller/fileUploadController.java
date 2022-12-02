package ph.com.alliance.proj2_group1.fileUplaod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 40,        // 40 MB
		maxRequestSize = 1024 * 1024 * 30      // 30 MB
		)
public class fileUploadController {
	public static final String VIEW_PATH = "/NewFile.html";
	private static final String UPLOAD_PATH = "D:\\uploadhere";
	
	@GetMapping("/sampleUpload")
	public ModelAndView execute()
	{
		return new ModelAndView(VIEW_PATH);
	}
	
	@PostMapping("/sampleUpload")
	public String process(final HttpServletRequest request) throws IOException, ServletException
	{
		try {
			final Part part = request.getPart("file");
			part.write(UPLOAD_PATH + getFileName(part));
			
			return "Upload success";
		} catch (final IOException | ServletException exception) {
			System.out.println("Message:" + exception.getMessage() + " Cause: " +  exception.getCause());
			
			return "Upload failure";
		}
	
	}
	
	private String getFileName(final Part part)
	{
		final String contentDisposition = part.getHeader("content-disposition");
		
		if (!contentDisposition.contains("filename=")) {
			return null;
		}
		
		final int beginIndex = contentDisposition.indexOf("filename=") + 10;
		final int endIndex = contentDisposition.length() - 1;
		
		return contentDisposition.substring(beginIndex, endIndex);
	}
}
