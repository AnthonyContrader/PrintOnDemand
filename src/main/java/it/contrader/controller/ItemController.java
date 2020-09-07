package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ItemDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Item;
import it.contrader.service.ItemService;
import it.contrader.service.UserService;
import it.contrader.model.User.Usertype;



@Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService service;
	



	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "items";	

		case "USER":
			setAlluser(request);
			return "itemsuser";	
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
			return "items";	

		case "USER":
			setAlluser(request);
			return "itemsuser";	
		default:
			return "index";
		}
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateitem";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request,
			@RequestParam("nome") String nome,
			@RequestParam("descrizione")String descrizione,
			@RequestParam("tipo") String tipo,
			@RequestParam("colore") String colore,
			@RequestParam("taglia") String taglia,
			//@RequestParam("immagine") byte[] immagine,
			//@RequestParam("link") String link, 
			@RequestParam("id") long id)
{

		ItemDTO dto = new ItemDTO();
		dto.setNome(nome);
		dto.setDescrizione(descrizione);
		dto.setTipo(tipo);
		dto.setColore(colore);
		dto.setTaglia(taglia);
		//dto.setImmagine(immagine);
		//dto.setLink(link);
		dto.setId(id);
		service.update(dto);
		setAll(request);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "items";	

		case "USER":
			setAlluser(request);
			return "itemsuser";	
		default:
			return "index";
		}

	}
	@GetMapping("/precustom")
	public String preCustom(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateorder";
	}
	@PostMapping("/custom")
	public String update(HttpServletRequest request,
			@RequestParam("immagine") String immagine,
			@RequestParam("link") String link, 
			@RequestParam("id") long id)
{
		ItemDTO dto=new ItemDTO();
		dto=service.read(id);
		dto.setImmagine(immagine);
		dto.setLink(link);
		service.update(dto);
		return "orders";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("nome") String nome,
			@RequestParam("descrizione") String descrizione,
			@RequestParam("tipo") String tipo,
			@RequestParam("colore") String colore,
			@RequestParam("taglia") String taglia)
			//@RequestParam("immagine") byte[] immagine,
			//@RequestParam("link") String link) 
	{
		ItemDTO dto = new ItemDTO();
		dto.setNome(nome);
		dto.setDescrizione(descrizione);
		dto.setTipo(tipo);
		dto.setColore(colore);
		dto.setTaglia(taglia);
		//dto.setImmagine(immagine);
		//dto.setLink(link);
		service.insert(dto);
		setAll(request);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "items";	

		case "USER":
			setAlluser(request);
			return "itemsuser";	
		default:
			return "index";
		}
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id, @RequestParam(value="tipo", required = false ) String tipo) {
		if(tipo==null) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readitem";}
		else
		{
		request.getSession().setAttribute("dtol", service.findAllBytipo(tipo));
		return "readitemtipo";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	private void setAlluser(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.findByImmagineAndLink(null,null));
	}
}
