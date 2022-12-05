package ph.com.alliance.proj2_group1.fileUplaod.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.fileUplaod.entity.File;

	@Repository
	public interface IFileRepository extends JpaRepository<File, Integer> {}
	