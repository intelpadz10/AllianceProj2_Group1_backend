package ph.com.alliance.proj2_group1.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.user.entity.User;
import ph.com.alliance.proj2_group1.user.message.UserMessages;
import ph.com.alliance.proj2_group1.user.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/signup")
	@ResponseBody
	public ApiResponse save(User user) {
		
		User savedUser = userService.saveUser(user);
		
		if (savedUser != null) {
			return ApiResponse.CreateSuccess(savedUser, UserMessages.USER_SUCCESSFULLY_SAVED);
		}
		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}

	@GetMapping("/user/login")
	public ApiResponse login(
			@RequestParam("email") final String email, 
			@RequestParam("password") final String password)
	{
		User user = userService.login(email, password);
		
		if(user == null) {
			return ApiResponse.CreateError("User does not Exist");
		}
		if(!user.getPassword().equals(password)){
			return ApiResponse.CreateError("Password does not match");
		}
		return ApiResponse.CreateSuccess(user, "Login Successfull");
	}
	
	@GetMapping("/user/all")
	@ResponseBody
	public ApiResponse getAllUsers() {

		List<User> users = userService.getAllUsers();

		if (users != null) {
			return ApiResponse.CreateSuccess(users);
		}
		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	public ApiResponse getUser(@PathVariable final int id) {
		
			User savedUser = userService.getUserbyID(id);
			if (savedUser != null) {
				return ApiResponse.CreateSuccess(savedUser, UserMessages.USER_SUCCESSFULLY_RETRIEVED);
			} else {
				return ApiResponse.CreateError(
						UserMessages.GENERIC_UNSUCCESSFUL_SAVE + " ERROR: ");
			}
			
	}

	@PostMapping(path = "/user/{id}/update")
	@ResponseBody
	public ApiResponse updateUser(@PathVariable int id, User newuser) {

		User savedUser = userService.updateUser(newuser);

		if (savedUser != null) {
				return ApiResponse.CreateSuccess(
						UserMessages.GENERIC_UNSUCCESSFUL_SAVE + " ERROR: " + UserMessages.USER_SUCCESSFULLY_SAVED);
		} else {
			return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_SAVE);
		}
	}
	
	@PostMapping(path = "/forgotpassword")
	@ResponseBody
	public ApiResponse updatePassword(@RequestParam ("email") String email, @RequestParam("password") String password) {

		User savedUser = userService.updatePassword(email, password);

		if (savedUser != null) {
				return ApiResponse.CreateSuccess(savedUser, UserMessages.UPDATEPASS_SUCCESS);
		} else {
			return ApiResponse.CreateError(UserMessages.UPDATEPASS_FAIL);
		}
	}
	
	@DeleteMapping (path = "/user/delete/{id}")
	@ResponseBody
	public ApiResponse deleteUser (@PathVariable Integer id) {
		User user = userService.getUserbyID(id);
		
		if (user != null ) {
			userService.deleteUser(id);
			
			return ApiResponse.CreateSuccess(user, UserMessages.USER_SUCCESSFULLY_DELETED);
		} 
		return ApiResponse.CreateError(UserMessages.USER_DELET_FAILED);
	}
}