package ph.com.alliance.proj2_group1.user.service;

import ph.com.alliance.proj2_group1.user.entity.User;
import ph.com.alliance.proj2_group1.user.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userJpaRepository;
	
	//for id creation and update
	public User saveUser(User user) {
		return userJpaRepository.saveAndFlush(user);
	}

	//for finding all user items
	public List<User> getAllUsers() {
		return userJpaRepository.findAll();
	}

	//finding specific user using ID
	public User getUserbyID(Integer id) {
		return userJpaRepository.findById(id).get();
	}
	
	public User updateUser(User user) {
		System.out.print(user.getUser_id());
		User existingUser = userJpaRepository.findById(user.getUser_id()).get();
		
		existingUser.setuser_name(user.getuser_name());
		existingUser.setuser_firstname(user.getuser_firstname());
		existingUser.setuser_lastname(user.getuser_lastname());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		return userJpaRepository.saveAndFlush(existingUser);
	}
	
	//user login
	public User login(String email) {
		return userJpaRepository.findByEmail(email);
	}
	
	@Override
	public User updatePassword(String email, String password) {
//		System.out.print(user.getUser_id());
		
		User existingUser = userJpaRepository.findByEmail(email);
		
		existingUser.setuser_name(existingUser.getuser_name());
		existingUser.setuser_firstname(existingUser.getuser_firstname());
		existingUser.setuser_lastname(existingUser.getuser_lastname());
		existingUser.setEmail(existingUser.getEmail());
		existingUser.setPassword(password);
		
		return userJpaRepository.saveAndFlush(existingUser);
	}
}
