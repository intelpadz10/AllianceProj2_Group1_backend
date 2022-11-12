package ph.com.alliance.proj2_group1.common.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

	@GetMapping("")
	public String initScreen() {
		return "What is up my beautiful weebs";
	}

	// dump code used for testing only
	@GetMapping("/hello")
	@ResponseBody
	public String helloworld() {
		return "Hello World";
	}

}