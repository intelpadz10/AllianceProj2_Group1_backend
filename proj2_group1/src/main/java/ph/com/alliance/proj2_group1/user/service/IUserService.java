package ph.com.alliance.proj2_group1.user.service;

import java.util.List;

import ph.com.alliance.proj2_group1.user.entity.User;

public interface IUserService {
	
	public User saveUser(User user);
	public List<User> getAllUsers();
	public User getUserbyID(Integer ID);
	
	
}
