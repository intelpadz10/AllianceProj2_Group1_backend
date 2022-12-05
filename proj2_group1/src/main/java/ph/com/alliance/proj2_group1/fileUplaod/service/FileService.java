package ph.com.alliance.proj2_group1.fileUplaod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.alliance.proj2_group1.fileUplaod.entity.File;
import ph.com.alliance.proj2_group1.fileUplaod.repository.IFileRepository;

@Service
public class FileService implements IFileService{
	@Autowired
	private IFileRepository fileJpaRepository;
	
	public File saveFileToDB(File file) {
		return fileJpaRepository.saveAndFlush(file);
	}
}
