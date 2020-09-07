package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ItemDTO;

import it.contrader.model.Item;

@Component
public class ItemConverter extends AbstractConverter<Item, ItemDTO> {

	@Override
	public Item toEntity(ItemDTO itemDTO) {
		Item item = null;
		if (itemDTO != null) {
			item = new Item(itemDTO.getNome(), itemDTO.getDescrizione(),itemDTO.getTipo(), itemDTO.getColore(),itemDTO.getTaglia(),itemDTO.getImmagine(),itemDTO.getLink(),itemDTO.getId());
		}
		return item;
	}

	@Override
	public ItemDTO toDTO(Item item) {
		ItemDTO itemDTO = null;
		if (item != null) {
			itemDTO = new ItemDTO(item.getNome(), item.getDescrizione(), item.getTipo(), item.getColore(), item.getTaglia(),item.getImmagine(),item.getLink(),item.getId());

		}
		return itemDTO;
	}
}