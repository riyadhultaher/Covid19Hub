package com.casestudy.auth.web;

import com.casestudy.auth.model.State;
import com.casestudy.auth.model.User;
import com.casestudy.auth.service.SecurityService;
import com.casestudy.auth.service.StateService;
import com.casestudy.auth.service.UserService;
import com.casestudy.auth.validator.UserValidator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private StateService stateService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(Model model) {
		List<String> allStates = stateService.addStates();

		model.addAttribute("userForm", new User());
		model.addAttribute("allStates", allStates);
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

		userValidator.validate(userForm, bindingResult);
		userValidator.checkDuplicate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			List<String> allStates = stateService.addStates();
			model.addAttribute("allStates", allStates);
			return "registration";
		}
		State userState = userForm.getStates().get(0);
		userForm.getStates().remove(0);
		userForm.getStates().add(stateService.findByName(userState.getName()));

		userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}

		return "login";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<State> listStates = null;

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			User user = userService.findByUsername(username);
			listStates = user.getStates();
		}

		for (int i = 0; i < listStates.size(); i++) {
			stateService.assignHyperlink(listStates.get(i));
		}
		model.addAttribute("listStates", listStates);

		return "welcome";
	}

	@RequestMapping("/delete")
	public String deleteState(@RequestParam String name) {
		State state = stateService.findByName(name);
		userService.deleteState(state);
		return "redirect:/welcome";
	}

	@GetMapping({ "/options" })
	public String options(Model model) {
		return "options";
	}

	@GetMapping({ "/changePassword" })
	public String changePassword(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = null;

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.findByUsername(username);
		}
		user.setPassword(null);
		model.addAttribute("user", user);

		return "changePassword";
	}

	@PostMapping({ "/changePassword" })
	public String changePassword(@ModelAttribute("user") User user, BindingResult bindingResult,
			@RequestParam("password") String password, @RequestParam("passwordConfirm") String passwordConfirm) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.findByUsername(username);
		}

		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);

		userValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return "changePassword";
		}

		userService.save(user);

		return "redirect:/welcome";
	}

	@GetMapping({ "/addState" })
	public String addState(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<State> listStates = null;
		List<String> allStates = stateService.addStates();
		User user = null;

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.findByUsername(username);
			listStates = user.getStates();
		}

		for (State s : listStates) {
			String stateString = s.getName();
			int newState = allStates.indexOf(stateString);
			allStates.remove(newState);
		}

		model.addAttribute("allStates", allStates);
		model.addAttribute("state", new State());
		return "addState";
	}

	@PostMapping({ "/addState" })
	public String addState(@ModelAttribute State state) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<State> listStates = null;
		User user = null;

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.findByUsername(username);
			listStates = user.getStates();
		}

		State newState = stateService.findByName(state.getName());
		listStates.add(newState);
		userService.update(user);

		return "redirect:/welcome";
	}

	@GetMapping({ "/contact" })
	public String contact(Model model) {
		return "contact";
	}

	@GetMapping({ "/confirmation" })
	public String confirmation(Model model) {
		return "confirmation";
	}

	@GetMapping({ "/about" })
	public String about(Model model) {
		return "about";
	}
}