package it.contrader.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ClientDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.dto.OrdersDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Client;
import it.contrader.model.Item;
import it.contrader.service.OrdersService;
import it.contrader.service.ClientService;
import it.contrader.service.ItemService;

@Controller
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	private ClientService cservice;
	@Autowired
	private OrdersService service;
	@Autowired
	private ItemService iservice;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request, @RequestParam(value="id",required=false) String id) {
		long idn=Long.parseLong(id);
		ItemDTO artscelto;
		if(idn!=0) {
			artscelto=iservice.read(idn);
			ItemDTO duplicato=new ItemDTO(artscelto.getNome(),artscelto.getDescrizione(), artscelto.getTipo(), artscelto.getColore(), artscelto.getTaglia(),artscelto.getImmagine(),artscelto.getLink(),0);
			iservice.insert(duplicato);
			List<ItemDTO> lista=iservice.getAll();
			idn=(lista.get(lista.size()-1).getId());
			artscelto=iservice.read(idn);
		}
		
		else {
			artscelto=new ItemDTO();
			artscelto.setId(0);
		}
		request.getSession().setAttribute("artscelto", artscelto);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "orders";
		case "USER":
			setAlluser(request,userDTO);	
			return "orders";
		default:
			return "index";
		}
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "orders";
		case "USER":
			
			setAlluser(request,userDTO);	
			return "orders";
		default:
			return "index";
		}
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateorder";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("data") String data,
			@RequestParam("prezzo") String prezzo) {

		OrdersDTO dto = new OrdersDTO();
		dto.setId(id);
		dto.setData(data);
		dto.setPrezzo(prezzo);
		service.update(dto);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "orders";
		case "USER":
			setAlluser(request,userDTO);	
			return "orders";
		default:
			return "index";
		}

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("item") Item item, @RequestParam("client") Client client)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date=dtf.format(now);
		OrdersDTO dto = new OrdersDTO();
		dto.setClient(client);
		dto.setData(date);
		dto.setPrezzo("10");
		dto.setItem(item);
		service.insert(dto);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		switch (userDTO.getUsertype()) {
		case "ADMIN":
			setAll(request);
			return "orders";
		case "USER":
			setAlluser(request,userDTO);	
			return "orders";
		default:
			return "index";
		}
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readorder";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("clist", cservice.getAll());
		request.getSession().setAttribute("list", service.getAll());
	}
	private void setAlluser(HttpServletRequest request,UserDTO userDTO) {
		List<ClientDTO> clist=cservice.findAllByuser(userDTO);
		request.getSession().setAttribute("clist", clist );
		request.getSession().setAttribute("list", service.findByclientIn(clist));
	}
}
