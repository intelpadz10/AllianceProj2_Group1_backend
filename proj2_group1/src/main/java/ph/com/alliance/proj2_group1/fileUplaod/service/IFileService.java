package ph.com.alliance.proj2_group1.fileUplaod.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface IFileService {
	public void init();
	public void save (MultipartFile file);
}
