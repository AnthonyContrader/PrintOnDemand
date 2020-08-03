package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;


public class ItemConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public ItemDTO toDTO(Item item) {
		ItemDTO itemDTO = new ItemDTO(item.getName(), item.getDesc(), item.getItemtype(),item.getColor(),item.getSize(),item.getImage(),item.getQRLink(),item.getId());
		return itemDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Item toEntity(ItemDTO itemDTO) {
		
		Item item = new Item(itemDTO.getName(), itemDTO.getDesc(), itemDTO.getItemtype(),itemDTO.getColor(),itemDTO.getSize(),itemDTO.getImage(),itemDTO.getQRLink(),itemDTO.getId());
		return item;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
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