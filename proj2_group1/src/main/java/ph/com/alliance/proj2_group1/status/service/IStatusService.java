package ph.com.alliance.proj2_group1.status.service;

import java.util.List;

import ph.com.alliance.proj2_group1.status.entity.Status;

public interface IStatusService {
	
	public List<Status> loadValues(); 
	public Status loadValue(Integer id);

}
