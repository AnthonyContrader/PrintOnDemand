 package it.contrader.controller;



import javax.persistence.metamodel.Metamodel;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.UserConverter;
import it.contrader.dao.ClientRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.service.ClientService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService service;
	@Autowired
	private UserService uservice;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "clients";
		case "USER":
			setAlluser(request,userDTO);	
			return "clients";
		default:
			return "index";
		}
		
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
			case "ADMIN":
				setAll(request);
				return "clients";
			case "USER":
				setAlluser(request,userDTO);	
				return "clients";
			default:
				return "index";
		}
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateclient";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("userID") User user, @RequestParam("nome") String nome,
			@RequestParam("cognome") String cognome, @RequestParam("indirizzo") String indirizzo, @RequestParam("id") long id) {

		ClientDTO dto = new ClientDTO();
		dto.setUser(user);
		dto.setNome(nome);
		dto.setCognome(cognome);
		dto.setIndirizzo(indirizzo);
		dto.setId(id);
		service.update(dto);
		setAll(request);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
			case "ADMIN":
				setAll(request);
				return "clients";
			case "USER":
				setAlluser(request,userDTO);	
				return "clients";
			default:
				return "index";
		}

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nome") String nome,
			@RequestParam("cognome") String cognome, @RequestParam("indirizzo") String indirizzo,
			@RequestParam("userID") User user) {
		ClientDTO dto = new ClientDTO();
		//User udto= cv.toEntity(uservice.read(id));
		dto.setUser(user);
		dto.setNome(nome);
		dto.setCognome(cognome);
		dto.setIndirizzo(indirizzo);
		service.insert(dto);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
			case "ADMIN":
				setAll(request);
				return "clients";
			case "USER":
				setAlluser(request,userDTO);	
				return "clients";
			default:
				return "index";
		}
		
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readclient";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}



	private void setAll(HttpServletRequest request) {
			
		request.getSession().setAttribute("list", service.getAll());
	}
	private void setAlluser(HttpServletRequest request,UserDTO userDTO) {
		request.getSession().setAttribute("list", service.findAllByuser(userDTO));
	}
}
