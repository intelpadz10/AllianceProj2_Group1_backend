package ph.com.alliance.proj2_group1.fileUplaod.service;

import org.springframework.stereotype.Service;

import ph.com.alliance.proj2_group1.fileUplaod.entity.File;

@Service
public interface IFileService {
	public File saveFileToDB (File file);
}
