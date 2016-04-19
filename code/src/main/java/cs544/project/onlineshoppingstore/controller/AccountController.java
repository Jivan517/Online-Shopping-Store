package cs544.project.onlineshoppingstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "Account/login";
	}

	@RequestMapping(value = "loginfailed", method = RequestMethod.GET)
	public String loginfailed(Model model) {
		model.addAttribute("error",
				"This username doesn't belong to a registered account in our system. Please check to make sure your username and password is correct!");
		return "Account/login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
		// model.addAttribute("error","Log out successful");
		return "Account/login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logoutuser(Model model) {
		// model.addAttribute("error","true");
		return "Account/login";
	}

}
