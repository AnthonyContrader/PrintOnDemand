package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class ItemConverter  implements Converter<Item, ItemDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ItemDTO toDTO(Item item) {
		ItemDTO itemDTO = new ItemDTO(item.getName(), item.getDescr(), item.getTipo(), item.getColore(),item.getTaglia(),item.getImmagine(),item.getLink());
		return itemDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Item toEntity(ItemDTO itemDTO) {
		Item item = new Item(itemDTO.getName(), itemDTO.getDescr(), itemDTO.getTipo(), itemDTO.getColore(),itemDTO.getTaglia(),itemDTO.getImmagine(),itemDTO.getLink());
		return item;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<ItemDTO> toDTOList(List<Item> itemList) {
		//Crea una lista vuota.
		List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Item item : itemList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			itemDTOList.add(toDTO(item));
		}
		return itemDTOList;
	}

	
	
}
