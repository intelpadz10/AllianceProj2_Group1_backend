package ph.com.alliance.proj2_group1.user.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.ticket.message.TicketMessages;
import ph.com.alliance.proj2_group1.user.entity.User;
import ph.com.alliance.proj2_group1.user.message.UserMessages;
import ph.com.alliance.proj2_group1.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/signup")
	@ResponseBody
	public ApiResponse save(User user) throws IOException {

		User savedUser = userService.saveUser(user);

		if (savedUser != null) {
			return ApiResponse.CreateSuccess(savedUser, UserMessages.USER_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}

	@GetMapping("/user/all")
	@ResponseBody
	public ApiResponse getAll() {

		List<User> users = userService.getAllUsers();

		if (users != null) {
			return ApiResponse.CreateSuccess(users);
		}

		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_SAVE);

	}

	@PostMapping("/user/login")
	public ApiResponse login(
			@RequestParam("email") final String email, 
			@RequestParam("password") final String password)
	{
		User user = userService.login(email);
		
		if(user == null) {
			return ApiResponse.CreateError("User does not Exist");
		}
		if(!user.getPassword().equals(password)){
			return ApiResponse.CreateError("Password does not match");
		}
		return ApiResponse.CreateSuccess(user, "Login Successfull");
	}
}