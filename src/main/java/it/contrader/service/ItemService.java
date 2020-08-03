package it.contrader.service;

import java.util.List;

import it.contrader.dao.ItemDAO;
import it.contrader.dto.ItemDTO;
import it.contrader.converter.ItemConverter;



public class ItemService {
	private ItemDAO itemDAO;
	private ItemConverter itemConverter;

	public ItemService()
	{
		this.itemDAO= new ItemDAO();
		this.itemConverter = new ItemConverter();
	}
	
	public List<ItemDTO> getAll() {
		 return itemConverter.toDTOList(itemDAO.getAll());
	}
	
	public ItemDTO read(int id) {
		return itemConverter.toDTO(itemDAO.read(id));
	}
	
	public boolean insert(ItemDTO dto) 
	{
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return itemDAO.insert(itemConverter.toEntity(dto));
	}
	public List<ItemDTO> search(String tipo) {
		 return itemConverter.toDTOList(itemDAO.search(tipo));
	}
	
	
	
	public boolean delete(int id) {
		return itemDAO.delete(id);
	}
}
