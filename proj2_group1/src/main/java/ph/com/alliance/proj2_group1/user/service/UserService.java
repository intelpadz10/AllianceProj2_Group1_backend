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
	
	//user login
	public User login(String email) {
		return userJpaRepository.findByEmail(email);
	}
	
	public User updateUser(User user) {
		System.out.print(user.getUser_id());
		User existingUser = userJpaRepository.findById(user.getUser_id()).get();
		
		existingUser.setUsername(user.getUsername());
		existingUser.setfName(user.getfName());
		existingUser.setlName(user.getlName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		return userJpaRepository.saveAndFlush(existingUser);
	}
}
