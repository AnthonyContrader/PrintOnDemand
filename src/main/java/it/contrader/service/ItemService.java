package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ItemConverter;
import it.contrader.dao.ItemRepository;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Service
public class ItemService extends AbstractService<Item, ItemDTO> {

	@Autowired
	private ItemConverter converter;
	@Autowired
	private ItemRepository repository;

	public ItemDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}
	public List<ItemDTO> findByImmagineAndLink(String a, String b) {
		return converter.toDTOList(repository.findAllByImmagineAndLink(a, b) );
	}
	public List<ItemDTO> findAllBytipo(String a) {
		return converter.toDTOList(repository.findAllBytipo(a) );
	}
}
