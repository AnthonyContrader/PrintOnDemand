package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ItemRepository;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class ItemService extends AbstractService<Item,ItemDTO> {
	
	public ItemDTO findById(long id) {
		return converter.toDTO(((ItemRepository)repository).findById(id));
	}

}
