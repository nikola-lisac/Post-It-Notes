package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.model.User;
import app.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/register")
	public String showRegister(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String registerUser(User user, BindingResult result){
		if(result.hasErrors()){
			return "register";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(userService.isExisting(user.getUsername())){
			result.rejectValue("username", "DuplicateKey", "Username already exists.");
			return "register";
		}
		
		userService.addUser(user);
		return "login";
	}
}
