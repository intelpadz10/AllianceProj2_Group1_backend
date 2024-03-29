package ph.com.alliance.proj2_group1.user.service;

import java.util.List;

import ph.com.alliance.proj2_group1.user.entity.User;

public interface IUserService {
	
	public User saveUser(User user);
	public List<User> getAllUsers();
	public User getUserbyID(Integer ID);
	public User updateUser(User user);
	public User login(String email, String password);
	public User updatePassword(String email, String password);
	public void deleteUser(Integer id);
}
