package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService service;
	
		

	@PostMapping("/insert")
	public String insert( HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype("USER");
		service.insert(dto);
		setAll(request);
		request.getSession().setAttribute("done", true);
		return "index";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}


