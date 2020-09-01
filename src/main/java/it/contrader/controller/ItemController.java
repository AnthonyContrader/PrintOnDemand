package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ItemDTO;

import it.contrader.service.ItemService;


/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<ItemDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController extends AbstractController<ItemDTO>{
	
	@Autowired
	private ItemService itemService;


	
	@PostMapping(value = "/item")
	public ItemDTO getAll( @RequestBody ItemDTO itemDTO ) {
		return itemService.findById(itemDTO.getId());
	}
}