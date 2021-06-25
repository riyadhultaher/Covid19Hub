package com.casestudy.auth.web;

import com.casestudy.auth.model.State;
import com.casestudy.auth.model.User;
import com.casestudy.auth.service.SecurityService;
import com.casestudy.auth.service.StateService;
import com.casestudy.auth.service.UserService;
import com.casestudy.auth.utilities.ProgramException;
import com.casestudy.auth.validator.UserValidator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/*
 * The user controller maps all pages to their
 * respective functions.
 */
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

	/*
	 * This mapping occurs when a user clicks on New User. It populates the state
	 * table in the database and sends the user information to the respective JSP
	 * page.
	 */
	@GetMapping("/registration")
	public String registration(Model model) throws ProgramException {

		List<String> allStates = stateService.addStates();

		model.addAttribute("userForm", new User());
		model.addAttribute("allStates", allStates);
		return "registration";
	}

	/*
	 * This mapping takes the user information and binds it into an entity within
	 * the database, as long as there are no binding errors. This will throw an exception
	 * and display a message if there is an error. It then redirects to that specific user's 
	 * homepage.
	 */
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model)
			throws ProgramException {

		userValidator.validate(userForm, bindingResult);
		userValidator.checkDuplicate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			ProgramException e = new ProgramException (null);
			String errorMessage = e.getMessage();
			List<String> allStates = stateService.addStates();
			model.addAttribute("errorMessage", errorMessage);
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

	/*
	 * This mapping is the first page a user is displayed upon loading the program.
	 * It allows them to log into their account and will inform them if their
	 * username or password is invalid, redirecting back to the same page.
	 */
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		return "login";
	}

	/*
	 * This mapping displays the logged in user's homepage. It populates a list of
	 * states based on what the user has chosen.
	 */
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

	/*
	 * This mapping simply deletes a state from that user's account. It is
	 * represented as a button next to that state and redirects back to the homepage
	 * with the updated list.
	 */
	@RequestMapping("/delete")
	public String deleteState(@RequestParam String name) {
		State state = stateService.findByName(name);
		userService.deleteState(state);
		return "redirect:/welcome";
	}

	/*
	 * This mapping presents the options page which allows a user to select to add a
	 * state or change their password.
	 */
	@GetMapping({ "/options" })
	public String options(Model model) {
		return "options";
	}

	/*
	 * This mapping displays textboxes to allow a user to change their password and
	 * confirm that the passwords match. Their password must still fit the Bcrypt
	 * criteria.
	 */
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

	/*
	 * This mapping takes the user's new password and persists the encrypted form
	 * into the database, as long as it fits Bcrypt criteria. This will throw an exception
	 * and display a message if there is an error.It then redirects the user back to the homepage.
	 */
	@PostMapping({ "/changePassword" })
	public String changePassword(@ModelAttribute("user") User user, BindingResult bindingResult,
			@RequestParam("password") String password, @RequestParam("passwordConfirm") String passwordConfirm, Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.findByUsername(username);
		}

		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);

		userValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			ProgramException e = new ProgramException (null);
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", errorMessage);
			
			return "changePassword";
		}

		userService.save(user);

		return "redirect:/welcome";
	}

	/*
	 * This mapping displays a page allowing a user to select a new state to add to
	 * their account from a drop down menu. States that already exist in their
	 * account will not be displayed.
	 */
	@GetMapping({ "/addState" })
	public String addState(Model model) throws ProgramException {
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

	/*
	 * This mapping takes the state that the user selected and adds it to their list
	 * of states. The user will then be redirected to the homepage and displayed
	 * their updated list.
	 */
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

	@GetMapping({ "/deleteAccount" })
	public String deleteAccount(@ModelAttribute("user") User user) {
		userService.delete(user);
		return "redirect:/login";
	}

	/*
	 * This mapping takes a user to the contact page where they can input their
	 * email into a basic form. The email is not actually received anywhere.
	 */
	@GetMapping({ "/contact" })
	public String contact(Model model) {
		return "contact";
	}

	/*
	 * This mapping is displayed after a user submits from the contact page. It
	 * displays a table of contributers. The values from the previous page do not
	 * actually go anywhere.
	 */
	@GetMapping({ "/confirmation" })
	public String confirmation(Model model) {
		return "confirmation";
	}

	/*
	 * This mapping shows a static page that gives more information regarding the
	 * project.
	 */
	@GetMapping({ "/about" })
	public String about(Model model) {
		return "about";
	}
}