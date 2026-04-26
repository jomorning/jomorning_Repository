package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.User;
import com.example.exception.UserNumberException;
import com.example.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "loginForm";
	}

	@GetMapping("/users")
	public String getAllUsers(@RequestParam(required = false, value = "userCountry") String userCountry,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "limit", defaultValue = "3") int limit, Model model) {

		int countAll = userService.countAll();
		int startNum = limit * (pageNum - 1);
		int totalPages = (countAll % limit) == 0 ? countAll / limit : (countAll % limit) + 1;

		List<User> list;

		if (userCountry == null || userCountry.trim().isEmpty()) {
			list = userService.getAllUsers(startNum, limit);
		} else {
			list = userService.getUsersByCountry(startNum, limit, userCountry);
		}

		model.addAttribute("userList", list);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPages", totalPages);
		return "users";
	}

	@GetMapping("/users/{userNumber}")
	public String getUserByNumber(@PathVariable("userNumber") int userNumber, Model model) {
		User userByNumber = userService.getUserByNumber(userNumber);
		model.addAttribute("one", userByNumber);
		return "user";
	}
	
	/* @ExceptionHandler(value={UserNumberException.class})
	public ModelAndView handleError(HttpServletRequest req, UserNumberException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidUserNumber", exception.getUserNumber());
		mav.addObject("exception", exception);
		mav.addObject("url1", req.getRequestURL());
		mav.addObject("url2", req.getQueryString());
		mav.setViewName("errorUserNumber");
		return mav;
	} */
	

	@GetMapping("/users/range")
	public String getUsersByRange(@RequestParam("minNum") int minNum, @RequestParam("maxNum") int maxNum, Model model) {
		List<User> usersByRange = userService.getUsersByRange(minNum, maxNum);
		model.addAttribute("userList", usersByRange);
		return "users";
	}

	@GetMapping("/users/new")
	public String getAddUserForm(@ModelAttribute("addUser") User addUser) {
		return "addUser";
	}

	@PostMapping("/users")
	public String setAddUserForm(@ModelAttribute("addUser") User addUser) {
		userService.setAddUser(addUser);
		return "redirect:/users";
	}

	@GetMapping("/users/{userNumber}/edit")
	public String getEditUserForm(@PathVariable("userNumber") int userNumber, Model model) {
		User userByNumber = userService.getUserByNumber(userNumber);
		model.addAttribute("editUser", userByNumber);
		return "editUser";
	}

	@PutMapping("/users/{userNumber}")
	public String setEditUserForm(@ModelAttribute("editUser") User editUser) {
		userService.setEditUser(editUser);
		return "redirect:/users/" + editUser.getUserNumber();
	}

	@DeleteMapping("/users/{userNumber}")
	public String setDeleteUserByNumber(@PathVariable("userNumber") int userNumber) {
		userService.setDeleteUserByNumber(userNumber);
		return "redirect:/users";
	}
	
}
