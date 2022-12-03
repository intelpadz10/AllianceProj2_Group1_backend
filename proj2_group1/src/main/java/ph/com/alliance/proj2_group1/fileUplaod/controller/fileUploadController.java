package ph.com.alliance.proj2_group1.fileUplaod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.fileUplaod.message.FileUploadMessages;
import ph.com.alliance.proj2_group1.fileUplaod.service.IFileService;

@RestController
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 40,        // 40 MB
		maxRequestSize = 1024 * 1024 * 30      // 30 MB
		)

public class fileUploadController {
	@Autowired
	IFileService fileService;
	
	public static final String VIEW_PATH = "/NewFile.html";
	private static final String UPLOAD_PATH = "uploads";
//	private FileService fileService;
	
//	public File saveFileToDatabase(File file) 
//	{
//		return fileService.saveFile(file);
//	}
	
	@GetMapping("/sampleUpload")
	public ModelAndView execute() {
		return new ModelAndView(VIEW_PATH);
	}
	
	@PostMapping("/sampleUpload")
	public ApiResponse process(final HttpServletRequest request, MultipartFile file) throws IOException, ServletException
	{
		try {
			final Part part = request.getPart("file");
			part.write(UPLOAD_PATH + getFileName(part));
			
//			saveFileToDatabase(file);
			
			fileService.save(file);
			
			return ApiResponse.CreateSuccess(UPLOAD_PATH+'\''+part.getSubmittedFileName(), FileUploadMessages.FILE_SUCCESSFULLY_SAVED);
		} catch (final IOException | ServletException exception) {
			System.out.println("Message:" + exception.getMessage() + " Cause: " +  exception.getCause());
			
			return ApiResponse.CreateError(FileUploadMessages.GENERIC_UNSUCCESSFUL_SAVE);
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

