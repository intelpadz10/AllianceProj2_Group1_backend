package ph.com.alliance.proj2_group1.status.service;

import ph.com.alliance.proj2_group1.status.entity.Status;
import ph.com.alliance.proj2_group1.status.repository.StatusRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatusService implements IStatusService {

	@Autowired
	private StatusRepository statusJpaRepository;

	/*
	 * current functions that i can think of. Please ko assist what else can we look
	 * for :)
	 */

	public List<Status> getAllStatus() {

		return statusJpaRepository.findAll();

	}

	public Status getStatusbyID(Integer id) {

		return statusJpaRepository.getReferenceById(id);

	}

}
