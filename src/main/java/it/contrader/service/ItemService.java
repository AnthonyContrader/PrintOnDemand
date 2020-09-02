package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ItemRepository;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;


@Service
public class ItemService extends AbstractService<Item,ItemDTO> {
	
	public ItemDTO findById(long id) {
		return converter.toDTO(((ItemRepository)repository).findById(id));
	}
	
	
	
	//CRUD + search by type

}
