package it.contrader.service;

import it.contrader.converter.ItemConverter;
import it.contrader.dao.ItemDAO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ItemService extends AbstractService<Item, ItemDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ItemService(){
		this.dao = new ItemDAO();
		this.converter = new ItemConverter();
	}
	

}
