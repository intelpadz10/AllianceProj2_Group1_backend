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

	public User saveUser(User user) {
		return userJpaRepository.saveAndFlush(user);
	}
	
	
	public List<User> findAllUsers() {
		
		return userJpaRepository.findAll();
		
	}
	
	public User findUserbyID (int ID) {
		
		return userJpaRepository.getReferenceById(ID);
		s
	}
}
